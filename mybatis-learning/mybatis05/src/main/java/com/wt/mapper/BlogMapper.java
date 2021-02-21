package com.wt.mapper;

import com.wt.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
    //插入数据
    void insertBlog(Blog blog);

    //环境测试
    List<Blog> getAllBlogs();

    //动态sql
    List<Blog> getBlogsByDynamicSQL(Map map);
    //动态sql where标签测试
    List<Blog> getBlogsByDynamicSQL1(Map map);
    //动态sql choose标签测试
    List<Blog> getBlogsByDynamicSQL2(Map map);
    //动态sql set标签测试
    void updateByDynamicSQL(Map map);

}
