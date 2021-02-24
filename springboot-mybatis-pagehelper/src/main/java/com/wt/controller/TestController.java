package com.wt.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wt.mapper.GoodsMapper;
import com.wt.mapper.UserMapper;
import com.wt.pojo.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TestController {
    @Autowired
    GoodsMapper goodsMapper;

    @Autowired
    UserMapper userMapper;

    @GetMapping({"/","/index"})
    public String index(Model model,
                        @RequestParam(required = false,defaultValue="1",value="pageNum")Integer pageNum,
                        @RequestParam(defaultValue="3",value="pageSize")Integer pageSize){
//        List<Goods> goods = goodsMapper.getAllGoods();
//        model.addAttribute("goods",goods);

        //为了程序的严谨性，判断非空：
        if(pageNum == null){
            pageNum = 1;   //设置默认当前页
        }
        if(pageNum <= 0){
            pageNum = 1;
        }
        if(pageSize == null){
            pageSize = 3;    //设置默认每页显示的数据数
        }

        //1.引入分页插件,pageNum是第几页，pageSize是每页显示多少条,默认查询总数count
        //既获取第pageNum页，pageSize条内容
        PageHelper.startPage(pageNum,pageSize);
        //2.紧跟的查询就是一个分页查询-必须紧跟.后面的其他查询不会被分页，除非再次调用PageHelper.startPage
        List<Goods> goods = goodsMapper.getAllGoods();
        //3.使用PageInfo包装查询后的结果,pageSize是连续显示的条数,结果list类型是Page<E>
//        PageInfo<Goods> pageInfo = new PageInfo<Goods>(goods,pageSize);
        PageInfo pageInfo = new PageInfo(goods);
        //4.使用model/map/modelandview等带回前端
        model.addAttribute("goods",goods);
        model.addAttribute("pageInfo",pageInfo);

        return "index";
    }
}
