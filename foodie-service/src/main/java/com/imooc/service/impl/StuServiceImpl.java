package com.imooc.service.impl;

import com.imooc.mapper.UsersMapper;
import com.imooc.pojo.entity.Users;
import com.imooc.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StuServiceImpl implements StuService {
    @Autowired
    private UsersMapper usersMapper;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Users getUsers(String id){
        return usersMapper.selectByPrimaryKey(id);
    }
}
