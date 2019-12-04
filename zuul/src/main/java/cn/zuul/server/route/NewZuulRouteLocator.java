package cn.zuul.server.route;

import cn.zuul.server.biz.PropertiesAssemble;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.RefreshableRouteLocator;
import org.springframework.cloud.netflix.zuul.filters.SimpleRouteLocator;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.util.StringUtils;

import java.util.LinkedHashMap;
import java.util.Map;
/**
* @Description:    动态刷新路由配置
* @Author:         hexingfei
* @CreateDate:     2019/12/3 11:20
* @Version:        1.0
*/
public class NewZuulRouteLocator extends SimpleRouteLocator implements RefreshableRouteLocator
{

    @Autowired
    private ZuulProperties properties;

    @Autowired
    private PropertiesAssemble propertiesAssemble;

    public NewZuulRouteLocator(String servletPath, ZuulProperties properties) {
        super(servletPath, properties);
        this.properties = properties;
    }

    @Override
    public void refresh() {
        doRefresh();
    }

    @Override
    protected Map<String, ZuulProperties.ZuulRoute> locateRoutes() {
        LinkedHashMap<String, ZuulProperties.ZuulRoute> routesMap = new LinkedHashMap<String, ZuulProperties.ZuulRoute>();
        // 从application.properties中加载路由信息
        routesMap.putAll(super.locateRoutes());
        // 从Nacos中加载路由信息
        routesMap.putAll(propertiesAssemble.getProperties());
        // 优化一下配置
        LinkedHashMap<String, ZuulProperties.ZuulRoute> values = new LinkedHashMap<>();
        for (Map.Entry<String, ZuulProperties.ZuulRoute> entry : routesMap.entrySet()) {
            String path = entry.getKey();
            // Prepend with slash if not already present.
            if (!path.startsWith("/")) {
                path = "/" + path;
            }
            if (StringUtils.hasText(this.properties.getPrefix())) {
                path = this.properties.getPrefix() + path;
                if (!path.startsWith("/")) {
                    path = "/" + path;
                }
            }
            values.put(path, entry.getValue());
        }
        return values;
    }
}
