package com.offcn.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ReciverMsg {

    @JmsListener(destination = "queue-offcn")
    public  void reciverMsg(String msg){
        System.out.println("reciver:"+msg);
    }

    @JmsListener(destination = "queue-map")
    public  void reciverMap(Map map){
        System.out.println("id:"+map.get("id")+"name:"+map.get("name")+"age:"+map.get("age"));
    }
}
