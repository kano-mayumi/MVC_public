package jp.co.opst.jdbc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.opst.jdbc.dao.UserAnsDao;
import jp.co.opst.jdbc.dao.UserBasicDao;
import jp.co.opst.jdbc.entity.UserAnsEntity;
import jp.co.opst.jdbc.entity.UserBasicEntity;
import jp.co.opst.jdbc.model.QuestionFormModel;
import jp.co.opst.jdbc.model.UserInfoModel;

@Service
public class QuestionFormService {

    @Autowired
    private UserBasicDao userBasicDao;

    @Autowired
    private UserAnsDao userAnsDao;

    public UserInfoModel allfind() {
        List<UserBasicEntity> ubList = userBasicDao.findAll();
        List<UserAnsEntity> uaList = userAnsDao.findAll();

        UserInfoModel uim = new UserInfoModel();
        uim.setUaList(uaList);
        uim.setUbList(ubList);
        return uim;
    }

    @Transactional(rollbackForClassName = "Exception")
    public void insert(QuestionFormModel model) throws Exception {

        UserBasicEntity ub = new UserBasicEntity();
        ub.setFstName(model.getFstName());
        ub.setLstName(model.getLstName());
        ub.setGender(model.getGender());
        ub.setAge(Integer.parseInt(model.getAge()));
        int resultCountBasic = userBasicDao.insert(ub);
        System.out.println(resultCountBasic);
        if (resultCountBasic != 1) {
            throw new Exception();
        }

        int userMaxNum = userBasicDao.findMaxUserNum();
        System.out.println("USER_BASICはUSER_NUM[" + userMaxNum + "]で登録されています");

        String[] important = model.getImportant();
        for (String i : important) {
            UserAnsEntity ua = new UserAnsEntity();
            // ua = null;
            ua.setUserNum(userMaxNum);
            ua.setSelectAns(i);
            int resultCountAns = userAnsDao.insert(ua);
            if (resultCountAns != 1) {
                throw new Exception();
            }
        }
    }
}
