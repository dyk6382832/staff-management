package com.jiayu.staffmanagement.admin.entity;

import lombok.Data;

/**
 * @version: 1.00.00
 * @description: 用户实体类
 * @copyright: Copyright (c) 2020 立林科技 All Rights Reserved
 * @company: 厦门立林科技有限公司
 * @author: chenyueqi
 * @date: 2021-06-16 17:23
 */
@Data
public class AccountDTO {

    /**
     * ID
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 状态
     */
    private Integer accountState;
}
