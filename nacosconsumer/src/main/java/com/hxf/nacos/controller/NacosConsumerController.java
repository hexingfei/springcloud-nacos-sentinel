package com.hxf.nacos.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.hxf.nacos.config.NacosConfig;
import com.hxf.nacos.service.HelloSentinelDemo;
import com.hxf.nacos.service.NacosProviderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xfhe on 2019/11/13.
 *
 * @description
 */
@RestController
public class NacosConsumerController
{

    @Autowired
    HelloSentinelDemo helloSentinelDemo;

    @Autowired
    NacosConfig nacosConfig;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    @SentinelResource(value = "/hello", blockHandler = "exceptionHandler",fallback = "helloFallback")
    public String getName(@RequestParam(name = "name")String name ){


        return helloSentinelDemo.hello(name);
    }
//
//    @RequestMapping(value = "/people",method = RequestMethod.GET)
//    public String getPe(@RequestParam(name = "name")String name,@RequestParam(name = "sex")String sex,@RequestParam(name = "size")long size){
//
//
//        return nacosProviderClient.getPe(name,sex,size);
//    }


    public String  helloFallback(String name){


        return "is error";
    }

    // Block 异常处理函数，参数最后多一个 BlockException，其余与原函数一致.
    public String exceptionHandler(long s, BlockException ex) {
        // Do some log here.
        ex.printStackTrace();
        return "Oops, error occurred at " + s;
    }

    @RequestMapping(value = "/getConfig",method =RequestMethod.GET )
    @SentinelResource(value = "/getConfig", blockHandler = "exceptionHandler",fallback = "helloFallback")
    public String getConfig(){


        return nacosConfig.getUserName()+":"+nacosConfig.getAppName();
    }
}
