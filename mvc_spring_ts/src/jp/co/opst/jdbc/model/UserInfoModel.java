package jp.co.opst.jdbc.model;

import java.util.ArrayList;
import java.util.List;

import jp.co.opst.jdbc.entity.UserAnsEntity;
import jp.co.opst.jdbc.entity.UserBasicEntity;

public class UserInfoModel {

    List<UserBasicEntity> ubList = new ArrayList<UserBasicEntity>();

    List<UserAnsEntity> uaList = new ArrayList<UserAnsEntity>();

    public List<UserBasicEntity> getUbList() {
        return ubList;
    }

    public void setUbList(List<UserBasicEntity> ubList) {
        this.ubList = ubList;
    }

    public List<UserAnsEntity> getUaList() {
        return uaList;
    }

    public void setUaList(List<UserAnsEntity> uaList) {
        this.uaList = uaList;
    }
}
