package com.jiayu.staffmanagement.admin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jiayu.staffmanagement.admin.entity.AccountDTO;
import com.jiayu.staffmanagement.admin.entity.AccountListEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface WpAccountMapper extends BaseMapper<AccountListEntity> {
    /**
     * 根据用户名查找用户信息
     * @param accountDTO
     * @return
     */
    AccountDTO selectAccountByUserInfo(@Param("account") AccountDTO accountDTO);

    /**
     * 根据ID查找用户
     * @param id
     * @return
     */
    AccountDTO selectAccountById(Long id);

    /**
     * 根据用户名查询
     * @param username
     * @return
     */
    List<AccountDTO> selectAccountByUsername(@Param("username") String username);

    /**
     * 根据用户名更新用户信息
     * @param accountDTO
     * @return
     */
    Boolean updateAccountByUsername(@Param("account") AccountDTO accountDTO);

    /**
     * 根据id更新用户信息
     * @param accountDTO
     * @return
     */
    Boolean updateAccountById(@Param("account") AccountDTO accountDTO);

    /**
     * 根据用户名删除用户
     * @param id
     * @return
     */
    Integer delAccountById(@Param("id") Long id);

    /**
     * 插入用户
     * @param accountDTO
     * @return
     */
    Boolean insertAccount(@Param("account") AccountDTO accountDTO);
}
