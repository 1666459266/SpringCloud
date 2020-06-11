package com.springcloud.core.dao;

import com.springcloud.core.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {

     public int add(Payment payment);

     public Payment getPaymentById(@Param("id") Long id);

}
