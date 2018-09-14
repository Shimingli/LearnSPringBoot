package demo.springboot.web;

import demo.springboot.config.BookProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Spring Boot Hello案例
 *
 * Created by bysocket on 26/09/2017.
 *   todo  @RestController和@RequestMapping注解是来自SpringMVC的注解，它们不是SpringBoot的特定部分。
 */
@RestController
public class HelloBookController {

    @Autowired
    BookProperties bookProperties;

    @GetMapping("/book/hello")
    public String sayHello() {
        // Hello， shiming is writing haohapxuexi ！
        bookProperties.setWriter("shiming");
        bookProperties.setName("haohapxuexi");
        return "Hello， " + bookProperties.getWriter() + " is writing "
                + bookProperties.getName() + " ！";
    }
    @GetMapping("/book/helloTwo")
    public String sayHelloTwo() {
        //Hello， BYSocket is writing [Spring Boot 2.x Core Action] ！
        return "Hello， " + bookProperties.getWriter() + " is writing "
                + bookProperties.getName() + " ！";
    }
}
