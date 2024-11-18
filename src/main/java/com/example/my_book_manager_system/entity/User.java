package com.example.my_book_manager_system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

@TableName("user")  // 指定对应数据库表名
public class User implements Serializable {

    @TableId(value = "userid", type = IdType.AUTO)  // 标记主键字段，假设主键是自增的
    private Integer userid;

    @TableField("username")  // 可选，字段名与数据库列名一致时可省略
    private String username;

    @TableField("userpassword")  // 可选
    private String userpassword;

    @TableField("isadmin")  // 可选
    private Byte isadmin;

    // Getter 和 Setter 方法
    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public Byte getIsadmin() {
        return isadmin;
    }

    public void setIsadmin(Byte isadmin) {
        this.isadmin = isadmin;
    }
}
