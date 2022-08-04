package com.yang.store.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 *  用于继承的基类  日志类
 */
@Data
public class BasePojo implements Serializable {
//  创建者
    private String createdUser;
//  创建时间
    private Date createdTime;
//  修改者
    private String modifiedUser;
//  修改时间
    private Date modifiedTime;


}
