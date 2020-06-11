package com.springcloud.core.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA(){
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB(){
        return "------testB";
    }

    @GetMapping("/testC")
    public String testC(){
//        try {
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } //测试RT
//        int age = 10/0; //测试异常比例
        return "------testC";
    }

    @GetMapping("/testD")
    public String testD(){
        int age = 10/0; //测试异常数
        return "------testD";
    }

    /**
     * @SentinelResource 主管控制台出错 运行时出错依旧会报异常
     * value值为任意值但必须唯一
     * blockHandler如果违背了在控制台中配置的规则 则调用指定的方法
     */
    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1,@RequestParam(value = "p1",required = false) String p2){
        return "------testHotKey";
    }

    public String deal_testHotKey(String p1, String p2, BlockException exception){
        return "------deal_testHotKey";
    }

}
