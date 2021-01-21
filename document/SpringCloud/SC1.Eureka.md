## 服务注册和发现组件 eureka

### 1 Eureka Server
服务注册中心

#### 1.1 依赖包
```
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
        </dependency>
```

#### 1.2 配置
```
info:
  app: eureka-server
  version: v1.0.0
spring:
  application:
    name: eureka-server
server:
  port: 8081

eureka:
  client:
    #register-with-eureka和fetch-registry false 防止自己注册自己
    register-with-eureka: false
    fetch-registry: false
    service-url:
     defaultZone: http://localhost:8081/eureka/
    #eureka client间隔多久去拉取服务注册信息，默认为30秒
    #对于api-gateway，如果要迅速获取服务注册状态，可以缩小该值，比如5秒
    registry-fetch-interval-seconds: 30
    healthcheck:
      enabled: true
  instance:
    prefer-ip-address: true
    hostname: localhost
    #eureka client发送心跳给server端的频率
    lease-renewal-interval-in-seconds: 30
    #eureka server至上一次收到client的心跳之后，等待下一次心跳的超时时间
    lease-expiration-duration-in-seconds: 90
    metadata-map:
      zone: zone1
```

#### 1.3 代码
启动类 EurekaServerApplication加注解@EnableEurekaServer
启动后在根据service-url的配置 http://host:port 访问eureka-server界面
```
    @SpringBootApplication
    @EnableEurekaServer
    public class EurekaServerApplication {
    
        public static void main(String[] args) {
            SpringApplication.run(EurekaServerApplication.class, args);
        }
    
    }
```

### 2 Eureka Client
服务提供方，有两部分组成app-service和app-client，这里先app-service部分
#### 2.1 依赖包
```
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>    
```

#### 2.2 配置
```
info:
  app: user-service
  version: v1.0.0
server:
  port: 18082
spring:
  application:
    name: book-service
  cloud:
    loadbalancer:
      retry:
        enabled: true
        
eureka:
  client:
    service-url:
     defaultZone: http://localhost:8081/eureka/
    #eureka client间隔多久去拉取服务注册信息，默认为30秒
    #对于api-gateway，如果要迅速获取服务注册状态，可以缩小该值，比如5秒
    registry-fetch-interval-seconds: 30
    healthcheck:
      enabled: true
  instance:
    #eureka client发送心跳给server端的频率
    lease-renewal-interval-in-seconds: 30
    #eureka server至上一次收到client的心跳之后，等待下一次心跳的超时时间
    lease-expiration-duration-in-seconds: 90
    metadata-map:
      zone: zone1
```

#### 代码
```
@SpringBootApplication
@EnableEurekaClient
public class BookServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookServiceApplication.class, args);
    }

}
```