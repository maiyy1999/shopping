package com.servlet;

import com.dao.GoodsInfoDao;
import com.entity.GoodsInfo;
import com.utils.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SelectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置字符集
        //获取从URL传来的参数
        GoodsInfoDao goodsInfoDao = new GoodsInfoDao();
        GoodsInfo goodsInfo = new GoodsInfo();
        String id = req.getParameter("id");
        //转为整型
        goodsInfo.setId(Integer.parseInt(id));
        //根据id来插查询详细数据
        List<GoodsInfo> list = goodsInfoDao.findByGood(goodsInfo);
        req.setAttribute("list", list);
        req.getRequestDispatcher("one_list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置字符集
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;utf-8");

        //调用StringUtils.str2Int()将字符串转换为Integer
        String id = req.getParameter("id");
        id = StringUtils.str2Int(id,"0");
        //获得参数
        String gname = req.getParameter("gname");
        //获得picture的值
        String picture = req.getParameter("picture");
        //获取 price 的值  double
        String price = req.getParameter("price");
        price = StringUtils.str2Int(price,"0");
        //根据参数得到值
        String description = req.getParameter("description");
        String created = req.getParameter("created");
        //新建商品的DAO类
        GoodsInfoDao goodsInfoDao = new GoodsInfoDao();
        //新建一个商品类的对象
        GoodsInfo goodsInfo = new GoodsInfo();
        //为对象增加属性
        goodsInfo.setId(Integer.parseInt(id));
        //判断参数得到的值是否是为空，然后在为得到的字符串
        goodsInfo.setGname(StringUtils.str2Int(gname,null));
        goodsInfo.setPicture(StringUtils.str2Int(picture,null));
        goodsInfo.setPrice(Double.parseDouble(price));
        goodsInfo.setDescription(StringUtils.str2Int(description,null));
        goodsInfo.setCreated(StringUtils.str2Int(created,null));
        //调用方法
        List<GoodsInfo> list = goodsInfoDao.findByGood(goodsInfo);
        //把得到值设成键值对的形式
        req.setAttribute("list",list);
        //转发
        req.getRequestDispatcher("/search.jsp").forward(req,resp);



    }
}
