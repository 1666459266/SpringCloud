package com.springcloud.core.hanlder;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.springcloud.core.entity.CommonResult;

//创建CustomerBlockHandler类用于自定义限流处理逻辑 方法必须为static
public class CustomerBlockHandler {

    public static CommonResult handlerException1(BlockException exception){
        return new CommonResult(500,"按客户自定义 handlerException1");
    }

    public static CommonResult handlerException2(BlockException exception){
        return new CommonResult(500,"按客户自定义 handlerException2");
    }

}
