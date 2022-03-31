package com.jiayu.staffmanagement.staff.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author chenyueqi
 * @since 2022-03-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName(value = "t_staff")
public class StaffEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 序号
     */
    @TableId(type = IdType.AUTO)
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

    /**
     * 数据状态。0：新记录。新增的记录即为新记录 。1：更新记录，新记录数据如果进行了更新操作，即变成更新记录。2：待删除记录，删除记录并不是马上就删除，而是先对记录进行待删除的标记，达到生命周期后再进行删除。
     */
    private Integer dataState;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 照片
     */
 /*   private String photo;*/


}
