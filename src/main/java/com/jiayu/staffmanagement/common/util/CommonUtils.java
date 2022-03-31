package com.jiayu.staffmanagement.common.util;



import com.jiayu.staffmanagement.admin.entity.AccountDTO;
import com.jiayu.staffmanagement.common.constant.CommonConstant;

import javax.servlet.http.HttpServletRequest;

/**
 * @version: 1.00.00
 * @description:
 * @copyright: Copyright (c) 2021 立林科技 All Rights Reserved
 * @company: 厦门立林科技有限公司
 * @author: linzhenyuan
 * @date: 2021-06-18 15:32
 */
public class CommonUtils {
    public static AccountDTO getAdminInfoFromSession(HttpServletRequest httpServletRequest) {
        return (AccountDTO) httpServletRequest.getSession().getAttribute(CommonConstant.ADMIN_SESSION_KEY);
    }
}
