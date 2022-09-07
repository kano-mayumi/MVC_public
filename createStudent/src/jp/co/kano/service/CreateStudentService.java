package jp.co.kano.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.kano.dao.StudentDao;
import jp.co.kano.dto.CreateStudentFormModel;
import jp.co.kano.dto.PersonalEntity;
import jp.co.kano.dto.StudentEntity;
import jp.co.kano.dto.StudentModel;
import jp.co.kano.util.RandomNumberUtil;

@Service
public class CreateStudentService {

    @Autowired
    private StudentDao studentDao;

    public StudentModel createStudent() {
        
        //personalInfo(FULL_NAMEとADDRESS情報)を受け取り、ageとclassNOをランダム生成してstudentModelに入れる。
        //studentModel << age,classNo  <<personalInfo
        List<PersonalEntity> personalInfo = studentDao.getRandom();
        
        RandomNumberUtil randomNumberUtil = new RandomNumberUtil();
        StudentModel studentModel = new StudentModel();
        studentModel.setStudentAge(Integer.toString(randomNumberUtil.getAge()));
        studentModel.setStudentClassNo(Integer.toString(randomNumberUtil.getClassNo()));
        studentModel.setPersonalInfo(personalInfo);
        return studentModel;
    }
    
    @Transactional(rollbackForClassName = "Exception")
    public void insert(CreateStudentFormModel studentFormModel) throws Exception{
        StudentEntity se = new StudentEntity();
        se.setStudentName(studentFormModel.getStudentName());
        se.setStudentAge(studentFormModel.getStudentAge());
        se.setStudentAddress(studentFormModel.getStudentAddress());
        se.setStudentClassNo(studentFormModel.getStudentClassNo());
        
        //insert件数を返す
        int resultCountBasic = studentDao.insert(se);
        System.out.println(resultCountBasic);
        if (resultCountBasic != 1) {
            throw new Exception();
        }
    }
}

