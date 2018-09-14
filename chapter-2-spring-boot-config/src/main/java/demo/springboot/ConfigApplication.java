package demo.springboot;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot 应用启动类
 *
 * Created by bysocket on 26/09/2017.
 *
 * 1、是一款让你更好的书写API文档的规范且完整框架。
 * 2、提供描述、生产、消费和可视化RESTful Web Service。
 * 3、是由庞大工具集合支撑的形式化规范。这个集合涵盖了从终端用户接口、底层代码库到商业API管理的方方面面。
 */
@EnableSwagger2Doc // 开启 Swagger  https://blog.csdn.net/weixin_37509652/article/details/80094370
@SpringBootApplication
public class ConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigApplication.class, args);
        System.out.println(" http://localhost:8080");
    }
}
