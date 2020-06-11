package com.springcloud.core.service.serviceimpl;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.springcloud.core.service.PaymentService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class PaymentServiceImpl implements PaymentService {

    //服务降级
    @Override
    public String paymentOK(Integer id) {
        return "线程池" + Thread.currentThread().getName() + "paymentOK,id = " + id;
    }

    /**
     * @HystrixCommand 单独的线程池做处理 有一定的隔离效果
     * fallbackMethod 一旦调用服务方法失败并抛出错误信息后 会自动调用@HystrixCommand标注好的fallbackMethod调用类中指定的方法
     * commandProperties 规定三秒之内是正常逻辑 否则指定fallbackMethod指定的方法
     * 当前服务不可用 做服务降级 处理异常都是fallbackMethod指定的方法
     */
    @HystrixCommand(fallbackMethod = "paymentTimeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    @Override
    public String paymentTimeOut(Integer id) {
        //int age = 10 /0;
        int timeNumber = 3;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池" + Thread.currentThread().getName() + "paymentTimeOut,id = " + id + "耗时 = " + timeNumber;
    }

    public String paymentTimeOutHandler(Integer id){
        return "线程池" + Thread.currentThread().getName() + "paymentTimeOutHandler,id = " + id;
    }

    //服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),// 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),// 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),// 失败率达到多少后跳闸
            //在10秒内请求10次 失败率达到60% 则开启断路器
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if(id < 0) {
            throw new RuntimeException("******id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();//等价于UUID.randomUUID().toString();
        return Thread.currentThread().getName()+"\t"+"调用成功，流水号: " + serialNumber;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id) {
        return "id 不能负数，请稍后再试，/(ㄒoㄒ)/~~   id: " +id;
    }

}
