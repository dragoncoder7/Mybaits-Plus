package com.dragon.Controller;

import com.dragon.entity.User;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class a {
    //    @Resource
//     UserMapper userMapper;
    public static void main(String[] args) {
        User user = new User(3,"maoyunlong","maoyunlong","1026225160@qq.com",10262);
        //new UserMapper().insert(user);
    }
}
