package com.jiayu.staffmanagement.common.http.request;

import lombok.Data;

/**
 * @version: 1.00.00
 * @description:
 * @copyright: Copyright (c) 2021 立林科技 All Rights Reserved
 * @company: 厦门立林科技有限公司
 * @author: linzhenyuan
 * @date: 2021-06-21 21:07
 */
@Data
public class LayuiRequest {
    /**
     * 每页大小
     */
    private Integer limit;

    /**
     * 页码
     */
    private Integer page;
}
