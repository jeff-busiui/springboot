package com.atguigu.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * @author sunbaojin
 * @date 2020/5/3 19:44
 */
@Entity
@Table(name="user_info")
@Data
public class UserInfoDo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_email")
    private String userEmail;
}
