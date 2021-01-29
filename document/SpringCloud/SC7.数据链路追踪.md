## SC7.数据链路追踪

### 

### Sleuth
- Spring Cloud Sleuth provides Spring Boot auto-configuration for distributed tracing 
- Zipkin 数据链路追踪可视化
- [zipkin server](../../zipkin-service)

- [zipkinclient](../../zipkin-client)
```
        <!--  admin client -->
        <dependency>
            <groupId>de.codecentric</groupId>
            <artifactId>spring-boot-admin-starter-client</artifactId>
        </dependency>

    // parent pom
    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>de.codecentric</groupId>
                <artifactId>spring-boot-admin-dependencies</artifactId>
                <version>${spring-boot-admin.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>

    //config
    ##暴露actuator的所有端口
    management:
      endpoints:
        web:
          exposure:
            include: "*"
      endpoint:
        health:
          show-details: ALWAYS
```