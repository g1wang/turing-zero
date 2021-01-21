## openfeign

### openfeign
- 声明式服务调用 API
- 可集成 HttpClient 或者 okHttp 
- 继承了 Spring Cloud LoadBalancer/ribbon 做负载均衡

#### 依赖
```
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-openfeign</artifactId>
        </dependency>
        <dependency>
          <groupId>io.github.openfeign</groupId>
          <artifactId>feign-okhttp</artifactId>
          <version>11.0</version>
        </dependency>
```

#### 配置
```
# 使用  okhttp
feign:
  okhttp:
    enabled: true
```
#### 代码
BookFeignService.java
```
@FeignClient(value = "BOOK-SERVICE",configuration = FeignConfig.class)
public interface BookFeignService {

     @GetMapping("/book")
     String getBooksFromService(@RequestParam(value = "bookName") String bookName);
}
```

- FeignConfig.java
```
//重写
@Configuration
public class FeignConfig {
    @Bean
    public Retryer feignRetryer(){
        return new Retryer.Default(100,SECONDS.toMillis(1),5);
    }
}
```

- BookClientServiceImpl
```
    @Autowired
    BookFeignService bookFeignService;

    @Override
    public String getBooksFromService(String bookName) {
        String result = bookFeignService.getBooksFromService(bookName);
        return result;
    }
```

- TuringClientApplication.java

```
@EnableFeignClients
public class TuringClientApplication {

```