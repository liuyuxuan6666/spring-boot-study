package com.example.springbootstudy.repository;

import com.example.springbootstudy.entity.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * JPA的仓库，用于处理和数据库的交互
 *
 * 仓库是接口
 * 需要继承CrudRepository接口，并设置泛型
 * 然后就可以通过“写方法名”来实现功能了
 *
 * 此外，CrudRepository声明了一堆接口，用于基本的增删改查
 * 这些接口都不需要手写，都是自动完成的
 */
public interface BookRepository extends CrudRepository<Book, Long> {
    /**
     * 只需要规定方法名、参数、返回值
     * 就可以由JPA自动实现查询方法
     *
     * 此处是通过标题查询书籍，返回列表
     */
    List<Book> findByTitle(String title);
}
