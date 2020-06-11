package com.springcloud.core.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.springcloud.core.entity.CommonResult;
import com.springcloud.core.entity.Payment;
import com.springcloud.core.hanlder.CustomerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RateLimitController {

    //按资源名称限流 SentinelResource的value
    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler = "handleException")
    public CommonResult byResource(){
        return new CommonResult(200,"资源名称限流测试",new Payment(2020L,"serial"));
    }

    public CommonResult handleException(BlockException exception){
        return new CommonResult(500,exception.getClass().getCanonicalName()+"\t 服务不可用");
    }

    //按URL地址限流 GetMapping的value
    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult byUrl(){
        return new CommonResult(200,"URL限流测试",new Payment(2020L,"serial"));
    }

    /**
     * blockHandlerClass 指定自定义处理异常的类
     */
    //客户自定义 创建CustomerBlockHandler类用于自定义限流处理逻辑
    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",blockHandlerClass = CustomerBlockHandler.class,blockHandler = "handlerException2")
    public CommonResult customerBlockHandler(){
        return new CommonResult(200,"客户自定义",new Payment(2020L,"serial"));
    }

}
