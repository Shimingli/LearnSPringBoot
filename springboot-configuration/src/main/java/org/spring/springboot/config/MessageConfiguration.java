package org.spring.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by bysocket on 08/09/2017.
 */
@Configuration //Spring Java Configuration这个项目提供了一种通过java代码来装配bean的方案
public class MessageConfiguration {
    /*
     1.使用纯java代码，不在需要xml

     2.在配置中也可享受OO带来的好处

     3.类型安全对重构也能提供良好的支持

     4.依旧能享受到所有springIoC容器提供的功能
     */
    @Bean
    public String message() {
        return "message configuration";
    }
}
