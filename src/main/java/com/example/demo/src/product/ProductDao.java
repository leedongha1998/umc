package com.example.demo.src.product;

import com.example.demo.src.product.model.GetProductRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class ProductDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ProductDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<GetProductRes> getProductList() {
        String query = "select p.title,p.content,p.created_at,p.price, p.likes,p.chats,pi.url, a.name from product p join product_image pi on p.id = pi.product_id join member_area ma on p.seller_id = ma.member_id join area a on a.id = ma.area_id order by p.created_at desc";
        return this.jdbcTemplate.query(query,
                (rs,rowNum) -> new GetProductRes(
                        rs.getString("title"),
                        rs.getString("content"),
                        rs.getTimestamp("created_at").toLocalDateTime(),
                        rs.getInt("price"),
                        rs.getInt("likes"),
                        rs.getInt("chats"),
                        rs.getString("url"),
                        rs.getString("name")
                )
                );
    }

    public List<GetProductRes> findProductBySearch(String search) {
        String query = "select p.title,p.content,p.created_at,p.price, p.likes,p.chats,pi.url, a.name from product p join product_image pi on p.id = pi.product_id join member_area ma on p.seller_id = ma.member_id join area a on a.id = ma.area_id where p.title like '%?%' or p.content like '%?%' order by p.created_at desc";
        String param = search;
        return this.jdbcTemplate.query(query,
                (rs,rowNum) -> new GetProductRes(
                        rs.getString("title"),
                        rs.getString("content"),
                        rs.getTimestamp("created_at").toLocalDateTime(),
                        rs.getInt("price"),
                        rs.getInt("likes"),
                        rs.getInt("chats"),
                        rs.getString("url"),
                        rs.getString("name")
                ),
                param);
    }
}
