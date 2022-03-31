package com.jiayu.staffmanagement.common.http.response;

import com.jiayu.staffmanagement.common.constant.ResultCode;
import lombok.Data;

import java.util.List;

/**
 * @version: 1.00.00
 * @description: layui表格规定的返回格式
 * @copyright: Copyright (c) 2021 立林科技 All Rights Reserved
 * @company: 厦门立林科技有限公司
 * @author: linzhenyuan
 * @date: 2021-06-18 9:44
 */
@Data
public class LayuiResponse<T> {

    /**
     * 响应码 layui表格强制规定0表示成功
     */
    private Long code = ResultCode.LAYUI_SUCCESS.getCode();

    /**
     * 返回信息
     */
    private String msg;

    /**
     * 总数
     */
    private Integer count;

    /**
     * 数据列表
     */
    private List<T> data;

    public LayuiResponse(long code, String msg, Integer count, List<T> data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    public LayuiResponse() {
    }

    public static <T> LayuiResponse<T> success(List<T> data, Integer count) {
        return new LayuiResponse<>(ResultCode.LAYUI_SUCCESS.getCode(), ResultCode.LAYUI_SUCCESS.getMessage(), count, data);
    }

    public static <T> LayuiResponse<T> failed() {
        return new LayuiResponse<>(ResultCode.FAILED.getCode(), ResultCode.FAILED.getMessage(), 0, null);
    }
}
