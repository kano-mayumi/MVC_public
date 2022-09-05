package jp.co.kano.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.kano.dto.PersonalEntity;
import jp.co.kano.dto.StudentEntity;

@Repository
public class StudentDao {

    @Autowired
    private NamedParameterJdbcTemplate temp;
    
    //マッピング内部クラス
    private class StudentRowMapper extends BeanPropertyRowMapper<PersonalEntity>{
        @Override
        public PersonalEntity mapRow(ResultSet rs, int rowNum) throws SQLException{
            PersonalEntity personalEntity = new PersonalEntity();
            personalEntity.setPersonalName(rs.getString("FULL_NAME"));
            personalEntity.setPersonalAddress(rs.getString("ADDRESS"));
            return personalEntity;
            
            
//            Student student = new Student();
//            student.setStudentName(rs.getString("FULL_NAME"));
//            student.setStudentAddress(rs.getString("ADDRESS"));
//            return student;
        }
        
    }
    //LAST_NAME,FIRST_NAME,ADDRESSテーブルからランダムで1件分を生成、PersonalEntityにいれて、Listに入れて返す。
    public List<PersonalEntity> getRandom(){
        String sql = "select concat (LAST_NAME,FIRST_NAME)as FULL_NAME,ADDRESS \n"
                + "from (select * from LAST_NAME order by RAND() limit 1) as LAST \n"
                + "cross join (select * from FIRST_NAME order by RAND() limit 1 )as FIRST \n"
                + "cross join (select * from ADDRESS order by RAND() limit 1) as ADDRESS;";
        List<PersonalEntity> PersonalInfo = this.temp.query(sql, new StudentRowMapper());
        return PersonalInfo;
    }
    
    public int insert(StudentEntity studentEntity){
        String sql = "insert into STUDENT (NAME,AGE,ADDRESS,CLASS_NO,UPDATE_TIME,CREATE_TIME) "
                + "value (:studentName,:studentAge,:studentAddress,:studentClassNo,now(),now());"; 
        MapSqlParameterSource paramMap = new MapSqlParameterSource();
        paramMap.addValue("studentName", studentEntity.getStudentName());
        paramMap.addValue("studentAge", studentEntity.getStudentAge());
        paramMap.addValue("studentAddress", studentEntity.getStudentAddress());
        paramMap.addValue("studentClassNo", studentEntity.getStudentClassNo());
        
        //ここでバインド変数を入れてcountにinsertの件数が入る。
        int count = this.temp.update(sql,paramMap);
        return count;
    }

    
}