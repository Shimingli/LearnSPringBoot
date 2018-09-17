package demo.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * Spring Boot 应用启动类
 *
 * Created by bysocket on 30/09/2017.
 */
@SpringBootApplication
@EnableCaching //修改Application类，加入启用缓存的注解@EnableCaching
public class WebApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }
}
