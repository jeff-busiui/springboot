package com.atguigu.springboot.repository;

import com.atguigu.springboot.domain.UserInfoDo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author sunbaojin
 * @date 2020/5/3 19:56
 */
public interface UserInfoDao extends JpaRepository<UserInfoDo, Long> {

}
