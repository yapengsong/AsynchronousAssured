package com.didispace.service;

import com.didispace.Application;
import com.didispace.domain.p.Message;
import com.didispace.enums.IsDead;
import com.didispace.repository.MessageRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/9/11 0011.
 */
@Service
public class MessageService {
    @Autowired
    MessageRepository messageRepository;
    @Autowired
    Sender sender;
    @Autowired
    ObjectMapper mapper;

    //根据id删除 消息
    public void delete(Long id){
        messageRepository.delete(id);
    }

    //发送消息 每发送一条消息 重发次数加1
    public void send(Message message){

            message.setMessageSendTimes(message.getMessageSendTimes()+1);
            if(message.getMessageSendTimes()==Application.MAX_SEND){
                message.setAreadlydead(IsDead.AreadlyDead.getValue());
            }
            messageRepository.save(message);
            String m="";
            try {
                m = mapper.writeValueAsString(message);
            }catch (Exception e){
                throw new RuntimeException();
            }
            try {
                sender.send(Application.Queue,m);
            }catch (Exception e){
                e.printStackTrace();
            }

    }


    public List<Message> findAll() {
        List<Message> messages= messageRepository.findAll();
        return messages;
    }

    public Message againSend(String msgId) {
       Message message= messageRepository.findOne(new Long (msgId));
       send(message);
       return message;
    }
}
