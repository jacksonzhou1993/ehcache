package com.jackson.ehcache.bean;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author zhoujunhui
 * @description: TODO
 * @date 2021/9/7 14:33
 */
@Data
@Entity
@Table(name="t_user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="date")
    private Date date;
}
