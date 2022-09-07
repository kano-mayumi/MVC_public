package jp.co.kano.dto;

public class CreateStudentFormModel {

    //画面の入力値をここに入れる(StudentModelだと名前と住所がListになってしまうため)
    private String studentName;
    private Integer studentAge;
    private String studentAddress;
    private Integer studentClassNo;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = (studentName.trim());
        
    }

    public Integer getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(Integer studentAge) {
        this.studentAge = studentAge;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = (studentAddress.trim());
    }

    public Integer getStudentClassNo() {
        return studentClassNo;
    }

    public void setStudentClassNo(Integer studentClassNo) {
        this.studentClassNo = studentClassNo;
    }

}
