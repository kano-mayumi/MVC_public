package jp.co.opst.jdbc.model;

public class QuestionFormModel {

    private String lstName;
    private String fstName;
    private String gender;
    private String age;
    private String[] important;

    public String getLstName() {
        return lstName;
    }

    public void setLstName(String lstName) {
        this.lstName = lstName;
    }

    public String getFstName() {
        return fstName;
    }

    public void setFstName(String fstName) {
        this.fstName = fstName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String[] getImportant() {
        return important;
    }

    public void setImportant(String[] important) {
        this.important = important;
    }
}
