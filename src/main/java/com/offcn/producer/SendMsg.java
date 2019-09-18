package com.offcn.producer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class SendMsg {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @RequestMapping("/sendmsg")
    @ResponseBody
    public String send(){
        jmsMessagingTemplate.convertAndSend("queue-offcn","hello jms!");
        return "send success";
    }

    //send map
    @RequestMapping("/sendmap")
    @ResponseBody
    public String sendMap(){
        Map map=new HashMap();
        map.put("id","001");
        map.put("name","tom");
        map.put("age","18");
        jmsMessagingTemplate.convertAndSend("queue-map",map);
        return "send success";
    }
}
