package com.yang.store.utils;

import lombok.Data;

import java.io.Serializable;

/**
 * 处理响应的
 */

@Data
public class JsonResults<E> {

    /** 状态码 */
    private Integer status;
    /** 返回的信息 */
    private String message;
    /** 返回的数据 */
    private E data;

    public JsonResults() {
    }

    public JsonResults(Integer status) {
        this.status = status;
    }

    /** 异常类的信息赋给message */
    public JsonResults(Throwable e) {
        this.message = e.getMessage();
    }

    public JsonResults(Integer status, E data) {
        this.status = status;
        this.data = data;
    }
}
