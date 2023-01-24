package com.atguigu.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.service.HelloService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date: 2023/1/24 17:02
 * @Auther: Kakarotelu
 * @Description:
 */
@RestController //相当于Controller + ResponseBody
@RequestMapping("/demo")
public class HelloController {

    //@Autowired 这里不用是因为这个注解是从当前IOC容器中注入bean对象，但是此时调用容器中没有对象
    @Reference //引用远程服务对象，（从Zookeeper）进行远程调用
    private HelloService helloService; //代理对象，通过消费者的HelloService与提供者的相同的HelloService进行调用了消费者当中的HelloServiceImpl，后续优化

    @RequestMapping("/hello")
    @ResponseBody
    public String getName(String name){
        //远程调用
        String result = helloService.sayHello(name); //调用远程接口 RPC
        System.out.println(result);
        return result;
    }
}

