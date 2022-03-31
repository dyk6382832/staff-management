package com.jiayu.staffmanagement.admin.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @version: 1.00.00
 * @description:
 * @copyright: Copyright (c) 2020 立林科技 All Rights Reserved
 * @company: 厦门立林科技有限公司
 * @author: chenyueqi
 * @date: 2021-06-22 15:30
 */
@Data
@TableName(value = "t_system_account")
public class AccountListEntity {
    private Long id;

    private String username;

    private String password;

    private Integer accountState;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;
}
