package com.example.demo.src.member;

import com.example.demo.src.member.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class MemberDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public GetMemberInfoRes findMemberById(Long id) {
        String getMemberInfoQuery = "select m.id, m.temp,count(b.id) as 'badgeCnt',count(p.id) as 'productCnt' from member m" +
                "    left join badge b on m.id = b.member_id" +
                "    left join product p on m.id = p.seller_id" +
                "    where member_id = ?";

        Long getMemberInfoParam = id;
        return this.jdbcTemplate.queryForObject(getMemberInfoQuery,
                (rs,rowNum) -> new GetMemberInfoRes(
                        rs.getLong("id"),
                        rs.getFloat("temp"),
                        rs.getInt("badgeCnt"),
                        rs.getInt("productCnt")),
                        getMemberInfoParam);
    }


    public List<GetMemberBadgeRes> findBadgeList(Long id) {
        String query = " select b.id,badge_name,badge_content from badge b join member m on b.member_id = m.id where member_id = ? and b.status = 'ACTIVE'";
        Long param = id;
        return this.jdbcTemplate.query(query,
                (rs,rowNum) -> new GetMemberBadgeRes(
                        rs.getLong("id"),
                        rs.getString("badge_name"),
                        rs.getString("badge_content"))
                ,param);
    }

    public int updateMember(PatchMemberReq updateMember) {
        String query = "update member set password = ? ,email= ?, status = ? ,temp = ? ,phone= ? where id = ?";
        Object[] modifyUserNameParams = new Object[]{updateMember.getId(), updateMember.getPassword(),updateMember.getEmail(),updateMember.getStatus(),updateMember.getTemp(),updateMember.getPhone()};
        return this.jdbcTemplate.update(query,modifyUserNameParams);
    }

    public List<GetMemberProduct> findProductList(long id) {
        String query = "select p.title,p.content,p.price,pi.url from product p join product_image pi on p.id = pi.product_id where member_id = ?";
        Long param = id;
        return this.jdbcTemplate.query(query,
                (rs,rowNum) -> new GetMemberProduct(
                        rs.getString("title"),
                        rs.getString("content"),
                        rs.getInt("price"),
                        rs.getString("url")
                ),param);
    }

    public int deleteMember(long id) {
        String query = "delete from member where id = ?";
        long param = id;
        return this.jdbcTemplate.update(query,param);
    }

    public int insertMember(PostMemberRes member) {
        String query = "insert into member (id,password,email,status,temp,phone) value (?,?,?,?,?,?)";
        return this.jdbcTemplate.update(query,member.getId(),member.getPassword(),member.getEmail(),member.getStatus(),member.getTemp(),member.getPhone());


    }
}
