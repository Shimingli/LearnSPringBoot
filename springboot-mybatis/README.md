#### mybatis 

* MyBatis是一个支持普通SQL查询，存储过程和高级映射的优秀持久层框架。MyBatis消除了几乎所有的JDBC代码和参数的手工设置以及对结果集的检索封装。MyBatis可以使用简单的XML或注解用于配置和原始映射，将接口和Java的POJO（Plain Old Java Objects，普通的Java对象）映射成数据库中的记录。

* HTTP 400 错误 - 请求无效 (Bad request)

* HTTP 404 错误意味着链接指向的网页不存在，即原始网页的URL失效，这种情况经常会发生，很难避免，比如说：网页URL生成规则改变、网页文件更名或移动位置、导入链接拼写错误等，导致原来的URL地址无法访问；当Web 服务器接到类似请求时，会返回一个404 状态码，告诉浏览器要请求的资源并不存在。

* 成功

```
  //http://localhost:8080/api/cityName?cityName=%E6%B8%A9%E5%B2%AD%E5%B8%82
    @RequestMapping(value = "/api/cityName", method = RequestMethod.GET)
    public City findOneCity(@RequestParam(value = "cityName", required = true) String cityName) {
        System.out.println("cityName="+cityName);
        return cityService.findCityByName(cityName);
    }
```