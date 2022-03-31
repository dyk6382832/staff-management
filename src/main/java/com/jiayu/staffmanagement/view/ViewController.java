package com.jiayu.staffmanagement.view;


import com.jiayu.staffmanagement.admin.entity.AccountDTO;
import com.jiayu.staffmanagement.common.constant.CommonConstant;
import com.jiayu.staffmanagement.common.util.CommonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Controller
@RequestMapping("/view")
public class ViewController {

    @RequestMapping("/adminIndex")
    public String adminIndex(Model model, HttpServletRequest httpServletRequest) {
        AccountDTO accountDTO = CommonUtils.getAdminInfoFromSession(httpServletRequest);
        if (Objects.isNull(accountDTO)) {
            return "login";
        }
        model.addAttribute("admin", accountDTO);
        return "index";
    }

    @RequestMapping("/login")
    public String adminLogin(HttpServletRequest httpServletRequest) {
        httpServletRequest.getSession().setAttribute(CommonConstant.ADMIN_SESSION_KEY, null);
        return "login";
    }

    @RequestMapping("/user-password")
    public String userPassword() {
        return "user-password";
    }

    @RequestMapping("/userList")
    public String userList() {
        return "adminUserList";
    }
}