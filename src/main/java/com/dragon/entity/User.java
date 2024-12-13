package com.dragon.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.context.annotation.Primary;

import java.io.Serial;
import java.io.Serializable;

@EqualsAndHashCode(callSuper = false)
@Data
@TableName("`user`")
public class User extends Model<User> implements Serializable {
    @Serial
    private static final long serialVersionUID = -2132255216887456640L;
    @TableId(value = "id")
    private Integer id;
    private String username;
    private String useraccount;
    private String email;
    private Integer planetcode;
    private String userpassword;

    public User(Integer id, String username, String useraccount, String email, Integer planetcode) {
        this.id = id;
        this.username = username;
        this.useraccount = useraccount;
        this.email = email;
        this.planetcode = planetcode;
    }

    public User(Integer id, String username, String useraccount, String email, Integer planetcode, String userPassword) {
        this.id = id;
        this.username = username;
        this.useraccount = useraccount;
        this.email = email;
        this.planetcode = planetcode;
        this.userpassword = userPassword;
    }

    public User() {

    }
}
