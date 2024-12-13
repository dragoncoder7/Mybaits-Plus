package com.dragon;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dragon.Mapper.UserMapper;
import com.dragon.Service.UserService;
import com.dragon.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class SampleTest {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
    }

    @Test
    public void testSelect() {
        User user = new User(4,"maoyunlong","maoyunlong","1026225160@qq.com",10262,"12345678");
        //System.out.println(userMapper.insert(user));
        List<Integer> list = new ArrayList<>();
        list.add(1);
        System.out.println(("----- selectAll method test ------"));
        //userMapper.selectMaps();
        userMapper.selectBatchIds(list);
        List<User> userList = userMapper.selectList(null);
        //Assert.isTrue(2 == userList.size(), "");
        userList.forEach(System.out::println);
    }


    @Test
    public void testGetOne() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .eq(User::getUsername,"maoyunlong")
                .eq(User::getId,3)
                .orderBy(false,true,User::getId);
        LambdaQueryWrapper<User> wrapper = Wrappers.<User>lambdaQuery();
        wrapper.eq(User::getId, 3);
        System.out.println(userService.listMaps());
        userService.listMaps().forEach(map -> map.forEach((key, value) -> {
            System.out.println("Key: " + key + ", Value: " + value);
            System.out.println("-----"); // 每个 Map 的分隔符
        }));
        userService.getOne(queryWrapper,false);
        userService.lambdaQuery().list();
        LambdaQueryChainWrapper<User> chainWrapper = new LambdaQueryChainWrapper<>(userMapper);
        LambdaQueryChainWrapper<User> lambdaQueryChainWrapper = new LambdaQueryChainWrapper<>(userMapper);

        User one = userService.getOne(wrapper, false); // 第二参数指定为false,使得在查到了多行记录时,不抛出异常,而返回第一条记录
        System.out.println(one);
    }

    @Test
    public void testPage() {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        // wrapper.ge(User::getAge, 28);
        // 设置分页信息, 查第3页, 每页2条数据
        Page<User> page = new Page<>(1, 2);
        // 执行分页查询
        Page<User> userPage = userMapper.selectPage(page, null);
        System.out.println("总记录数 = " + userPage.getTotal());
        System.out.println("总页数 = " + userPage.getPages());
        System.out.println("当前页码 = " + userPage.getCurrent());
        // 获取分页查询结果
        List<User> records = userPage.getRecords();
        records.forEach(System.out::println);
    }

    @Test
    public void testPage2() {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        //wrapper.ge(User::getAge, 28).likeRight(User::getName, "王");
        Page<User> page = new Page<>(3,2);
        Page<User> userPage = userMapper.selectUserPage(page, null);
        System.out.println("总记录数 = " + userPage.getTotal());
        System.out.println("总页数 = " + userPage.getPages());
        userPage.getRecords().forEach(System.out::println);
    }

    @Test
    public void insertAr() {
        User user = new User();
        //user.setId(15);
        user.setUserpassword("1206614724");
        user.setEmail("1206614724@qq.com");
        user.setUsername("湖南狸生1");
        user.setPlanetcode(122);
        System.out.println(new User().selectById(16));
        //boolean success = user.insert(); // 插入
        //System.out.println(success);
    }


}