## SC9.Security



### Spring Security

- 认证：认证主体
- 授权：主体权限

### OAuth2

#### OAuth2 认证流程

  ```
  A=user B=lient C=AuthorizationServer D=resource Server
  
  B->A->B 用户登录到客户端
  B->C->B 客户端向授权服务器申请授权，服务器认证，成功后授权Token
  B->D->B 客户端携带令牌向资源服务器请求资源，服务器验证令牌正确，允许请求
  
  ```

#### OAuth2 JWT

- JWT: JSON Web Token

- HMAC/RSA(公钥、私钥的非对成加密)算法，加密JWT，

  服务可以保存自己的私钥，保存其他的公钥

- 通过JWT保存Token，不需要频繁访问授权服务器

- 通过网关缓存Token，缓解Token失效问题

​       

