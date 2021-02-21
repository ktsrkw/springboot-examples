package com.wt.mapper;

import com.wt.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper//这个注解相当于在mybatis核心配置文件中“注册这个mapper”
@Repository//dao层的Component，托管给springboot
public interface UserMapper {
    //查询所有用户
    List<User> getAllUsers();

    //根据id查询用户
    User getUserById(int id);

    //根据用户名查询用户
    User getUserByUsername(String username);

    //添加一个用户
    int addUser(User user);

    //更新用户的信息
    int updateUser(User user);

    //根据id删除用户
    int deleteUserById(int id);

}
