package cn.zuul.server.entity;

/**
* @Description:    实体类
* @Author:         hexingfei
* @CreateDate:     2019/12/3 10:42
* @Version:        1.0
*/
public class ZuulRouteEntity
{
    private String id;

    private String path;

    private String serviceId;

    private String url;

    private boolean stripPrefix = true;

    private Boolean retryable;

    private String apiName;

    private Boolean enabled;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getPath()
    {
        return path;
    }

    public void setPath(String path)
    {
        this.path = path;
    }

    public String getServiceId()
    {
        return serviceId;
    }

    public void setServiceId(String serviceId)
    {
        this.serviceId = serviceId;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public boolean isStripPrefix()
    {
        return stripPrefix;
    }

    public void setStripPrefix(boolean stripPrefix)
    {
        this.stripPrefix = stripPrefix;
    }

    public Boolean getRetryable()
    {
        return retryable;
    }

    public void setRetryable(Boolean retryable)
    {
        this.retryable = retryable;
    }

    public String getApiName()
    {
        return apiName;
    }

    public void setApiName(String apiName)
    {
        this.apiName = apiName;
    }

    public Boolean getEnabled()
    {
        return enabled;
    }

    public void setEnabled(Boolean enabled)
    {
        this.enabled = enabled;
    }

    @Override
    public String toString()
    {
        final StringBuffer sb = new StringBuffer("ZuulRouteEntity{");
        sb.append("id='").append(id).append('\'');
        sb.append(", path='").append(path).append('\'');
        sb.append(", serviceId='").append(serviceId).append('\'');
        sb.append(", url='").append(url).append('\'');
        sb.append(", stripPrefix=").append(stripPrefix);
        sb.append(", retryable=").append(retryable);
        sb.append(", apiName='").append(apiName).append('\'');
        sb.append(", enabled=").append(enabled);
        sb.append('}');
        return sb.toString();
    }
}
