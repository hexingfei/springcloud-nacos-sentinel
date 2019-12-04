package cn.zuul.server.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by xfhe on 2019/12/3.
 *
 * @description
 */
@Component
public class NacosConfig
{
    @Value("${spring.cloud.nacos.config.server-addr}")
    private String addr;

    @Value("${spring.cloud.nacos.config.prefix}")
    private String prefix;

    @Value("${spring.cloud.nacos.config.group}")
    private String group;
    @Value("${spring.cloud.nacos.config.file-extension}")
    private String fileExtension;

    public String getAddr()
    {
        return addr;
    }

    public String getPrefix()
    {
        return prefix;
    }

    public String getGroup()
    {
        return group;
    }

    public String getFileExtension()
    {
        return fileExtension;
    }
}
