package elab.serialization.beans.member;

import org.apache.ibatis.type.Alias;

@Alias("member")
public class Member {

    private String number;
    private String userName;
    private String name;
    private String namePinYin;
    private String sex;
    private String college;
    private String group;
    private String tel;
    private String duty;
    private String grade;
    private String motto;
    private String password;
    private int teachingAmount;
    private int assistAmount;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNamePinYin() {
        return namePinYin;
    }

    public void setNamePinYin(String namePinYin) {
        this.namePinYin = namePinYin;
    }


    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTeachingAmount() {
        return teachingAmount;
    }

    public void setTeachingAmount(int teachingAmount) {
        this.teachingAmount = teachingAmount;
    }

    public int getAssistAmount() {
        return assistAmount;
    }

    public void setAssistAmount(int assistAmount) {
        this.assistAmount = assistAmount;
    }

    @Override
    public String toString() {
        return number + " " + userName + " " + name + " " + namePinYin + " " + sex + " " + college + " " + group + " " + tel + " " + duty + " " + grade + " " + motto + " " + password + " " + teachingAmount + " " + assistAmount;
    }

    public Member() {
    }
}
