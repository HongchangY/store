package com.yang.store.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yang.store.mapper.UserMapper;
import com.yang.store.pojo.User;
import com.yang.store.service.UserService;
import com.yang.store.service.ex.InsertException;
import com.yang.store.service.ex.UsernameDupulicatedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;


    @Override
    public void register(User user) {
        // 1. 判断用户名是否有相同的，查看用户是否已存在
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",user.getUsername());
        User existUser = userMapper.selectOne(queryWrapper);
        if (existUser != null){
            throw new UsernameDupulicatedException("用户名已存在");
        }
//        执行注册的业务
//        2.补全日志信息
        Date date = new Date(); // 创建时间点 然后让下面一致
        user.setCreatedUser(user.getUsername());
        user.setCreatedTime(date);
        user.setModifiedUser(user.getUsername());
        user.setModifiedTime(date);

//       3.设置盐值，对密码加盐处理
//       "盐 + 密码 + 盐" 然后MD5加密
        String salt = UUID.randomUUID().toString().toUpperCase(); // 转换为大写可要可不要
//        保存盐值
        user.setSalt(salt);
        String password = getMD5Password(user.getPassword(), salt);
//        保存MD5加密后的密码
        user.setPassword(password);
//       4.设置isDelete为0
        user.setIsDelete(0);

        int insert = userMapper.insert(user);
//       避免插入时出现宕机等情况
        if (insert != 1){
            throw new InsertException("注册过程中产生了未知的异常");
        }
    }

//    提取密码和盐的MD5加密方法，登录时要用
    private String getMD5Password(String password,String salt){
        for (int i = 0; i < 3; i++) {
            password = DigestUtils.md5DigestAsHex((salt+password+salt).getBytes()).toUpperCase();
        }
        return password;
    }
}
