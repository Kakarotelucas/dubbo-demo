package com.atguigu.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.service.HelloService;

/**
 * @Date: 2023/1/24 14:14
 * @Auther: Kakarotelu
 * @Description:
 */
@Service //注意这里要选择 Dubbo 的包
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        return "hello " + name;
    }
}

