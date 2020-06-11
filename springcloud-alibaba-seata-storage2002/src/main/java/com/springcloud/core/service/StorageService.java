package com.springcloud.core.service;

public interface StorageService {

    /**
     * 扣减库存
     */
    void decrease(Long productId, Integer count);

}