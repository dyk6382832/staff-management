package com.jiayu.staffmanagement.common.constant;

/**
 * @version: 1.00.00
 * @description: 字典相关
 * @copyright: Copyright (c) 2020 立林科技 All Rights Reserved
 * @company: 厦门立林科技有限公司
 * @author: chenyueqi
 * @date: 2021-06-23 15:28
 */
public class DicConstant {
    /**
     * 是否系统默认
     */
    public static final class IS_SYSTEM {
        /**
         * 系统默认，可以删除
         */
        public static final Integer YES = 1;
        /**
         * 不是系统默认，不可以删除
         */
        public static final Integer NO = 0;
    }

    /**
     * 数字校验
     */
    public static final class CHECK_NUMBER {

        /**
         * 数字字典必须为数字
         */
        public static final String DICTIONARY_NUMERAL_REGEX = "\\d*";

        /**
         * 数字字典最大值为9999999
         */
        public static final String DICTIONARY_MAX_REGEX = "[0-9]{0,8}";
    }

    /**
     * 数字校验
     */
    public static final class DIC_DEFAULT {

        /**
         * 数字字典必须为数字
         */
        public static final Long COMPANY_NO = 0L;

        /**
         * 数字字典最大值为9999999
         */
        public static final Long NEIGH_NO = 0L;

        /**
         * 父级pid
         */
        public static final Long F_PID = 0L;

    }

    /**
     * 数据状态
     */
    public static final class DATA_STATE {

        /**
         * 新记录
         */
        public static final Integer NEW = 0;

        /**
         * 更新记录
         */
        public static final Integer UPDATE = 1;

        /**
         * 逻辑删除记录
         */
        public static final Integer DELETE = 2;

    }

}
