package cn.zuul.server.biz;

import cn.zuul.server.config.NacosConfig;
import cn.zuul.server.entity.ZuulRouteEntity;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.PropertyKeyConst;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.client.utils.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Created by xfhe on 2019/12/3.
 *
 * @description
 */
@Component
public class PropertiesAssemble
{
    @Autowired
    NacosConfig nacosConfig;

    public Map<String, ZuulProperties.ZuulRoute> getProperties() {
        Map<String, ZuulProperties.ZuulRoute> routes = new LinkedHashMap<>();
        System.out.println("**********"+nacosConfig.getPrefix()+nacosConfig.getFileExtension()+"***************");

        List<ZuulRouteEntity> results = listenerNacos(nacosConfig.getPrefix()+"."+nacosConfig.getFileExtension(),nacosConfig.getGroup());
        for (ZuulRouteEntity result : results) {
            if (StringUtils.isBlank(result.getPath())
					|| StringUtils.isBlank(result.getUrl())) {
                continue;
            }
            ZuulProperties.ZuulRoute zuulRoute = new ZuulProperties.ZuulRoute();
            try {
                BeanUtils.copyProperties(result, zuulRoute);
            } catch (Exception e) {
            }
            routes.put(zuulRoute.getPath(), zuulRoute);
        }
        return routes;
    }

    private List<ZuulRouteEntity> listenerNacos (String dataId, String group) {
        try {
            Properties properties = new Properties();
            properties.put(PropertyKeyConst.SERVER_ADDR, "localhost:8848");
            ConfigService configService = NacosFactory.createConfigService(properties);
            String content = configService.getConfig(dataId, group, 5000);
            System.out.println("从Nacos返回的配置：" + content);
            //注册Nacos配置更新监听器
//            configService.addListener(dataId, group, new Listener()  {
//                @Override
//                public void receiveConfigInfo(String configInfo) {
//                    System.out.println("Nacos更新了！");
//
//                }
//                @Override
//                public Executor getExecutor() {
//                    return null;
//                }
//            });
            return JSONObject.parseArray(content, ZuulRouteEntity.class);
        } catch (NacosException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
