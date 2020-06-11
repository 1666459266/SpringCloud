# 项目构建顺序
## 1.springcloud-payment8001 支付服务
## 2.springcloud-order80 订单服务调用支付服务接口 Ribbon负载均衡 自定义轮询算法
## 3.springcloud-api-commons 抽取公共部分
## 4.springcloud-eureka-server7001 Eureka Server单机和集群
## 5.springcloud-eureka-server7002 Eureka Server单机和集群
## 6.springcloud-eureka-server7003 Eureka Server单机和集群
## 7.springcloud-payment8002 服务集群配置
## 8.springcloud-payment-zookeeper8001 支付服务注册进Zookeeper
## 9.springcloud-order-zookeeper80 订单服务注册进Zookeeper
## 10.springcloud-payment-consul8001 支付服务注册进Consul
## 11.springcloud-order-consul80 订单服务注册进Consul
## 12.springcloud-order-feign80 整合openfeign实现负载均衡
## 13.springcloud-payment-hystrix8001 支付服务整合Hystrix实现服务降级 熔断
## 14.springcloud-order-hystrix80 订单服务整合Hystrix实现服务降级 熔断
## 15.springcloud-hystrix-dashboard9001 Hystrix dashboard
## 16.springcloud-gateway9527 Gateway配置网关
## 17.springcloud-config-center3344 服务端Config配置中心 RabbitMQ+Bus
## 18.springcloud-config-client3355 客户端Config配置中心 RabbitMQ+Bus
## 19.springcloud-config-client3366 客户端Config配置中心 RabbitMQ+Bus
## 20.springcloud-stream-provider8801 Stream生产者发送消息模块
## 21.springcloud-stream-consumer8802 Stream消费者接受消息模块
## 22.springcloud-stream-consumer8803 Stream消费者接着消息模块 重复消费和持久化
## 23.springcloud-sleuth-provider8001 服务端Sleuth链路监控+zipkin
## 24.springcloud-sleuth-consumer80 客户端Sleuth链路监控+zipkin
## 25.springcloud-alibaba-payment-nacos9001 支付服务注册进Nacos（服务集群）
## 26.springcloud-alibaba-payment-nacos9002 支付服务注册进Nacos（服务集群）
## 27.springcloud-alibaba-order-nacos80 订单服务注册进Nacos
## 28.springcloud-alibaba-config-nacos-client3377 Nacos服务配置中心+Nacos集群
## 29.springcloud-alibaba-sentinel-service8401 Sentinel做服务限流降级熔断+持久化
## 30.springcloud-alibaba-payment-sentinel9003 Sentinel+Ribbon+Fallback
## 31.springcloud-alibaba-payment-sentinel9004 Sentinel+Ribbon+Fallback
## 32.springcloud-alibaba-order-sentinel80 Sentinel+Feign+Fallback
## 33.springcloud-alibaba-seata-order2001 Seata订单模块
## 34.springcloud-alibaba-seata-storage2002 Seata库存模块
## 35.springcloud-alibaba-seata-account2003 Seata用户模块