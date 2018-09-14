package demo.springboot.web;

import demo.springboot.domain.Book;
import demo.springboot.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Book 控制层
 *
 * Created by bysocket on 27/09/2017.
 */
@RestController
@RequestMapping(value = "/book")
public class BookController {

    @Autowired
    BookService bookService;

    /**
     * 获取 Book 列表
     * 处理 "/book" 的 GET 请求，用来获取 Book 列表
     *
     */
    // http://localhost:8080/book  感觉就是一个空的集合啊啊  哈哈
    @RequestMapping(method = RequestMethod.GET)
    public List<Book> getBookList() {
        System.out.println("我运行了哦   http://localhost:8080/book ");
        return bookService.findAll();
    }

    /**
     * 获取 Book
     * 处理 "/book/{id}" 的 GET 请求，用来获取 Book 信息
     */
    //http://localhost:8080/book/1000
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Book getBook(@PathVariable Long id) {
        System.out.println("id="+id);
        Book byId = bookService.findById(id);
        if (byId==null){
            Book book = new Book();
            book.setIntroduction("没有找到哦");
            return book;
        }
        return  byId;
    }

    /**
     * 创建 Book
     * 处理 "/book/create" 的 POST 请求，用来新建 Book 信息
     * 通过 @RequestBody 绑定实体参数，也通过 @RequestParam 传递参数
     */
     /*
     {"timestamp":"2018-09-14T10:13:30.817+0000","status":400,"error":"Bad Request","message":"Required request body is missing: public demo.springboot.domain.Book demo.springboot.web.BookController.postBook(demo.springboot.domain.Book)","path":"/book/create"}

     请求无效 (Bad request);出现这个请求无效报错说明请求没有进入到后台服务里；

     {"id": 1500,"name":"shiming","writer":"shiming","introduction":"没有找到哦"}
      */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Book postBook(@RequestBody Book book) {
        System.out.println(book);
        System.out.println(book.toString());
        return bookService.insertByBook(book);
    }

    /**
     * 更新 Book
     * 处理 "/update" 的 PUT 请求，用来更新 Book 信息
     */
    //Content-Type: application/json; charset=utf-8  put和get的请求 最好都得加上这个这一样，要不然请求不成功
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Book putBook(@RequestBody Book book) {
        return bookService.update(book);
    }

    /**
     * 删除 Book
     * 处理 "/book/{id}" 的 GET 请求，用来删除 Book 信息
     */
    //http://localhost:8080/book/delete/2
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public Book deleteBook(@PathVariable Long id) {
        return bookService.delete(id);
    }

}
