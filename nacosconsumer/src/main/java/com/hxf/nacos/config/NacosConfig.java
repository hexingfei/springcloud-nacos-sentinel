package com.hxf.nacos.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * Created by xfhe on 2019/11/25.
 *
 * @description
 */
@Component
@RefreshScope
public class NacosConfig
{


    @Value("${userName::lili}")
    private String userName;


    @Value("${appName::nacosConsumer}")
    private String appName;

    public  String getUserName()
    {
        return userName;
    }

    public String getAppName()
    {
        return appName;
    }
}
