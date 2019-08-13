package com.servlet;

import com.dao.GoodsInfoDao;
import com.entity.GoodsInfo;
import com.utils.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class InsertServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        int rows = 0;

        try {
            //获取参数
            String name = req.getParameter("gname");
            //判断姓名是否为空
            if (!StringUtils.isNotNull(name)) {
                throw new RuntimeException("商品名不能为空");
            }
            String picture = req.getParameter("picture");
            //判断图片是否为空
            if (!StringUtils.isNotNull(name)) {
                throw new RuntimeException("商品图片不能为空");
            }
            String price  = req.getParameter("price");
            //判断价格是否为空
            if (!StringUtils.isNotNull(price)) {
                throw new RuntimeException("商品价格不能为空");
            }
            //创建新的商品对象
            GoodsInfo goodsInfo = new GoodsInfo();
            //为对象的属性赋值
            goodsInfo.setGname(name);
            goodsInfo.setPicture(picture);
            //将价格转为double类型
            goodsInfo.setPrice(Double.parseDouble(price));
            //得到参数值，先判断是否为空，如果为空然后给一个默认的空值，最后再为description赋值
            goodsInfo.setDescription(StringUtils.str2Int(req.getParameter("description"),null));
            //得到参数值，先判断是否为空，如果为空然后给一个默认的"0"，再转为整型，最后再为Stock赋值
            goodsInfo.setStock(Integer.parseInt(StringUtils.str2Int(req.getParameter("stock"),"0")));
            //得到参数值，先判断是否为空，如果为空然后给一个默认的"0"，再转为整型，最后再为Stock赋值
            goodsInfo.setFlag(Boolean.valueOf(req.getParameter("flag")));
            //得到参数值，先判断是否为空，如果为空然后给一个默认的null，最后再为created赋值
            goodsInfo.setCreated(StringUtils.str2Int(req.getParameter("created"),null));
            goodsInfo.setCreateDate(new java.sql.Date(System.currentTimeMillis()));


            GoodsInfoDao goodsInfoDao = new GoodsInfoDao();
            rows = goodsInfoDao.addGoods(goodsInfo);


        }catch ( RuntimeException e){
            e.printStackTrace();
        } PrintWriter out = resp.getWriter();
        if (rows > 0) {
            //如果保存成功则返回信息
            out.println("<script type='text/javascript'>alert('保存成功');location.href='select.jsp';</script>");
        } else {
            //保存不成功返回信息，并保留填入的信息
            out.println("<script type='text/javascript'>alert('保存失败');history.back();</script>");
        }

    }
}
