package com.springcloud.core.controller;

import com.springcloud.core.service.MyMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendMessageController {

    @Autowired
    private MyMessageProvider myMessageProvider;

    @GetMapping(value = "/sendMessage")
    private String sendMessage(){
        return myMessageProvider.send();
    }

}
