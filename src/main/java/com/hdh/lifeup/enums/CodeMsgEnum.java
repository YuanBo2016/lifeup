package com.hdh.lifeup.enums;

import lombok.Getter;

/**
 * CodeMsgEnum enum<br/>
 * 与客户端交互的状态码信息类
 *
 * @author hdonghong
 * @since 2018/08/10
 */
@Getter
public enum CodeMsgEnum {

    /** 通用模块状态码  */
    SUCCESS(200, "success"),
    SERVER_ERROR(500100, "服务端异常错误"),
    PARAMETER_ERROR(500101, "请求参数校验错误"),
    PARAMETER_NULL(500102, "传递了空值"),

    /** 用户模块 5002XX */
    USER_NOT_EXIST(500201, "用户不存在"),

    /** 事项模块 5003XX */
    TASK_NOT_EXIST(500301, "个人事项不存在"),

    ;

    private int code;
    private String msg;

    CodeMsgEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}