package com.dragon.mybatisplus.samples.generator.test.service.impl;

import com.dragon.mybatisplus.samples.generator.test.entity.User;
import com.dragon.mybatisplus.samples.generator.test.mapper.UserMapper1;
import com.dragon.mybatisplus.samples.generator.test.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author mengxiaolong
 * @since 2024-12-13
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper1, User> implements IUserService {

}
