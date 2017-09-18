package com.didispace.controller;

import com.didispace.domain.p.Message;
import com.didispace.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/11 0011.
 */
@Controller
@RequestMapping("/msg")
public class MessageController {

    @Autowired
    MessageService messageService;
    @Value("${server.port}")
    String port;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delMsgById(String id){
        messageService.delete(new Long(id));
        return "message delete success! [id]:"+id+",i am from port:"+port;
    }

    @RequestMapping("/againSend")
    @ResponseBody
    public Map<String, Object> againSend(String id){
        Map<String, Object> result = new HashMap<>();
        Message message=messageService.againSend(id);
        result.put("id", message.getId());
        return result;
    }
    @RequestMapping("/findAll")
    @ResponseBody
    public Object findAll(){
        List<Message> messages= messageService.findAll();
        return messages;

    }

    @RequestMapping("/save")
    @ResponseBody
    public Object save(){
        //messageService.delete(new Long(msgId));
        return null;
    }

}
