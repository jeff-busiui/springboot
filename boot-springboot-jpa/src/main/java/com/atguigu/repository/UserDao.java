package com.atguigu.repository;

import com.atguigu.domain.UserInfoDo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author sunbaojin
 * @date 2020/5/3 19:56
 */
public interface UserDao extends JpaRepository<UserInfoDo, Long> {

}
