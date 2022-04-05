package com.jiayu.staffmanagement.staff.controller;


import com.jiayu.staffmanagement.admin.entity.AccountDTO;
import com.jiayu.staffmanagement.common.constant.AccountConstant;
import com.jiayu.staffmanagement.common.http.response.CommonResult;
import com.jiayu.staffmanagement.common.http.response.LayuiResponse;
import com.jiayu.staffmanagement.staff.http.request.StaffAddRequest;
import com.jiayu.staffmanagement.staff.http.request.StaffListRequest;
import com.jiayu.staffmanagement.staff.http.response.StaffListResponse;
import com.jiayu.staffmanagement.staff.service.StaffService;
import com.jiayu.staffmanagement.staff.service.impl.StaffServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author chenyueqi
 * @since 2022-03-25
 */
@RestController
@RequestMapping("/staff")
public class StaffController {
    @Resource
    private StaffService staffService;

    @PostMapping("/list")
    public LayuiResponse<StaffListResponse> list(@RequestBody StaffListRequest request) {
        return staffService.selectList(request);
    }

    @PostMapping("/detail")
    public StaffListResponse select(@RequestBody StaffListRequest request) {
        return staffService.select(request);
    }

    @PostMapping("/add")
    public CommonResult<Boolean> add(@RequestBody StaffAddRequest request) {
        return CommonResult.success(staffService.add(request));
    }

    @PostMapping("/delete")
    public CommonResult<Boolean> delete(@RequestBody Long id) {
        staffService.delete(id);
        return CommonResult.success(null, "删除用户成功");
    }

    @PostMapping(value = "/update")
    public CommonResult<Void> update(StaffListRequest request) {
        staffService.update(request);
        return CommonResult.success(null, "编辑用户成功");
    }
}
