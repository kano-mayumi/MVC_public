package jp.co.kano.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.kano.dao.MemberDao;
import jp.co.kano.entity.MemberEntity;
import jp.co.kano.model.MemberModel;

@Service
public class UserService {

	@Autowired
	private MemberDao memberDao;


	@Transactional(rollbackForClassName = "Exception")
	public void insertMember(MemberModel memberModel) throws Exception{
		MemberEntity me = new MemberEntity();

		me.setMemberPassword(memberModel.getPassword());
		me.setMemberName(memberModel.getName());
		me.setMemberAge(memberModel.getAge());

		if (memberModel.getSex() == "female") {
			me.setMemberSex("F");
		}else if (memberModel.getSex()=="male") {
			me.setMemberSex("M");
		}

		me.setMemberZip(memberModel.getZip());
		me.setMemberAddress(memberModel.getAddress());
		me.setMemberTel(memberModel.getTel());

		int updateCount = memberDao.insertMember(me);
		if(updateCount != 1) {
			throw new Exception();
		}
	}

	public String getMemberNo() {
		String memberNo = memberDao.getMemberNo();
		return memberNo;
	}

}
