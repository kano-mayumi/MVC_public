/*
 * 「ONLINE_MEMBER」のDao
 *　2022年9月9日
 */

package jp.co.kano.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.kano.entity.MemberEntity;

@Repository
public class MemberDao {

	@Autowired
	private NamedParameterJdbcTemplate temp;

	//マッピング
	private class MemberRowMapper extends BeanPropertyRowMapper<MemberEntity>{
		@Override
		public MemberEntity mapRow(ResultSet rs, int rowNum) throws SQLException{
			MemberEntity me = new MemberEntity();
			me.setMemberPassword(rs.getString("PASSWORD"));
			me.setMemberName(rs.getString("NAME"));
			me.setMemberAge(Integer.parseInt(rs.getString("AGE")));
			me.setMemberSex(rs.getString("SEX"));
			me.setMemberAddress(rs.getString("ADDRESS"));
			me.setMemberZip(rs.getString("ZIP"));
			me.setMemberTel(rs.getString("TEL"));

			return me;


		}

	}
	/*
	 * 「ONLINE_MEMBER」にMemberEntity情報を登録する。
	 * 戻り値　登録件数
	*/
	public int insertMember(MemberEntity memberEntity) {
		String sql = "insert into ONLINE_MEMBER"
				+ "(PASSWORD,NAME,AGE,SEX,ZIP,ADDRESS,TEL,REGISTER_DATE,DELETE_FLG,LAST_UPD_DATE)"
				+ "value(:password,:name,:age,:sex,:zip,:address,:tel,NOW(),1,NOW())";

		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("password",memberEntity.getMemberPassword());
		paramMap.addValue("password",memberEntity.getMemberName());
		paramMap.addValue("password",memberEntity.getMemberAge());
		paramMap.addValue("password",memberEntity.getMemberSex());
		paramMap.addValue("password",memberEntity.getMemberZip());
		paramMap.addValue("password",memberEntity.getMemberAddress());
		paramMap.addValue("password",memberEntity.getMemberTel());

		int count = this.temp.update(sql,paramMap);
		return count;
	}

	/*
	 * 登録後、会員番号を取得する。
	*/
	public String getMemberNo() {



		return memberNo;
	}
}
