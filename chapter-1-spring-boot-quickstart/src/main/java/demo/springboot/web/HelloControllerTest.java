package demo.springboot.web;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * author： Created by shiming on 2018/9/14 15:49
 * mailbox：lamshiming@sina.com
 */

class HelloControllerTest {
    /*
    判断后面是否相等 这就是测试用例啊
     */
    @Test
    public void testSayHello() {
        assertEquals("Hello，Spring Boot！",new HelloController().sayHello());
    }
}
