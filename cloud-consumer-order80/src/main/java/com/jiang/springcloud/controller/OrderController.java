package com.jiang.springcloud.controller;


import com.jiang.springcloud.entities.CommonResult;
import com.jiang.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;



import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {

    //private static final String PAYMENT_URL="http://localhost:8001";
    private static final String PAYMENT_URL="http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;
    /** 
     * @MethodName: create
     * @Description: RestTemplate提供了多种便捷访问远程Http服务的方法，是一种简单便捷的访问restful服务模板类，
     *     是Spring提供的用于访问Rest服务的客户端模板工具集，实现80到8001的远程调用。
     * @Param: [payment]
     * @Return: com.jiang.springcloud.entities.CommonResult<com.jiang.springcloud.entities.Payment>
     * @Author: Administrator
     * @Date: 2020/3/16
    **/
    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }

}