package com.jiayu.staffmanagement.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.jiayu.staffmanagement.admin.dao.WpAccountMapper;
import com.jiayu.staffmanagement.admin.entity.AccountDTO;
import com.jiayu.staffmanagement.admin.entity.AccountListEntity;
import com.jiayu.staffmanagement.admin.http.AccountListResponse;
import com.jiayu.staffmanagement.admin.http.request.UserListRequest;
import com.jiayu.staffmanagement.admin.service.WpAccountService;
import com.jiayu.staffmanagement.common.http.response.LayuiResponse;
import com.jiayu.staffmanagement.common.util.MD5Util;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @version: 1.00.00
 * @description:
 * @copyright: Copyright (c) 2020 立林科技 All Rights Reserved
 * @company: 厦门立林科技有限公司
 * @author: chenyueqi
 * @date: 2021-06-16 18:15
 */
@Service
public class WpAccountServiceImpl implements WpAccountService {
    @Resource
    private WpAccountMapper wpAccountMapper;

    @Override
    public LayuiResponse<AccountListResponse> selectList(UserListRequest request) {
        Page<AccountListEntity> ipage = new Page<>(request.getPage(), request.getLimit());
        QueryWrapper<AccountListEntity> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(request.getAccount())) {
            queryWrapper.like("username", request.getAccount());
        }
        queryWrapper.orderByAsc("id");
        wpAccountMapper.selectPage(ipage, queryWrapper);
        return buildLayuiResponse(ipage);
    }

    private LayuiResponse<AccountListResponse> buildLayuiResponse(Page<AccountListEntity> ipage) {
        LayuiResponse<AccountListResponse> layuiResponse = new LayuiResponse<>();
        List<AccountListEntity> accountListEntityList = ipage.getRecords();
        List<AccountListResponse> responseList = accountListEntityList.stream().map(entity -> AccountListResponse.builder()
                .id(entity.getId())
                .username(entity.getUsername())
                .password(entity.getPassword())
                .accountState(entity.getAccountState())
                .build()).collect(Collectors.toList());
        layuiResponse.setCount((int) ipage.getTotal());
        layuiResponse.setData(responseList);
        return layuiResponse;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean addAccount(AccountDTO accountDTO) throws Exception {
        accountDTO.setPassword(MD5Util.md5ByKey(accountDTO.getPassword()));
        accountDTO.setAccountState(1);
        Boolean result = wpAccountMapper.insertAccount(accountDTO);
        return result;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer delAccountById(Long id) {
        Integer account = wpAccountMapper.delAccountById(id);
        return account;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean updatePassword(AccountDTO user) {
        Boolean result = wpAccountMapper.updateAccountByUsername(user);
        return result;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean updateAccount(AccountDTO user) {
        Boolean result = wpAccountMapper.updateAccountById(user);
        return result;
    }

}
