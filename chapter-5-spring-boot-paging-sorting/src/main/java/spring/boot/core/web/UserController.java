package spring.boot.core.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import spring.boot.core.domain.User;
import spring.boot.core.service.UserService;

/**
 * 用户控制层
 *
 * Created by bysocket on 18/09/2017.
 */
@RestController
@RequestMapping(value = "/users")     // 通过这里配置使下面的映射都在 /users
public class UserController {

    @Autowired
    UserService userService;          // 用户服务层

    /**
     *  获取用户分页列表
     *    处理 "/users" 的 GET 请求，用来获取用户分页列表
     *    通过 @RequestParam 传递参数，进一步实现条件查询或者分页查询
     *
     *    Pageable 支持的分页参数如下
     *    page - 当前页 从 0 开始
     *    size - 每页大小 默认值在 application.properties 配置
     *
     */
    /*
    {"content":[{"id":1,"name":"shiming","age":15,"birthday":"1010"},{"id":2,"name":"shiming","age":15,"birthday":"1010"},{"id":3,"name":"shiming","age":15,"birthday":"1010"}],"pageable":{"sort":{"sorted":false,"unsorted":true},"offset":0,"pageSize":15,"pageNumber":0,"paged":true,"unpaged":false},"last":true,"totalElements":3,"totalPages":1,"number":0,"size":15,"sort":{"sorted":false,"unsorted":true},"numberOfElements":3,"first":true}
     */
    @RequestMapping(method = RequestMethod.GET)
    public Page<User> getUserPage(Pageable pageable) {
        System.out.println("getPageNumber="+pageable.getPageNumber());
        System.out.println("getPageSize="+pageable.getPageSize());
        return userService.findByPage(pageable);
    }

    /**
     *  创建用户
     *    处理 "/users" 的 POST 请求，用来获取用户列表
     *    通过 @RequestBody 绑定实体类参数
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public User postUser(@RequestBody User user) {
        return userService.insertByUser(user);
    }

}