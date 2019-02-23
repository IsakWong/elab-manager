package elab.serialization.beans.student;

import org.apache.ibatis.type.Alias;

@Alias("student")
public class Student {

    private String number;
    private String name;
    private String college;
    private int theoryClass;
    private int hardTime;
    private int softTime;
    private int hardScore;
    private int softScore;
    private int paperScore;
    private String email;
    private String tel;
    private String pwd;
    private String makeUpLessons;
    private String courseSelectionTime;
    private String remark;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public int getTheoryClass() { return theoryClass; }

    public void setTheoryClass(int theoryClass) { this.theoryClass = theoryClass; }

    public int getHardTime() { return hardTime; }

    public void setHardTime(int hardTime) { this.hardTime = hardTime; }

    public int getSoftTime() { return softTime; }

    public void setSoftTime(int softTime) { this.softTime = softTime; }

    public int getHardScore() { return hardScore; }

    public void setHardScore(int hardScore) { this.hardScore = hardScore; }

    public int getSoftScore() { return softScore; }

    public void setSoftScore(int softScore) { this.softScore = softScore; }

    public int getPaperScore() { return paperScore; }

    public void setPaperScore(int paperScore) { this.paperScore = paperScore; }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getMakeUpLessons() {
        return makeUpLessons;
    }

    public void setMakeUpLessons(String makeUpLessons) {
        this.makeUpLessons = makeUpLessons;
    }

    public String getCourseSelectionTime() {
        return courseSelectionTime;
    }

    public void setCourseSelectionTime(String courseSelectionTime) { this.courseSelectionTime = courseSelectionTime; }

    public String getRemark() {
        return remark;
    }

    @Override
    public String toString() {
        return number + " " + name + " " + college + " " + theoryClass + " " + hardTime + " " + softTime + " " + hardScore + " " + softScore + " " + paperScore + " " + email + " " + tel + " " + pwd + " " + makeUpLessons + " " + courseSelectionTime + " " + remark;
    }

    public Student() {
    }
}
