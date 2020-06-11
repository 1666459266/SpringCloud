package com.springcloud.core.controller;

import com.springcloud.core.entity.CommonResult;
import com.springcloud.core.entity.Payment;
import com.springcloud.core.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;
    @Value("${server.port}")//读取配置文件中的server.port
    private String serverPort;
    @Autowired//可以通过服务发现来获得该服务信息
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/add")
    //@RequestBody 接受请求体的数据 否则将执行成功数据库却无数据
    public CommonResult add(@RequestBody Payment payment){
        int result = paymentService.add(payment);
        log.info("添加结果 " + result);
        if (result > 0) {
            return new CommonResult(200,"添加数据成功,serverPort:" + serverPort,result);
        } else {
            return new CommonResult(500,"添加数据失败",result);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询结果 " + payment);
        if (payment != null) {
            return new CommonResult(200,"查询成功,serverPort:" + serverPort,payment);
        } else {
            return new CommonResult(500,"没有对应记录 查询ID:" + id,null);
        }
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();//获取服务清单列表
        for (String element : services) {
            log.info("element : " + element);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("SPRINGCLOUD-PAYMENT");//获取实例（对外暴露的微服务名称）
        for (ServiceInstance instance : instances){
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }

    //超时程序
    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }

}
