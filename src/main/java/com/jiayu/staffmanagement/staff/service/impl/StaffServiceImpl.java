package com.jiayu.staffmanagement.staff.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jiayu.staffmanagement.admin.entity.AccountListEntity;
import com.jiayu.staffmanagement.admin.http.AccountListResponse;
import com.jiayu.staffmanagement.common.http.response.LayuiResponse;
import com.jiayu.staffmanagement.staff.dao.StaffMapper;
import com.jiayu.staffmanagement.staff.entity.StaffEntity;
import com.jiayu.staffmanagement.staff.http.request.StaffAddRequest;
import com.jiayu.staffmanagement.staff.http.request.StaffListRequest;
import com.jiayu.staffmanagement.staff.http.response.StaffListResponse;
import com.jiayu.staffmanagement.staff.service.StaffService;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
            queryWrapper.like("user_name", request.getUserName());
        }
        if (StringUtils.isNotBlank(request.getUserId())) {
            queryWrapper.like("user_id", request.getUserId());
        }
        if (StringUtils.isNotBlank(request.getDept())) {
            queryWrapper.like("dept", request.getDept());
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
    public Boolean add(StaffAddRequest request) {
        StaffEntity staffEntity = new StaffEntity();
        BeanUtils.copyProperties(request, staffEntity);
        // 解析身份证号
        Map<String, String> msg = getMsg(request.getCardNo());
        String birthDate = msg.get("birthDate");
        LocalDate date = LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("yyyyMMdd"));
        String sex = msg.get("sex");
        staffEntity.setBirthday(date);
        staffEntity.setSex(sex);
        staffEntity.setUserId(getUserId());
        staffEntity.setDataState(1);
        staffMapper.insert(staffEntity);
        return true;
    }

    /**
     * 员工工号生成算法
     * @return
     */
    private String getUserId(){
        Date date = DateUtil.date();
        String format = DateUtil.format(date, "yyyyMM");
        String userId = format + "%";
        QueryWrapper<StaffEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("user_id", userId);
        List<StaffEntity> list = staffMapper.selectList(queryWrapper);
        if (CollectionUtil.isEmpty(list)) {
            return format+"001";
        }else {
            StaffEntity entity = list.stream().max((x, y) -> Long.compare(x.getId(), y.getId())).get();
            String subId = entity.getUserId();
            subId = subId.substring(6,9);
            int num = Integer.valueOf(subId)+1;
            if (num < 10) {
                subId = "00"+num;
            }else if (10 <= num && num < 100) {
                subId = "0" + num;
            }else if (num >= 100) {
                subId = "" + num;
            }
            return format + subId;
        }
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

    /**
     * 解析身份证号，获取生日和性别
     * @param msg
     * @return
     */
    private Map<String, String> getMsg(String msg){
        Map<String, String> map = new HashMap<>(2);
        String birthDate = msg.substring(6,14);
        String gender;
        Integer sex = Integer.valueOf(msg.substring(16,17));
        map.put("birthDate", birthDate);
        if (sex%2 == 0){
            gender = "女";
        }else {
            gender = "男";
        }
        map.put("sex", gender);
        return map;
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
                .contractEnd(entity.getContractSigning().plusYears(3))
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
