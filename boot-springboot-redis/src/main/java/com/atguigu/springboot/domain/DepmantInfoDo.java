package com.atguigu.springboot.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * @author sunbaojin
 * @date 2020/5/4 9:24
 */
@Data
@Entity
@Table(name = "depmant_info")
public class DepmantInfoDo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dep_id")
    private String depId;
    @Column(name = "dep_name")
    private String depName;
}
