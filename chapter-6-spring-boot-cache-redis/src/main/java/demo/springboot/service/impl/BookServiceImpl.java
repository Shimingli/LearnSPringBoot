package demo.springboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import demo.springboot.domain.Book;
import demo.springboot.domain.BookRepository;
import demo.springboot.service.BookService;

import java.util.List;

/**
 * Book 业务层实现
 *
 * Created by bysocket on 30/09/2017.
 *
 * @EnableCaching 启用缓存配置
 * @Cacheable 指定某个方法的返回值是可以缓存的。在注解属性中指定缓存规则。
 * @Cacheput 将方法的返回值缓存到指定的key中
 * @CacheEvict 删除指定的缓存数据
 */
@Service
@CacheConfig(cacheNames = "books")
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book insertByBook(Book book) {
        return bookRepository.save(book);
    }

    @CachePut(key = "#p0.id")
    @Override
    public Book update(Book book) {
        System.out.println(" call update method ");
        return bookRepository.save(book);
    }

    @CacheEvict(key = "#p0")
    @Override
    public Book delete(Long id) {
        System.out.println(" call delete method ");
        Book book = bookRepository.findById(id).get();
        bookRepository.delete(book);
        return book;
    }

    @Cacheable(key = "#p0")
    @Override
    public Book findById(Long id) {
        System.out.println(" call findById method ");
        return bookRepository.findById(id).get();
    }
}
