package com.hxf.nacos.service;


import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by xfhe on 2019/11/13.
 *
 * @description
 */
@FeignClient("nacosprovider")
public interface NacosProviderClient
{
    @RequestMapping(value = "/providerName", method = RequestMethod.POST)
    String sayHello(@RequestParam(name = "name") String name);

    @RequestMapping(value = "/people", method = RequestMethod.POST)
    String getPe(@RequestParam(name = "sex") String sex, @RequestParam(name = "name") String name,
        @RequestParam(name = "size") long size);



}