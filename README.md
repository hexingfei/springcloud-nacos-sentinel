# springcloud alibaba-nacos-sentinel-fegin

1.首先从官网下载nacos sentinel 后解压 配置启动 启动配置查看官网
链接地址：[nacos官网](https://nacos.io/en-us/) [sentinel官网](https://github.com/alibaba/Sentinel/wiki)

 2.下载源码到本地 修改yml 里面配置

3.此项目集成了服务治理注册<font color=#0099ff size=8>nacos</font> 降级熔断<font color=red size=5>sentinel</font> 以及<font color=red size=5>sentinel</font> 配置规则推模式到配置中心<font color=red size=5>nacos</font> 动态变更通知，无需重启项目。
4.zuul 项目为网关 已接入nacos 服务治理平台 ，可以动态实现路由配置
### 使用说明
下载nacos 包 解压 启动 访问地址 http://localhost:8848/nacos/ 登录用户密码默认 nacos 

启动sentinel-dashboard 正常访问地址http://localhost:8080/ 登录用户名密码默认 sentinel 

启动nacosdemo nacosconsumer 工程 可以看到nacos 页面注册了两个服务, sentinel 页面可以设置限流规则、黑白名单权限等操作。默认配置规则是存储在内存，重启即失效，本工程集成了持久化处理，可以推送到nacos 配置中心。
