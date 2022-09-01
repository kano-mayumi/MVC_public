package jp.co.opst.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.opst.jdbc.entity.UserAnsEntity;

@Repository
public class UserAnsDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterTemplate;

    private class UserAnsRowMapper extends BeanPropertyRowMapper<UserAnsEntity> {
        @Override
        public UserAnsEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
            UserAnsEntity entity = new UserAnsEntity();
            entity.setUserNum(rs.getInt("USER_NUM"));
            entity.setSelectAns(rs.getString("SELECT_ANS"));
            return entity;
        }
    }

    public List<UserAnsEntity> findAll() {
        String sql = "select * from USER_ANS";
        List<UserAnsEntity> userAnsList = this.namedParameterTemplate.query(sql, new UserAnsRowMapper());
        return userAnsList;
    }

    public int insert(UserAnsEntity entity) {
        String sql = "insert into USER_ANS value ( :userNum, :selectAns )";
        MapSqlParameterSource paramMap = new MapSqlParameterSource().addValue("userNum", entity.getUserNum())
                .addValue("selectAns", entity.getSelectAns());
        int count = this.namedParameterTemplate.update(sql, paramMap);
        return count;
    }
}
