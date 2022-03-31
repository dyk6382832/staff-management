package com.jiayu.staffmanagement.admin.service;



import com.jiayu.staffmanagement.admin.entity.AccountDTO;
import com.jiayu.staffmanagement.admin.http.AccountListResponse;
import com.jiayu.staffmanagement.admin.http.request.UserListRequest;
import com.jiayu.staffmanagement.common.http.response.LayuiResponse;


public interface WpAccountService {

    /**
     * 分页查询
     * @param request
     * @return
     */
    LayuiResponse<AccountListResponse> selectList(UserListRequest request);

    /**
     * 新增用户
     * @param user
     * @return
     */
    Boolean addAccount(AccountDTO user) throws Exception;

    /**
     * 根据id删除用户
     * @param id
     * @return
     */
    Integer delAccountById(Long id);

    /**
     * 用户修改密码
     * @return
     */
    Boolean updatePassword(AccountDTO user);

    /**
     * 用户编辑
     * @return
     */
    Boolean updateAccount(AccountDTO user);

}
