package com.jiayu.staffmanagement.common.constant;

/**
 * 枚举了一些常用API操作码
 */
public enum ResultCode {
    LAYUI_SUCCESS(0, "操作成功"),
    PM_SUCCESS(1, "操作成功"),
    SUCCESS(200, "操作成功"),
    FAILED(500, "操作失败"),
    VALIDATE_FAILED(404, "参数检验失败"),
    UNAUTHORIZED(401, "暂未登录"),
    FORBIDDEN(403, "改接口禁止在生产环境执行"),
    PARAMETER_ERROR(400, "参数错误"),
    SMART_COMMUNITY_SERVICE_ERROR(501, "请求智慧社区失败"),
    CITY_EXCEL_EMPTY(600, "用户上传文件为空"),
    ERROR_SQL(601, "SQL验证未通过"),
    TABLECODE_NOTFOUND(602, "该组件尚未有对应分表号"),
    ERROR_SHARDING_SQL(603, "请输入分表SQL，表后缀使用 {tableCode} 替代"),
    SHARDING_SQL_CONTAINS_DB(604, "分表SQL不能带数据库名称，系统会根据真实情况补充数据库名称"),
    ERROR_SQL_SEMICOLON(605, "必须以分号结尾，有且只能有一个分号，不能多个语句同时执行"),
    SMS_TYPE_ERROR(701, "短信模板类型错误，查询不到模板内容"),
    SMS_CONTENT_ERROR(702, "短信内容填充错误，请查看填写标准"),
    UNFOUND_NEIGH_UPGRADE_STATUS(801, "未查询到小区升级状态"),
    HAVA_NEIGH_UPGRADE_RECORD(802, "已存在智慧社区升级记录"),
    NEIGH_EMPTY(803, "未查询到小区信息");

    private long code;
    private String message;

    ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    public long getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
