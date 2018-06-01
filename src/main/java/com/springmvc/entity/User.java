package com.springmvc.entity;

import java.io.Serializable;

/**
 * @author sanduo
 * @date 2018/05/18
 */
public class User implements Serializable {

    /**
     * 序列化id
     */
    private static final long serialVersionUID = -186244572291594467L;

    private Long id;

    private String name;

    /**
     * @param id
     * @param name
     */
    public User(Long id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    /**
     * Jackson 对对象和json转换必须要有空构造
     */
    public User() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

}
