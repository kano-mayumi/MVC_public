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
            //ジェネリクスで指定したインスタンスを生成。ここの流れは同じ
            //Entityは検索結果の1レコード分を入れる。作るときは、まずテーブルのカラムを見るようにする。
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
        //sqlの結果を詰めてリストにして返してくれる→userBasicRowMapper()
        List<UserBasicEntity> userBasicList = this.namedParameterTemplate.query(sql, new UserBasicRowMapper());
        return userBasicList;
    }

    //USER_NUMの最大値を検索
    public Integer findMaxUserNum() {
        String sql = "select MAX(USER_NUM) from USER_BASIC";
        
        //jdbcTemplateにしかqueryForObjectがない
        Integer max = this.jdbcTemplate.queryForObject(sql, Integer.class);
        return max;
    }

    //登録したいデータが引数の中に入っている
    public int insert(UserBasicEntity entity) {
        String sql = "insert into USER_BASIC (FST_NAME,LST_NAME,GENDER,AGE,UPDATE_TIME,CREATE_TIME) value (:fstName,:lstName,:gender,:age,NOW(),NOW())";
        MapSqlParameterSource paramMap = new MapSqlParameterSource();
        paramMap.addValue("fstName", entity.getFstName());
        paramMap.addValue("lstName", entity.getLstName());
        paramMap.addValue("gender", entity.getGender());
        paramMap.addValue("age", entity.getAge());
        //update(発行したsql,バインド変数を入れる変数)
        int count = this.namedParameterTemplate.update(sql, paramMap);
        return count;
    }
}
