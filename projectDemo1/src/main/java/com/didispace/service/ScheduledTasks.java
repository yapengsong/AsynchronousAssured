package com.didispace.service;

import com.didispace.Application;
import com.didispace.domain.p.Message;
import com.didispace.enums.IsDead;
import com.didispace.enums.MessageStatus;
import com.didispace.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 消息重发
 * 把 未死亡的状态为待发送的消息 每隔3分钟重发一次 超过5次把消息置为死亡状态
 */
@Component
@EnableScheduling
public class ScheduledTasks {


    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    @Autowired
    MessageRepository messageRepository;
    @Autowired
    MessageService messageService;

    //每隔3分钟 读消息表 把未死的消息重新发送  次数超过5改为死亡状态
    @Scheduled(fixedRate = 180000)
    public void reportCurrentTime() {

        System.out.println("当前时间：" + dateFormat.format(new Date())+" --监控消息表");
        List<Message> list=messageRepository.findByAreadlydeadAndStatus(IsDead.NoDead.getValue(), MessageStatus.waitSend.getValue());//后期改造 根据条件过滤 -未死亡 状态为待发送

        for (Message m: list){
            String idDead=m.getAreadlydead();
            int sendTimes=m.getMessageSendTimes();
            if(IsDead.NoDead.getValue().equals(idDead)){
                if(Application.MAX_SEND>sendTimes){
                    //重发
                    messageService.send(m);


                }else {
                    //超过最大重发次数设置为已死亡
                    m.setAreadlydead(IsDead.AreadlyDead.getValue());
                    messageRepository.save(m);
                }

            }

        }

    }




}
