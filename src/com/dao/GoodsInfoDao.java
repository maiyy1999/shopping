package com.dao;

import com.entity.GoodsInfo;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodsInfoDao extends BaseDao {
    /**
     * 根据商品信息类查询详细信息GoodsInfo goodsInfo
     *
     * @param goodsInfo
     * @return
     */
    public List<GoodsInfo> findByGood(GoodsInfo goodsInfo) {
        Connection conn = null;
        PreparedStatement prs = null;
        ResultSet rs = null;
        //创建一泛型为Customer的集合
        List<GoodsInfo> list = new ArrayList<>();
        try {
            //1.获取连接对象
            conn = this.getConnection();
            //2获得SQL语句
            StringBuffer sf = new StringBuffer();
            sf.append("select * from goodsInfo where 1=1 ");
            List paramList = new ArrayList();
            if (goodsInfo != null) {
                //拼接sql语句
                //gid查询
                if (goodsInfo.getId()> 0) {
                    sf.append("and id = ? ");
                    paramList.add(goodsInfo.getId());
                }
                //商品名字查询gname
                if (goodsInfo.getGname() != null) {
                    sf.append("and gname like ? ");
                    paramList.add("%" + goodsInfo.getGname() + "%");
                }
                if (goodsInfo.getPrice()>0) {
                    sf.append("and price = ? ");
                    paramList.add("%" + goodsInfo.getPrice() + "%");
                }
                //根据描述查询description
                if (goodsInfo.getDescription() != null) {
                    sf.append("and description like ? ");
                    paramList.add("%" + goodsInfo.getDescription() + "%");
                }
                //根据created(创建人)查询
                if (goodsInfo.getCreated() != null) {
                    sf.append("and created like ? ");
                    paramList.add("%" + goodsInfo.getCreated() + "%");
                }
            }
            //3获得预编译语句集
            prs = conn.prepareStatement(sf.toString());
            //4设置占位符的值
            if (paramList != null && paramList.size() > 0) {
                for (int i = 0; i < paramList.size(); i++) {
                    prs.setObject(i + 1, paramList.get(i));
                }
            }
            //5执行SQL语句并获得结果集
            rs = prs.executeQuery();
            //遍历
            while (rs.next()) {
                GoodsInfo entity = new GoodsInfo();
                entity.setId(rs.getInt("id"));
                entity.setGname(rs.getString("gname"));
                entity.setPicture(rs.getString("picture"));
                entity.setPrice(rs.getDouble("price"));
                entity.setDescription(rs.getString("description"));
                entity.setStock(rs.getInt("stock"));
                entity.setFlag(rs.getBoolean("flag"));
                entity.setCreated(rs.getString("created"));
                entity.setCreateDate(rs.getDate("createDate"));
                list.add(entity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            this.closeConnection(conn, prs, rs);
        }

        //返回集合
        return list;

    }



    /**
     * 增加customer的方法
     *
     * @return
     */
    public int addGoods(GoodsInfo goodsInfo) {
        //定义sql语句
        String sql = " INSERT INTO goodsInfo(gname,picture,price,description ,stock, flag, created,CreateDate ) VALUES (?,?,?,?,?,?,?,?)";
        //为objects增加goodsInfo的属性作为数组的值
        Object[] objects = {goodsInfo.getGname(), goodsInfo.getPicture(), goodsInfo.getPrice(),
                goodsInfo.getDescription(), goodsInfo.getStock(), goodsInfo.isFlag(),
                goodsInfo.getCreated(),goodsInfo.getCreateDate()};
        //调用BaseDao中方法实现实现增加goodsInfo
        //返会受影响的行数
        return this.updateData(sql, objects);

    }

    /**
     * 删除商品信息
     *
     * @param goodsInfo
     * @return
     */
    public int delete(GoodsInfo goodsInfo) {
        //定义sql语句
        String sql = "DELETE FROM goodsInfo WHERE id = ?";
        //根据gid来删除商品goodsInfo;
        Object[] objects = {goodsInfo.getId()};
        //返回受影响的行数
        return this.updateData(sql, objects);
    }

    /**
     * 更改商品的的属性
     * @param goodsInfo
     * @return
     */
    public int update(GoodsInfo goodsInfo){
        //拼接SQL语句
        String sql = "UPDATE goodsInfo SET gname=?,picture=?,price=?,description=? ,stock=?, flag=?, created=? ,createDate=? where id =?";
        //为objects更改goodsInfo的属性作为数组的值
        Object[] objects = {goodsInfo.getGname(), goodsInfo.getPicture(), goodsInfo.getPrice(),
                goodsInfo.getDescription(), goodsInfo.getStock(), goodsInfo.isFlag(),
                goodsInfo.getCreated(), goodsInfo.getCreateDate(),goodsInfo.getId()};
        //返回受影响的行数
        return this.updateData(sql,objects);



    }


}



