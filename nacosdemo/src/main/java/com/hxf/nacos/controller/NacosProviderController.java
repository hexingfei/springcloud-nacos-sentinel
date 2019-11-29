package com.hxf.nacos.controller;

import com.hxf.nacos.bean.NacosConfig;
import com.hxf.nacos.bean.People;
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
public class NacosProviderController
{
    @Autowired
    NacosConfig nacosConfig;

    @RequestMapping(value = "/providerName",method = RequestMethod.POST)
    public String sayHello(@RequestParam(name = "name") String name)
    {

        return "hi" + name + "!!"+nacosConfig.getJson();
    }

    @RequestMapping(value = "/people",method = RequestMethod.POST)
    public People getPe(@RequestParam(name = "sex")String sex,@RequestParam(name = "name")String name,@RequestParam(name = "size")long size){

        People people=new People();

        people.setName(name+"hi!!"+nacosConfig.getJson());
        people.setSex(sex);
        people.setSize(size);

        return people;

    }
}
