package com.jiayu.staffmanagement.admin.controller;


import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.jiayu.staffmanagement.admin.dao.WpAccountMapper;
import com.jiayu.staffmanagement.admin.entity.AccountDTO;
import com.jiayu.staffmanagement.admin.http.AccountListResponse;
import com.jiayu.staffmanagement.admin.http.request.UserListRequest;
import com.jiayu.staffmanagement.admin.service.WpAccountService;
import com.jiayu.staffmanagement.common.constant.AccountConstant;
import com.jiayu.staffmanagement.common.constant.CommonConstant;
import com.jiayu.staffmanagement.common.constant.UserConstant;
import com.jiayu.staffmanagement.common.http.response.CommonResult;
import com.jiayu.staffmanagement.common.http.response.LayuiResponse;
import com.jiayu.staffmanagement.common.util.MD5Util;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Objects;

/**
 * @version: 1.00.00
 * @description:
 * @copyright: Copyright (c) 2021 立林科技 All Rights Reserved
 * @company: 厦门立林科技有限公司
 * @author: chenyueqi
 * @date: 2021-06-18 9:33
 */
@RestController
@RequestMapping("/admin")
public class AccountController {
    @Resource
    private WpAccountService wpAccountService;
    @Resource
    private WpAccountMapper wpAccountMapper;

    @PostMapping("/list")
    public LayuiResponse<AccountListResponse> list(@RequestBody UserListRequest request) {
        return wpAccountService.selectList(request);
    }

    @PostMapping("/login")
    public CommonResult<AccountDTO> login(AccountDTO accountDTO, HttpServletRequest httpServletRequest) throws Exception {
        if (Objects.isNull(accountDTO) || Objects.isNull(accountDTO.getUsername()) || Objects.isNull(accountDTO.getPassword())) {
            return CommonResult.failed("用户名或密码均必填，请重新输入");
        }
        accountDTO.setPassword(MD5Util.md5ByKey(accountDTO.getPassword()));
        AccountDTO account = wpAccountMapper.selectAccountByUserInfo(accountDTO);
        if (Objects.isNull(account)) {
            return CommonResult.failed("用户名或密码错误，请重新输入");
        }
        if (!Objects.equals(UserConstant.ACCOUNT_STATUS.NORMAL, account.getAccountState())) {
            return CommonResult.failed("账号停用");
        }
        httpServletRequest.getSession().setAttribute(CommonConstant.ADMIN_SESSION_KEY, account);
        return CommonResult.success(null, "登录成功");
    }

    @PostMapping("/add")
    public CommonResult<AccountDTO> add(@RequestBody AccountDTO accountDTO) throws Exception {
        List<AccountDTO> accountDTOList = wpAccountMapper.selectAccountByUsername(accountDTO.getUsername());
        if (CollectionUtils.isNotEmpty(accountDTOList)) {
            return CommonResult.failed("该用户名已存在，请重新填写");
        }
        wpAccountService.addAccount(accountDTO);
        return CommonResult.success(null, "用户添加成功");
    }

    @PostMapping("/delete")
    public CommonResult<AccountDTO> delete(Long id) {
        AccountDTO accountDTO = wpAccountMapper.selectAccountById(id);
        if (Objects.equals(AccountConstant.ADMIN, accountDTO.getUsername())) {
            return CommonResult.failed("删除用户失败,不能删除管理员");
        }
        wpAccountService.delAccountById(id);
        return CommonResult.success(null, "删除用户成功");
    }

    @PostMapping(value = "/updatePassword")
    public CommonResult<AccountDTO> updatePassword(HttpServletRequest httpServletRequest, String oldPassword, String newPassword) throws Exception {
        AccountDTO admin = (AccountDTO)httpServletRequest.getSession().getAttribute(CommonConstant.ADMIN_SESSION_KEY);
        String username = admin.getUsername();
        if (StringUtils.isBlank(oldPassword) || StringUtils.isBlank(newPassword)) {
            return CommonResult.failed("新密码和旧密码必填");
        }
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setUsername(username);
        accountDTO.setPassword(MD5Util.md5ByKey(oldPassword));
        AccountDTO user = wpAccountMapper.selectAccountByUserInfo(accountDTO);
        if (Objects.isNull(user)) {
            return CommonResult.failed("旧密码不匹配");
        }
        user.setPassword(MD5Util.md5ByKey(newPassword));
        wpAccountService.updatePassword(user);
        return CommonResult.success(null, "密码修改成功");
    }

    @PostMapping(value = "/updateUser")
    public CommonResult<AccountDTO> updateUser(AccountDTO accountDTO) throws Exception {
        List<AccountDTO> accountDTOList = wpAccountMapper.selectAccountByUsername(accountDTO.getUsername());
        if (CollectionUtils.isNotEmpty(accountDTOList) && !Objects.equals(accountDTO.getId(), accountDTOList.get(0).getId())) {
            return CommonResult.failed("该用户名已存在，请重新填写");
        }
        accountDTO.setPassword(MD5Util.md5ByKey(accountDTO.getPassword()));
        wpAccountService.updateAccount(accountDTO);
        return CommonResult.success(null, "编辑成功");
    }

}
