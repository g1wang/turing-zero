## 集群监控

### Turbine
Turbine 是聚合服务器发送事件流数据的一个工具，Hystrix的监控中，只能监控单个节点，
实际生产中都为集群，因此可以通过Turbine来监控集群下Hystrix的metrics情况

### [Turbine module](../../eureka-server/readme.md)
```
http://localhost:port/hystrix

http://localhost:23080/turbine.stream?cluster=default

```
