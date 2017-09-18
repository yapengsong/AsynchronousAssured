package com.didispace.service;

import com.didispace.domain.p.Message;
import com.didispace.domain.p.User;
import com.didispace.enums.IsDead;
import com.didispace.enums.MessageStatus;
import com.didispace.repository.MessageRepository;
import com.didispace.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    MessageRepository messageRepository;
    @Autowired
    MessageService messageService;

    //存本地数据 存消息数据
    /**
     * 处理本地业务
     * 向消息表记录一条待确认的消息
     */
    public Message asynchronousAssured(User user) {

            userRepository.save(user);

            //设置mesage的状态为待发送
            //把内容转成json
            Message message = new Message();
            ObjectMapper mapper = new ObjectMapper();
            String u="";
            try {
                u= mapper.writeValueAsString(user);
            }catch (Exception e){
                throw new RuntimeException();
            }

            message.setMessageBody(u);
            //message.setStatus(MessageStatus.waitConfirmed.getValue());
            System.out.println(MessageStatus.waitSend.getValue());
            message.setMessageSendTimes(0);
            message.setAreadlydead(IsDead.NoDead.getValue());
            //LOG.info("==>保存消息数据");
            messageRepository.save(message);

            return message;

    }
    @Transactional
    public void saveUser(User user) {
        //处理本地业务
        Message message=asynchronousAssured(user);
        //封装消息数据发送消息
        messageService.send(message);
    }
}
