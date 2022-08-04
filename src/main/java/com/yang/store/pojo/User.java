package com.yang.store.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.ToString;

@TableName("t_user")
@Data
@ToString(callSuper = true)
public class User extends BasePojo  {

    @TableId(value = "uid", type = IdType.AUTO)
    private Integer uid ;
    private String username;
    private String password;
    // 对密码进行加密功能
    private String salt;
    private String phone;
    private String email;
    private String gender ;
    // 头像
    private String avatar;
//   逻辑删除
    @TableLogic
    @TableField("is_delete")
    private Integer isDelete;



}
