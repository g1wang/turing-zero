## Plus4.Redis 集成

### 使用redis实现session共享

- zuul转发请求默认会丢弃原来的session并生成新的session,在zuul路由配置增加sensitiveHeaders: "*"配置
    ```
    redisssessionapi:
      path: /redissessionapi/**
      service-id: redis-session
      sensitiveHeaders: "*"
    ```
  
- [code](../../redis)