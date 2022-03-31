package com.jiayu.staffmanagement.common.constant;

/**
 * @version: 1.00.00
 * @description:
 * @copyright: Copyright (c) 2021 立林科技 All Rights Reserved
 * @company: 厦门立林科技有限公司
 * @author: linzhenyuan
 * @date: 2021-06-18 11:03
 */
public class TableConstant {
    /**
     * 运营号分表 相关接口参数
     */
    public static final String ACTION_PATCH = "patch";
    public static final String ACTION_ALTER = "alter";
    public static final String ACTION_DISABLE = "disable";
    public static final String ACTION_RECOVER = "recover";

    /**
     * 脚本执行结果 -1:失败 0:未知 1：成功
     */
    public static final Integer TABLE_ALTER_SUCCESS = 1;
    public static final Integer TABLE_ALTER_UNKNOW = 0;
    public static final Integer TABLE_ALTER_FAILED = -1;

}
