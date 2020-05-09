package com.imooc.pojo.dto.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 注册用户时的请求参数
 */
@ApiModel(value = "用户对象DTO", description = "用户登录时，用于封装用户传入的数据")
@Data
public class UserDTO {
    @ApiModelProperty(value = "用户名", name = "username", example = "imooc", required = true)
    private String username;
    @ApiModelProperty(value = "密码", name = "password", example = "123456", required = true)
    private String password;
    @ApiModelProperty(value = "确认密码", name = "confirmPassword", example = "123456", required = true)
    private String confirmPassword;

    public static void main(String[] args) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername("haha");
        UserDTO.test(userDTO);
        System.out.println(userDTO.getUsername());
    }

    private static UserDTO test(UserDTO test){
        test.setUsername("xiugai");
        return test;
    }
}


