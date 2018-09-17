#### 数据缓存

* spring-boot-starter-data-jpa 就是 JpaRepository 的依赖
* Cache 一词最早来自于CPU设计
  当CPU要读取一个数据时，首先从CPU缓存中查找，找到就立即读取并送给CPU处理；没有找到，就从速率相对较慢的内存中读取并送给CPU处理，同时把这个数据所在的数据块调入缓存中，可以使得以后对整块数据的读取都从缓存中进行，不必再调用内存。正是这样的读取机制使CPU读取缓存的命中率非常高（大多数CPU可达90%左右），也就是说CPU下一次要读取的数据90%都在CPU缓存中，只有大约10%需要从内存读取。这大大节省了CPU直接读取内存的时间，也使CPU读取数据时基本无需等待。总的来说，CPU读取数据的顺序是先缓存后内存。
  再到后来，出先了硬盘缓存，然后到应用缓存，浏览器缓存，Web缓存，等等！
  
* spring-boot-starter-cache是cache关键依赖
* 修改Application类，加入启用缓存的注解@EnableCaching
* @EnableCaching 启用缓存配置
* @Cacheable 指定某个方法的返回值是可以缓存的。在注解属性中指定缓存规则。
* @Cacheput 将方法的返回值缓存到指定的key中
* @CacheEvict 删除指定的缓存数据
* 没看出来，有什么屌用  