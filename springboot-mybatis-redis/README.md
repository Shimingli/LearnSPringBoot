## Spring Boot 整合 Redis 实现缓存操作

* http://www.runoob.com/redis/redis-tutorial.html

* 什么是缓存？
* 在互联网场景下，尤其 2C 端大流量场景下，需要将一些经常展现和不会频繁变更的数据，存放在存取速率更快的地方。缓存就是一个存储器，在技术选型中，常用 Redis 作为缓存数据库。缓存主要是在获取资源方便性能优化的关键方面。

* 缓存的应用场景有哪些呢？
* 比如常见的电商场景，根据商品 ID 获取商品信息时，店铺信息和商品详情信息就可以缓存在 Redis，直接从 Redis 获取。减少了去数据库查询的次数


```

查询的id=9
2018-09-21 15:06:43.464 ERROR 7228 --- [nio-8080-exec-1] o.a.c.c.C.[.[.[/].[dispatcherServlet]    : Servlet.service() for servlet [dispatcherServlet] in context with path [] threw exception [Request processing failed; nested exception is org.springframework.data.redis.RedisConnectionFailureException: Cannot get Jedis connection; nested exception is redis.clients.jedis.exceptions.JedisConnectionException: Could not get a resource from the pool] with root cause

```

* redis是一个key-value存储系统。和Memcached类似，它支持存储的value类型相对更多，包括string(字符串)、list(链表)、set(集合)、zset(sorted set --有序集合)和hash（哈希类型）。这些数据类型都支持push/pop、add/remove及取交集并集和差集及更丰富的操作，而且这些操作都是原子性的。在此基础上，redis支持各种不同方式的排序。与memcached一样，为了保证效率，数据都是缓存在内存中。区别的是redis会周期性的把更新的数据写入磁盘或者把修改操作写入追加的记录文件，并且在此基础上实现了master-slave(主从)同步。
Redis 是一个高性能的key-value数据库。 redis的出现，很大程度补偿了memcached这类key/value存储的不足，在部 分场合可以对关系数据库起到很好的补充作用。它提供了Java，C/C++，C#，PHP，JavaScript，Perl，Object-C，Python，Ruby，Erlang等客户端，使用很方便