package com.example.springbootstudy.controller;

import com.example.springbootstudy.entity.Book;
import com.example.springbootstudy.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 一组基本的CRUD
 * 单表查询实践
 * 直接调用仓库，对Book增删改查
 */
@RestController
@RequestMapping("book")
public class BookController {

    /**
     * 自动装配：@Autowired
     * 作用是:Spring容器扫描到@Autowired之后，自动装入一个符合条件的对象
     * 以便实现送耦合，我们编写时只需要考虑组件内的逻辑，而无需关心注入进来的具体是谁
     *
     * 官方不推荐这种方式注入，而构造函数注入是更好的办法
     * 此处只做演示
     */
    @Autowired
    private BookRepository bookRepository;

    /**
     * 列表查询
     * Iterable：迭代
     */
    @GetMapping
    public Iterable findAll() {
        return bookRepository.findAll();
    }

    /**
     * 根据ID查询
     *
     * 通过@GetMapping("/{id}")获取路由参数
     * @PathVariable 把路由参数转化成变量
     * 如果有多个参数，在不使用参数名称时，按前后顺序对应
     *
     * findById返回的是Optional类型，所以需要orElseThrow
     * 此处自定义了一个BookNotFoundException类型
     */
    @GetMapping("/{id}")
    public Book findById(@PathVariable Long id) throws BookNotFoundException {
        return bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
    }

    /**
     * 根据标题查询
     */
    @GetMapping("/title/{title}")
    public List<Book> findByTitle(@PathVariable String title) {
        return bookRepository.findByTitle(title);
    }

    /**
     * 创建
     *
     * @RequestBody 从Body中获取参数，并且自动完成到实体的转化过程
     * 传的参数需要包括id字段，然后留空，如果id有值也不会使用它，存进去的还是自增
     * save方法会把保存成功的对象返回（带ID）
     */
    @PostMapping
    public Book save(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    /**
     * 更新
     *
     * 此处集中体现了@RequestBody和@PathVariable的区别
     * @ RequestBody是从http的Body中获取参数，这部分不会写到URL中
     * @ PathVariable是从请求地址中获取路由参数，参数在请求地址的最后用?拼接
     *
     * 更新调用的仓库层方法也是save
     * 但要注意增加校验，id匹配才可以
     * 第一步：查ID
     * 第二步：保存
     */
    @PutMapping("/{id}")
    public Book update(@RequestBody Book book, @PathVariable Long id) {
        if (book.getId() != id) {
            throw new BookIdMismatchException();
        }
        bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
        return bookRepository.save(book);
    }

    /**
     * 删除
     * 删除没有返回值
     * 参数使用路径变量
     * 第一步：查ID
     * 第二步:删
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
        bookRepository.deleteById(id);
    }

    /**
     * 自定义异常类型——找不到Book
     */
    public class BookNotFoundException extends RuntimeException {
        public BookNotFoundException() {
            super();
        }
    }

    /**
     * 自定义异常类型——Body中的ID和参数的ID不匹配
     */
    public class BookIdMismatchException extends RuntimeException {
        public BookIdMismatchException() {
            super();
        }
    }

}
