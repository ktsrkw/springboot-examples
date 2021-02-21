package com.wt.userDao;

import com.wt.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
    //查询所有用户
    List<User> getUserList();

    //根据id查询用户
    User getUserById(int id);

    //插入一个用户
    void insertUser(User user);

    //修改一个用户
    void updateUser(User user);

    //删除一个用户
    void deleteUser(int id);

    //模糊查询
    List<User> getUsers(String value);

    //分页测试
    List<User> getUserByLimit(Map<String,Integer> map);
}
