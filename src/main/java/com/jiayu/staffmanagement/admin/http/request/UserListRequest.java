package com.jiayu.staffmanagement.admin.http.request;

import com.jiayu.staffmanagement.common.http.request.LayuiRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @version: 1.00.00
 * @description: 用户请求
 * @copyright: Copyright (c) 2020 立林科技 All Rights Reserved
 * @company: 厦门立林科技有限公司
 * @author: chenyueqi
 * @date: 2021-06-22 15:19
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class UserListRequest extends LayuiRequest {
    /**
     * 用户名
     */
    private String account;
}
