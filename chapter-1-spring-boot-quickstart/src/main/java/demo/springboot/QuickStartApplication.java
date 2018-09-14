package demo.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import lombok.extern.slf4j.Slf4j;

/**
 * Spring Boot 应用启动类
 *
 * Created by bysocket on 26/09/2017.
 */
@Slf4j
@SpringBootApplication //   @SpringBootApplication：Spring Boot 应用的标识
public class QuickStartApplication {
    /**
     * Application很简单，一个main函数作为主入口。
     * SpringApplication引导应用，并将Application本身作为参数传递给run方法。具体run方法会启动嵌入式的Tomcat并初始化Spring环境及其各Spring组件。
     * @param args
     */
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(QuickStartApplication.class, args);
        String property = run.getEnvironment().getProperty("server.port");
        log.info( "shiming start   http://localhost:"+property);
        log.info( "shiming start   http://localhost:"+8080);
    }
}
