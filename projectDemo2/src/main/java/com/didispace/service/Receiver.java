package com.didispace.service;

import com.didispace.Application;
import com.didispace.domain.s.BackInfo;
import com.didispace.domain.s.Message;
import com.didispace.domain.s.User;
import com.didispace.repository.BackInfoRepository;
import com.didispace.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by Administrator on 2017/9/7 0007.
 */


/**
 * 消息者
 * 接收到消息 根据消息内容处理本地业务
 * 保证数据的幂等性
 * 业务执行完毕 调用对方接口删除对应的消息
 */
@Component
public class Receiver {
    @Autowired
    UserRepository userRepository;
    @Autowired
    BackInfoRepository backInfoRepository;
    @Autowired
    RestTemplate restTemplate;


    @RabbitHandler
    @RabbitListener(queues = Application.Queue)
    public void process(String msg) {
            System.out.println("Receiver : " + msg);

            ObjectMapper mapper = new ObjectMapper();
            Message message=new Message();
            try {
                message= mapper.readValue(msg,Message.class);
            }catch (Exception e){
                e.printStackTrace();
            }

            String us=message.getMessageBody();
            User user=new User();
            try {
                user = mapper.readValue(us, User.class);
            } catch (Exception e){
                e.printStackTrace();
            }

            //判断消息id和业务id是否在本地存在 存在直接返回
            List<BackInfo> list= backInfoRepository.findByName1(message.getId().toString(),user.getId().toString());
            if(list==null || list.size()==0){
                //插入本地业务数据
                String msgId=insertLocalData(message,user);

                //业务完成 调用对方接口删除消息表的对应消息
                String url="http://SERVICE-PROJECTDEMO1/msg/delete?id="+msgId;
                getgetURLContent(url);
                //HttpURLContent.getURLContent(url);

            }

    }

    private String insertLocalData(Message message,User user ) {

            userRepository.save(user);
            try {
                //int n=1/0;
            }catch (Exception e){
                throw new RuntimeException();
            }

            BackInfo backInfo=new BackInfo();
            backInfo.setMsgId(message.getId().toString());
            backInfo.setUid(user.getId().toString());


            //记录消息id保存
            backInfoRepository.save(backInfo);

            return backInfo.getMsgId();

    }



    @HystrixCommand(fallbackMethod = "hiError")
    public String getgetURLContent(String url) {
        String result=restTemplate.getForObject(url,String.class);
        return result;
    }

    public String hiError(String name) {
        return "hi,"+name+",sorry,error!";
    }
}
