package com.jiayu.staffmanagement.common.http.response;

import lombok.Data;

/**
 * @version: 1.00.00
 * @description:
 * @copyright: Copyright (c) 2021 立林科技 All Rights Reserved
 * @company: 厦门立林科技有限公司
 * @author: linzhenyuan
 * @date: 2021-06-18 10:55
 */
@Data
public class ScResponseDTO<T> {
    /**
     * 返回码
     */
    private String result;

    /**
     * 返回信息
     */
    private String message;

    /**
     * 前端请求id
     */
    private String seq;

    /**
     * 返回数据实体
     */
    private T params;
}
