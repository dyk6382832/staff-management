package com.jiayu.staffmanagement.staff.http.request;

import com.jiayu.staffmanagement.common.http.request.LayuiRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @version: 1.00.00
 * @description: 用户请求
 * @copyright: Copyright (c) 2020 立林科技 All Rights Reserved
 * @company: 厦门立林科技有限公司
 * @author: chenyueqi
 * @date: 2021-06-22 15:19
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class StaffListRequest extends LayuiRequest {

    /**
     * 序号
     */
    private Long id;
    /**
     * 体检项目
     */
    private String physicalExaminationItem;

    /**
     * 姓名
     */
    private String userName;

    /**
     * 员工编号
     */
    private Integer userId;

    /**
     * 民族
     */
    private String nation;

    /**
     * 性别
     */
    private String sex;

    /**
     * 文化程度
     */
    private String education;

    /**
     * 学校
     */
    private String school;

    /**
     * 专业
     */
    private String speciality;

    /**
     * 中心
     */
    private String center;

    /**
     * 部门
     */
    private String dept;

    /**
     * 科室
     */
    private String department;

    /**
     * 班组
     */
    private String team;

    /**
     * 职务
     */
    private String post;

    /**
     * 入职时间
     */
    private LocalDate joinDate;

    /**
     * 本企工龄
     */
    private Integer workingYear;

    /**
     * 出生日期
     */
    private LocalDate birthday;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 联系电话
     */
    private String tel;

    /**
     * 身份证号码
     */
    private String cardNo;

    /**
     * 身份证起始年月
     */
    private LocalDate cardStart;

    /**
     * 身份证终止年月
     */
    private LocalDate cardEnd;

    /**
     * 户口所在地
     */
    private String nativePlace;

    /**
     * 通讯地址
     */
    private String address;

    /**
     * 合同签订
     */
    private LocalDate contractSigning;

    /**
     * 合同续签
     */
    private LocalDate contractRenewal;

    /**
     * 紧急联系人
     */
    private String emergencyContact;

    /**
     * 关系
     */
    private String relation;

    /**
     * 紧急联系人电话
     */
    private String emergencyContactTel;

    /**
     * 社保缴交公司
     */
    private String socialSecurityCompany;

    /**
     * 商业险
     */
    private String commercialInsurance;

    /**
     * 备注
     */
    private String remarks;

}
