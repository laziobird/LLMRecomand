package com.laziobird.ai.recomand.dto;

import lombok.Data;

/**
 * rest接口通用返回值数据结构
 *
 * @param
 */
@Data
public class ResultDto<T> {
    //接口状态（成功还是失败）
    private Boolean success;
    //错误码
    private String code;
    //提示信息
    private String msg;
    //数据
    private T data;

    public void success(T data) {
        success(data, "操作成功!");
    }

    public void success(T data, String msg) {
        setSuccess(Boolean.TRUE);
        setMsg(msg);
        setData(data);
    }

}