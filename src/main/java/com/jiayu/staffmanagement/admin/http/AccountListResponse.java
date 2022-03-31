package com.jiayu.staffmanagement.admin.http;

import lombok.Builder;
import lombok.Data;

/**
 * @version: 1.00.00
 * @description:
 * @copyright: Copyright (c) 2020 立林科技 All Rights Reserved
 * @company: 厦门立林科技有限公司
 * @author: chenyueqi
 * @date: 2021-06-22 15:44
 */
@Data
@Builder
public class AccountListResponse {
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
