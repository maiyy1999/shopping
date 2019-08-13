package com.servlet;

import com.dao.GoodsInfoDao;
import com.entity.GoodsInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取从URL传来的参数
        GoodsInfo goodsInfo = new GoodsInfo();
        String id = req.getParameter("id");
        //转为整型
        goodsInfo.setId(Integer.parseInt(id));
        GoodsInfoDao goodsInfoDao = new GoodsInfoDao();
        int rows = goodsInfoDao.delete(goodsInfo);
        PrintWriter out = resp.getWriter();
        if(rows>0){
            //如果保存成功则返回信息
            out.println("<script type='text/javascript'>alert('删除成功');location.href='select.jsp';</script>");
        }else  //如果保存成功则返回信息
            out.println("<script type='text/javascript'>alert('删除失败');location.href='select.jsp';</script>");

    }
}
