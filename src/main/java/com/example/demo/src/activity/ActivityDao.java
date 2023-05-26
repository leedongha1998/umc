package com.example.demo.src.activity;

import com.example.demo.src.activity.model.GetActivityRes;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class ActivityDao {

    private final JdbcTemplate jdbcTemplate;

    public ActivityDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /**
     * 동네생활 리스트
     */
    public List<GetActivityRes> getActivityList() {
        String query = "select a.title,a.content, ar.name as 'areaName', c.name as 'categoryName' from activity a" +
                "    join category c on a.category_id = c.id" +
                "    join member m on m.id = a.writer" +
                "    join area ar on a.writer = a.writer";

        return this.jdbcTemplate.query(query,
                (rs,rowNum) -> new GetActivityRes(
                        rs.getString("title"),
                        rs.getString("content"),
                        rs.getString("areaName"),
                        rs.getString("categoryName")
                )
                );
    }
}
