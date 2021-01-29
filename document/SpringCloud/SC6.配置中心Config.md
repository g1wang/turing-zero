## Config

### SpringCloud Config
- [config server](../../config-server) 配置中心从配置仓库读取配置文件
- [config client](../../config-client) 从配置中心读取配置
- 通过eureka做集群

### SpringCloud bus
- 动态刷新配置文件，在需要刷新的类上加注解  @RefreshScope
- spring-cloud-starter-bus-amqp (rabbitmq), 也可以用kafka


