package com.imooc.service;

import com.imooc.pojo.dto.param.UserDTO;
import com.imooc.pojo.entity.Users;

public interface UserService {
    /**
     * 判断用户名是否存在
     */
    boolean queryUsernameIsExist(String username);

    /**
     * 创建用户
     */
    Users createUser(UserDTO registerUser);

    /**
     * 根据用户名和密码判断用户是否存在，用于登录
     */
    Users queryUserForLogin(String username, String password);
}
