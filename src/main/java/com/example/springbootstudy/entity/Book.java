package com.example.springbootstudy.entity;

import javax.persistence.*;

/**
 * Book实体
 *
 * @Entity表示这个类是实体
 */
@Entity
public class Book {

    /**
     * @Id 表示这个变量是主键
     * @GeneratedValue(strategy = GenerationType.AUTO) 配置主键自增
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    /**
     * @Column 表示这是一个数据表项
     * nullable = false 允许空值
     * unique = true 唯一
     */
    @Column(nullable = false, unique = true)
    private String title;

    @Column(nullable = false)
    private String author;

    /**
     * Setter 和 Getter
     * IDEA可以一键自动生成所有字段的 Setter 和 Getter
     */

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}
