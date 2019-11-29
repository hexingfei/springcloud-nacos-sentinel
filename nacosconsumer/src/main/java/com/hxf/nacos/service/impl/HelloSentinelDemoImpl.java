package com.hxf.nacos.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.hxf.nacos.service.HelloSentinelDemo;
import com.hxf.nacos.service.NacosProviderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xfhe on 2019/11/20.
 *
 * @description
 */
@Service
public class HelloSentinelDemoImpl implements HelloSentinelDemo
{

    @Autowired
    NacosProviderClient nacosProviderClient;

    @Override
    public String hello(String name)
    {
        return nacosProviderClient.sayHello(name);
    }


}
