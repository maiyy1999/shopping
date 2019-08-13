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

import java.util.List;

public class UpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置字符集
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;utf-8");
        //获取从URL传来的参数
        String id = req.getParameter("id");
        GoodsInfo goodsInfo = new GoodsInfo();
        //转为整型
        goodsInfo.setId(Integer.parseInt(id));
        GoodsInfoDao goodsInfoDao = new GoodsInfoDao();
        //根据id来插查询详细数据
        List<GoodsInfo> list = goodsInfoDao.findByGood(goodsInfo);
        req.setAttribute("list", list);
        req.getRequestDispatcher("update.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            //获取参数
            String name = req.getParameter("gname");
            //判断姓名是否为空
            if (!StringUtils.isNotNull(name)) {
                throw new RuntimeException("商品名不能为空，请重新输入");
            }
            String picture = req.getParameter("picture");
            //判断图片是否为空
            if (!StringUtils.isNotNull(name)) {
                throw new RuntimeException("商品图片不能为空，请重新输入");
            }
            String price = req.getParameter("price");
            //判断价格是否为空
            if (!StringUtils.isNotNull(price)) {
                throw new RuntimeException("商品价格不能为空，请重新输入");
            }
            //创建新的商品对象
            GoodsInfo good = new GoodsInfo();


            //为对象的属性赋值
            good.setGname(name);
            good.setPicture(picture);
            //将价格转为double类型
            good.setPrice(Double.parseDouble(price));
            good.setId(Integer.parseInt(req.getParameter("id")));
            //得到参数值，先判断是否为空，如果为空然后给一个默认的空值，最后再为description赋值
            good.setDescription(StringUtils.str2Int(req.getParameter("description"), null));
            //得到参数值，先判断是否为空，如果为空然后给一个默认的"0"，再转为整型，最后再为Stock赋值
            good.setStock(Integer.parseInt(StringUtils.str2Int(req.getParameter("stock"), "0")));
            //得到参数值，先判断是否为空，如果为空然后给一个默认的null，最后再为Stock赋值
            good.setCreated(StringUtils.str2Int(req.getParameter("created"), null));
            //得到参数值，先判断是否为空，如果为空然后给一个默认的null，最后再为created赋值
            good.setFlag(Boolean.valueOf(req.getParameter("flag")));
            good.setCreateDate(new java.sql.Date(System.currentTimeMillis()));
            GoodsInfoDao goodsInfoDao = new GoodsInfoDao();
            int rows =  goodsInfoDao.update(good);
            PrintWriter out = resp.getWriter();
            if(rows>0){
                out.println("<script type='text/javascript'>alert('保存成功');location.href='select.jsp';</script>");
            }



        }
        catch (RuntimeException e){
            e.printStackTrace();
        }
    }
}
