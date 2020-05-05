package com.atguigu.springboot.repository;

import com.atguigu.springboot.domain.DepmantInfoDo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author sunbaojin
 * @date 2020/5/4 9:28
 */
public interface DepmantDao extends JpaRepository<DepmantInfoDo,Long> {
}
