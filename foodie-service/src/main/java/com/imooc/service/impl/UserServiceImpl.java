package com.imooc.service.impl;

import com.imooc.enums.SexEnum;
import com.imooc.mapper.UsersMapper;
import com.imooc.pojo.dto.param.UserDTO;
import com.imooc.pojo.entity.Users;
import com.imooc.service.UserService;
import com.imooc.utils.DateUtils;
import com.imooc.utils.MD5Utils;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private Sid sid;

    private static final String USER_FACE = "http://122.152.205.72:88/group1/M00/00/05/CpoxxFw_8_qAIlFXAAAcIhVPdSg994.png";
    private static final String INITIAL_DATE = "1900-01-01";

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public boolean queryUsernameIsExist(@NonNull String username) {
        Example userExample = new Example(Users.class);
        Example.Criteria userCriteria = userExample.createCriteria();
        userCriteria.andEqualTo("username", username);
        Users result = usersMapper.selectOneByExample(userExample);

        return result != null ? true : false;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Users createUser(UserDTO registerUser) {
        Users user = new Users();
        user.setId(sid.nextShort());
        user.setUsername(registerUser.getUsername());

        try {
            user.setPassword(MD5Utils.getMD5Str(registerUser.getPassword()));
        } catch (Exception e) {
            log.error("MD5转换失败，失败原因:", e);
            e.printStackTrace();
        }

        user.setNickname(registerUser.getUsername());
        user.setFace(USER_FACE);
        user.setBirthday(DateUtils.stringToDate(INITIAL_DATE));
        user.setSex(SexEnum.SECRET.getCode());

        user.setCreatedTime(new Date());
        user.setUpdatedTime(new Date());

        usersMapper.insert(user);

        return user;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Users queryUserForLogin(String username, String password) {
        Example userExample = new Example(Users.class);
        Example.Criteria userCriteria = userExample.createCriteria();
        userCriteria.andEqualTo("username", username);
        userCriteria.andEqualTo("password", password);

        Users result = usersMapper.selectOneByExample(userExample);

        return result;
    }
}
