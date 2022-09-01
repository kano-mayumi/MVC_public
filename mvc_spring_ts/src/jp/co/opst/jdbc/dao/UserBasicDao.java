package jp.co.opst.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.opst.jdbc.entity.UserBasicEntity;

@Repository
public class UserBasicDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterTemplate;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private class UserBasicRowMapper extends BeanPropertyRowMapper<UserBasicEntity> {
        @Override
        public UserBasicEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
            UserBasicEntity entity = new UserBasicEntity();
            entity.setUserNum(rs.getInt("USER_NUM"));
            entity.setFstName(rs.getString("FST_NAME"));
            entity.setLstName(rs.getString("LST_NAME"));
            entity.setGender(rs.getString("GENDER"));
            entity.setAge(rs.getInt("AGE"));
            entity.setUpdateTime(rs.getDate("UPDATE_TIME"));
            entity.setCreateTime(rs.getDate("CREATE_TIME"));
            return entity;
        }
    }

    public List<UserBasicEntity> findAll() {
        String sql = "select * from USER_BASIC";
        List<UserBasicEntity> userBasicList = this.namedParameterTemplate.query(sql, new UserBasicRowMapper());
        return userBasicList;
    }

    public Integer findMaxUserNum() {
        String sql = "select MAX(USER_NUM) from USER_BASIC";
        Integer max = this.jdbcTemplate.queryForObject(sql, Integer.class);
        return max;
    }

    public int insert(UserBasicEntity entity) {
        String sql = "insert into USER_BASIC (FST_NAME,LST_NAME,GENDER,AGE,UPDATE_TIME,CREATE_TIME) value (:fstName,:lstName,:gender,:age,NOW(),NOW())";
        MapSqlParameterSource paramMap = new MapSqlParameterSource();
        paramMap.addValue("fstName", entity.getFstName());
        paramMap.addValue("lstName", entity.getLstName());
        paramMap.addValue("gender", entity.getGender());
        paramMap.addValue("age", entity.getAge());
        int count = this.namedParameterTemplate.update(sql, paramMap);
        return count;
    }
}
