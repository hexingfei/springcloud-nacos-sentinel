package cn.zuul.server.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

/**
* @Description:    过滤器
* @Author:         hexingfei
* @CreateDate:     2019/12/4 15:05
* @Version:        1.0
*/
public class MyFilter extends ZuulFilter
{
    /**
     * 拦截的顺序
     * @return
     */
    @Override
    public String filterType()
    {
        return "pre";
    }

    /**
     * 执行的先后顺序数字越小越先执行
     * @return
     */
    @Override
    public int filterOrder()
    {
        return 0;
    }

    /**
     * 哪些请求需要过滤
     * @return
     */
    @Override
    public boolean shouldFilter()
    {


        return false;
    }

    /**
     * 执行的逻辑
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run()
        throws ZuulException
    {
        return null;
    }
}
