package cn.zuul.server.config;

import cn.zuul.server.route.NewZuulRouteLocator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
* @Description:    zuul 配置
* @Author:         hexingfei
* @CreateDate:     2019/12/3 10:40
* @Version:        1.0
*/
@Component
public class NewZuulConfig
{
    @Autowired
    private ZuulProperties zuulProperties;

    @Autowired
    private ServerProperties serverProperties;

    @Bean
    public NewZuulRouteLocator routeLocator() {
        NewZuulRouteLocator routeLocator = new NewZuulRouteLocator(
            this.serverProperties.getServlet().getContextPath(), this.zuulProperties);
        return routeLocator;
    }
}
