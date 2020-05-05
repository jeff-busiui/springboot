package com.atguigu.springboot.service;


import com.atguigu.springboot.domain.UserInfoDo;

/**
 * @author sunbaojin
 * @date 2020/5/3 19:59
 */
public interface UserInfoService {

    /**
     * 查询数据
     * @param id
     * @return
     */
    public UserInfoDo findById(Long id);
    /**
     * 插入数据
     * @return
     */
    public UserInfoDo insertUser(UserInfoDo userInfoDo);

    /**
     * 删除数据
     * @param id
     * @return
     */
    public int deleteById(Long id);

    /**
     * 更新数据
     * @param userInfoDo
     * @return
     */
    public UserInfoDo updateUser(UserInfoDo userInfoDo);
}
