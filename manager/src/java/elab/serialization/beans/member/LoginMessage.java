package elab.serialization.beans.member;

import org.apache.ibatis.type.Alias;

import java.beans.Transient;

@Alias("loginMessage")
public class LoginMessage {

    private int oldNumber;
    private int number;
    private byte[] photo;
    private String photoFormat;
    private String userName;
    private String name;
    private String sex;
    private String college;
    private String group;
    private String tel;
    private String duty;
    private String grade;
    private String motto;
    private String password;

    private transient boolean isValid = false;

    public void setValid(boolean value){
        isValid = value;
    }

    public boolean isValid() {
        return isValid;
    }

    public int getOldNumber() {
        return oldNumber;
    }

    public void setOldNumber(int value) {
        oldNumber = value;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int value) {
        number = value;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String value) {
        userName = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        name = value;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String value) {
        sex = value;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String value) {
        college = value;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String value) {
        group = value;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String value) {
        tel = value;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String value) {
        duty = value;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String value) {
        grade = value;
    }

    public String getMotto() {
        return motto;
    }

    public void setMotto(String value) {
        motto = value;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String value) {
        password = value;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] value) {
        photo = value;
    }

    public String getPhotoFormat() {
        return photoFormat;
    }

    public void setPhotoFormat(String value) {
        photoFormat = value;
    }

    @Override
    public String toString() {
        return number + " " + userName + " " + name + " " + sex + " " + college + " " + group + " " + tel + " " + duty + " " + grade + " " + motto + " " + password ;
    }
}
