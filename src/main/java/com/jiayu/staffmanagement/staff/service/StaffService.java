package com.jiayu.staffmanagement.staff.service;


import com.jiayu.staffmanagement.common.http.response.LayuiResponse;
import com.jiayu.staffmanagement.staff.http.request.StaffListRequest;
import com.jiayu.staffmanagement.staff.http.response.StaffListResponse;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author chenyueqi
 * @since 2022-03-25
 */
public interface StaffService {

    /**
     * 分页查询
     * @param request
     * @return
     */
    LayuiResponse<StaffListResponse> selectList(StaffListRequest request);

    /**
     * 单个查询
     * @param request
     * @return
     */
    StaffListResponse select(StaffListRequest request);

    /**
     * 新增
     * @param request
     * @return
     */
    Boolean add(StaffListRequest request);

    /**
     * 根据id删除
     * @return
     */
    void delete(Long ids);

    /**
     * 编辑
     * @param request
     */
    void update(StaffListRequest request);
}
