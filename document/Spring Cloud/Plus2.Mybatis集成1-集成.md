## Mybatis集成1-集成
- mybatis annotation
- 数据源:druid
### 依赖包

```
        <!--        mybatis    -->
        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
            <version>2.1.1</version>
        </dependency>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <scope>runtime</scope>
        </dependency>

        <!-- https://mvnrepository.com/artifact/com.alibaba/druid-spring-boot-starter -->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid-spring-boot-starter</artifactId>
            <version>${druid.version}</version>
        </dependency>
```

### 配置

```
spring:
  datasource:
    name: turing
    type: com.alibaba.druid.pool.DruidDataSource
    #druid相关配置
    druid:
    #监控统计拦截的filters
    filters: stat
    driver-class-name: com.mysql.cj.jdbc.Driver
    #基本属性
    url: jdbc:mysql://127.0.0.1:3306/turing?autoReconnect=true&useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true&serverTimezone=UTC
    username: root
    password: qwer1234
    #配置初始化大小/最小/最大
    initial-size: 1
    min-idle: 1
    max-active: 20
    #获取连接等待超时时间
    max-wait: 60000
    #间隔多久进行一次检测，检测需要关闭的空闲连接
    time-between-eviction-runs-millis: 60000
    #一个连接在池中最小生存的时间
    min-evictable-idle-time-millis: 300000
    validation-query: SELECT 'x'
    test-while-idle: true
    test-on-borrow: false
    test-on-return: false
    #打开PSCache，并指定每个连接上PSCache的大小。oracle设为true，mysql设为false。分库分表较多推荐设置为false
    pool-prepared-statements: false
    max-pool-prepared-statement-per-connection-size: 20
mybatis:
  type-aliases-package: com.starsturing.bookservice.mapper
```

### 代码

#### entity
```
public class Book {
    Integer bookID;
    String bookName;
    String category;
    String path;
    ...//此处省略
    
}

```

#### mapper
- annotation 注解方式
```
@Component
public interface BookMapper {

    @Insert("insert into book(book_name,category,path) value (#{bookName},#{category},#{path})")
    int insert( @Param("bookName") String bookName, @Param("category") String category, @Param("path") String path);

    @InsertProvider(type= BookProvider.class,method="insertAllBooks")
    int intsertAll(@Param("list") List<Book> list);

}
```

#### service

```
@Service("bookService")
public class BookServiceImpl implements BookService {

    private static final Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);

    @Autowired
    private BookMapper bookMapper;

    /**
     */
    @Transactional
    @Override
    public JSONArray saveBooks(...//此处省略) {
        List<Book> bookList = new ArrayList<>();
        ...//此处省略
        bookMapper.intsertAll(bookList);
        return resultJson;
    }
}
```

#### 启动类

```
@SpringBootApplication
@MapperScan(value = "com.starsturing.bookservice.mapper")
public class BookServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookServiceApplication.class, args);
    }
}
```