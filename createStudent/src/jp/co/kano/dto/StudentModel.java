package jp.co.kano.dto;

import java.util.ArrayList;
import java.util.List;

public class StudentModel {

    private String studentAge;
    private String studentClassNo;
    
    List<PersonalEntity> personalEntity = new ArrayList<PersonalEntity>();
    
    public List<PersonalEntity> getPersonalInfo(){
        return personalEntity;
    }
    public void setPersonalInfo(List<PersonalEntity> personalInfo) {
        this.personalEntity = personalInfo;
    }
    

    public String getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(String studentAge) {
        this.studentAge = studentAge;
    }

    public String getStudentClassNo() {
        return studentClassNo;
    }

    public void setStudentClassNo(String studentClassNo) {
        this.studentClassNo = studentClassNo;
    }


}