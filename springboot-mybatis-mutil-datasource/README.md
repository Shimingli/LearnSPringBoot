## Spring Boot 整合 Mybatis 实现 Druid 多数据源详解
* 目前，业界流行的数据操作框架是 Mybatis
* Druid是Java语言中最好的数据库连接池。Druid能够提供强大的监控和扩展功能。by 阿里巴巴 

* 1. DruidDriver 代理 Driver，能够提供基于 Filter－Chain 模式的插件体系。
* 2. DruidDataSource 高效可管理的数据库连接池
* 3. SQLParser

* http://localhost:8080/api/user?userName=E4%BB%95%E6%98%8E%E5%90%8C%E5%AD%A6


```
{"id":1,"userName":"仕明","description":"我要好好学习","city":{"id":100001,"provinceId":1000,"cityName":"深圳","description":"仕明"}}
```