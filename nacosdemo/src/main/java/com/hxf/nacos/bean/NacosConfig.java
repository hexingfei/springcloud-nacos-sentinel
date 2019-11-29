package com.hxf.nacos.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * Created by xfhe on 2019/11/25.
 *
 * @description
 */
@RefreshScope
@Component
public class NacosConfig
{
    @Value("${json:{}}")
    private String json;

    public String getJson()
    {
        return json;
    }
}
