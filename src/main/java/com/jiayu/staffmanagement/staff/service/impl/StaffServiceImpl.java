package com.jiayu.staffmanagement.staff.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jiayu.staffmanagement.admin.entity.AccountListEntity;
import com.jiayu.staffmanagement.admin.http.AccountListResponse;
import com.jiayu.staffmanagement.common.http.response.LayuiResponse;
import com.jiayu.staffmanagement.staff.dao.StaffMapper;
import com.jiayu.staffmanagement.staff.entity.StaffEntity;
import com.jiayu.staffmanagement.staff.http.request.StaffListRequest;
import com.jiayu.staffmanagement.staff.http.response.StaffListResponse;
import com.jiayu.staffmanagement.staff.service.StaffService;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chenyueqi
 * @since 2022-03-25
 */
@Service
public class StaffServiceImpl implements StaffService {
    @Resource
    private StaffMapper staffMapper;

    @Override
    public LayuiResponse<StaffListResponse> selectList(StaffListRequest request) {
        Page<StaffEntity> ipage = new Page<>(request.getPage(), request.getLimit());
        QueryWrapper<StaffEntity> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(request.getUserName())) {
            queryWrapper.like("username", request.getUserName());
        }
        queryWrapper.orderByAsc("id");
        staffMapper.selectPage(ipage, queryWrapper);
        Integer count = staffMapper.selectCount(queryWrapper);
        return buildLayuiResponse(ipage, count);
    }

    @Override
    public StaffListResponse select(StaffListRequest request) {
        StaffEntity entity = staffMapper.selectById(request.getId());
        return buildResponse(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean add(StaffListRequest request) {
        StaffEntity staffEntity = new StaffEntity();
        BeanUtils.copyProperties(request, staffEntity);
        staffEntity.setDataState(1);
        staffMapper.insert(staffEntity);
        return true;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(Long id) {
        staffMapper.deleteById(id);
    }

    @Override
    public void update(StaffListRequest request) {
        StaffEntity staffEntity = new StaffEntity();
        BeanUtils.copyProperties(request, staffEntity);
        staffMapper.updateById(staffEntity);
    }

    private StaffListResponse buildResponse(StaffEntity entity) {
        return StaffListResponse.builder()
                .id(entity.getId().toString())//序号
                .age(entity.getAge())//年龄
                .sex(entity.getSex())//性别
                .post(entity.getPost())//职务
                .birthday(entity.getBirthday())//出生年月
                .cardNo(entity.getCardNo())//身份证号码
                .cardStart(entity.getCardStart())//身份证起始年月
                .cardEnd(entity.getCardEnd())//身份证终止你那月
                .center(entity.getCenter())//中心
                .commercialInsurance(entity.getCommercialInsurance())//数据状态
                .contractSigning(entity.getContractSigning())//合同签订
                .contractRenewal(entity.getContractRenewal())//合同续签
                .department(entity.getDepartment())//科室
                .dept(entity.getDept())//部门
                .joinDate(entity.getJoinDate())//入职时间
                .education(entity.getEducation())//学历
                .nation(entity.getNation())//民族
                .nativePlace(entity.getNativePlace())//户籍所在地
                .physicalExaminationItem(entity.getPhysicalExaminationItem())//体检项目
                .school(entity.getSchool())
                .speciality(entity.getSpeciality())
                .team(entity.getTeam())
                .workingYear(entity.getWorkingYear())
                .tel(entity.getTel())
                .cardNo(entity.getCardNo())
                .cardStart(entity.getCardStart())
                .cardEnd(entity.getCardEnd())
                .address(entity.getAddress())
                .emergencyContact(entity.getEmergencyContact())
                .relation(entity.getRelation())
                .emergencyContactTel(entity.getEmergencyContactTel())
                .socialSecurityCompany(entity.getSocialSecurityCompany())
                .commercialInsurance(entity.getCommercialInsurance())
                .createTime(entity.getCreateTime())
                .updateTime(entity.getUpdateTime())
                .remarks(entity.getRemarks())
                .build();
    }

    private LayuiResponse<StaffListResponse> buildLayuiResponse(Page<StaffEntity> ipage, Integer count) {
        LayuiResponse<StaffListResponse> layuiResponse = new LayuiResponse<>();
        List<StaffEntity> staffEntityList = ipage.getRecords();
        List<StaffListResponse> responseList = staffEntityList.stream().map(entity -> StaffListResponse.builder()
                .id(entity.getId().toString())
                .sex(entity.getSex())
                .userId(entity.getUserId())
                .userName(entity.getUserName())
                .age(entity.getAge())
                .post(entity.getPost())
                .birthday(entity.getBirthday())
                .cardNo(entity.getCardNo())
                .cardStart(entity.getCardStart())
                .cardEnd(entity.getCardEnd())
                .center(entity.getCenter())
                .commercialInsurance(entity.getCommercialInsurance())
                .contractSigning(entity.getContractSigning())
                .contractRenewal(entity.getContractRenewal())
                .department(entity.getDepartment())
                .dept(entity.getDept())
                .joinDate(entity.getJoinDate())
                .education(entity.getEducation())
                .nation(entity.getNation())
                .nativePlace(entity.getNativePlace())
                .physicalExaminationItem(entity.getPhysicalExaminationItem())
                .school(entity.getSchool())
                .speciality(entity.getSpeciality())
                .team(entity.getTeam())
                .workingYear(entity.getWorkingYear())
                .tel(entity.getTel())
                .cardNo(entity.getCardNo())
                .cardStart(entity.getCardStart())
                .cardEnd(entity.getCardEnd())
                .address(entity.getAddress())
                .emergencyContact(entity.getEmergencyContact())
                .relation(entity.getRelation())
                .emergencyContactTel(entity.getEmergencyContactTel())
                .socialSecurityCompany(entity.getSocialSecurityCompany())
                .commercialInsurance(entity.getCommercialInsurance())
                .createTime(entity.getCreateTime())
                .updateTime(entity.getUpdateTime())
                .remarks(entity.getRemarks())

                .build()).collect(Collectors.toList());
        layuiResponse.setCount(count);
        layuiResponse.setData(responseList);
        return layuiResponse;
    }
}
