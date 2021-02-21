package com.wt.userDao;

import com.wt.pojo.User;
import com.wt.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import java.util.HashMap;
import java.util.List;

public class UserDaoTest {
    @Test
    public void selectTest00(){
        //执行sql步骤

        //1、利用工具类获取sqlSession，sqlSession来执行sql语句
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //2、sqlSession对象想要拿到sql，从逻辑上来说就从xml中拿，xml与接口绑定，则要从接口中拿
        //下面就是利用sqlSession的getMapper方法拿到mapper，有了这个mapper，就能执行接口中的方法，执行sql语句了
        UserDao mapper = sqlSession.getMapper(UserDao.class);

        //3、调用方法执行sql语句（一个方法与一个mapper中的某标签绑定，就能执行标签中的sql语句了）
        List<User> userList = mapper.getUserList();

        //这里循环输出结果
        for(User user:userList){
            System.out.println(user.getName());
        }

        //4、关闭sqlSession
        sqlSession.close();

    }

    @Test
    public void selectTest01(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserDao mapper = sqlSession.getMapper(UserDao.class);

        //传入参数
        User userById = mapper.getUserById(2);

        System.out.println(userById.getId());
        System.out.println(userById.getName());

        sqlSession.close();

    }

    @Test
    public void insertTest00(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserDao mapper = sqlSession.getMapper(UserDao.class);

        mapper.insertUser(new User(6,"Lina","551452"));

        //注意，在进行增删改操作时必须要用到事务，如果这里不提交，那么代码运行没有问题但表并没有被增删改，需要提交事务后才能实现增删改
        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void updateTest00(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserDao mapper = sqlSession.getMapper(UserDao.class);

        mapper.updateUser(new User(3,"Joe","123123"));

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteTest00(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserDao mapper = sqlSession.getMapper(UserDao.class);

        mapper.deleteUser(3);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void selectTest02(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserDao mapper = sqlSession.getMapper(UserDao.class);

        List<User> users = mapper.getUsers("T");

        for(User user:users){
            System.out.println(user.getName());
        }

        sqlSession.close();
    }

    @Test
    public void limitTest00(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserDao mapper = sqlSession.getMapper(UserDao.class);

        //创建map来存放参数，map就是键值对，定义时HashMap<String,Integer>转下一行
        //String就是key的类型，Integer就是这个健的值的类型，当然这两个类型可自行设置
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        map.put("startIndex",0);
        map.put("pageSize",3);

        List<User> usersByPage = mapper.getUserByLimit(map);

        for(User user:usersByPage){
            System.out.println(user.getId());
        }

    }
}



