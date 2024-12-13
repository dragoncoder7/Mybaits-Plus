package com.dragon.mybatisplus.samples.generator.test.mapper;

import com.dragon.mybatisplus.samples.generator.test.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户 Mapper 接口
 * </p>
 *
 * @author mengxiaolong
 * @since 2024-12-13
 */
@Mapper
public interface UserMapper1 extends BaseMapper<User> {
}
