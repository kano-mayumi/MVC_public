package jp.co.kano.dto;

import java.sql.Date;

public class StudentEntity {

    private int studentNo;
    private String studentName;
    private int studentAge;
    private String studentAddress;
    private int studentClassNo;
    private Date updateTime;
    private Date createTime;

    public int getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(int studentNo) {
        this.studentNo = studentNo;
    }

    public String getStudentName() {
        return (studentName.trim());
    }

    public void setStudentName(String studentName) {
        this.studentName = (studentName.trim());
    }

    public int getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(int studentAge) {
        this.studentAge = studentAge;
    }

    public String getStudentAddress() {
        return (studentAddress.trim());
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = (studentAddress.trim());
    }

    public int getStudentClassNo() {
        return studentClassNo;
    }

    public void setStudentClassNo(int studentClassNo) {
        this.studentClassNo = studentClassNo;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
