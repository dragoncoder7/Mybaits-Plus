package com.dragon.Service.Imp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.dragon.Mapper.UserMapper;
import com.dragon.Service.UserService;
import com.dragon.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp extends ServiceImpl<UserMapper, User> implements UserService {
}
