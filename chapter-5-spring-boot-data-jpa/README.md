#### JPA
* Web 请求，首先请求是网页，网页执行了完了，才回去去请求标签的图片   
* http://localhost:8080/images/20720544.jpg  直接请求我的图片   
* Spring Data JPA是Spring基于Hibernate开发的一个JPA框架。如果用过Hibernate或者MyBatis的话，就会知道对象关系映射（ORM）框架有多么方便。但是Spring Data JPA框架功能更进一步，为我们做了 一个数据持久层框架几乎能做的任何事情。
* Post的问题 少了一句 
* 这个就是正确的post请求，同时能够获取body中的值，但是如果是网页中内嵌的请求的话，就会不成功
```
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String postBook(@RequestBody Book book) { //@ModelAttribute
        System.out.println("创建 ------------------》"+book.toString());
        bookService.insertByBook(book);
        return REDIRECT_TO_BOOK_URL;
    }
```

* Demo中应该使用这种的标记

```
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String postBook(@ModelAttribute Book book) { //@ModelAttribute
        System.out.println("创建 ------------------》"+book.toString());
        bookService.insertByBook(book);
        return REDIRECT_TO_BOOK_URL;
    }
```

* 很关键的一个问题在，post的请求中记得加上 `Content-Type: application/json; charset=utf-8`