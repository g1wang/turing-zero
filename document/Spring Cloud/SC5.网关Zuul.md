## 网关

### Zuul

- 认证和安全 识别每个需要认证的资源，拒绝不符合要求的请求。
- 性能监测 在服务边界追踪并统计数据，提供精确的生产视图。
- 动态路由 根据需要将请求动态路由到后端集群。
- 压力测试 逐渐增加对集群的流量以了解其性能。
- 负载卸载 预先为每种类型的请求分配容量，当请求超过容量时自动丢弃。
- 静态资源处理 直接在边界返回某些响应。

 

### Zuul Filter

####  Filter 的类型

- PRE Filter：在请求路由到目标之前执行。一般用于请求认证、负载均衡和日志记录。
- ROUTING Filter：处理目标请求。这里使用Apache HttpClient或Netflix Ribbon构造对目标的HTTP请求。
- POST Filter：在目标请求返回后执行。一般会在此步骤添加响应头、收集统计和性能数据等。
- ERROR Filter：整个流程某块出错时执行。

#### Filter顺序

- ```
  filterOrder
  ```

#### Filter 条件

- ```
  shouldFilter()
  ```

#### Filter 作用

- ```
  run()
  ```
  
### project

- [zuul](../../gateway/readme.md)