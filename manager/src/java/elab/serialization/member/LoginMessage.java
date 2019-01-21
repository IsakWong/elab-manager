package elab.serialization.member;

import org.apache.ibatis.type.Alias;

@Alias("loginMessage")
public class LoginMessage {

    private static int oldNumber;
    private static int number;
    private static String userName;
    private static String name;
    private static String sex;
    private static String college;
    private static String group;
    private static String tel;
    private static String duty;
    private static String grade;
    private static String motto;
    private static String password;

    public int getOldNumber() {
        return oldNumber;
    }

    public void setOldNumber(int oldNumber) {
        LoginMessage.oldNumber = oldNumber;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        LoginMessage.number = number;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String username) {
        LoginMessage.userName = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        LoginMessage.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        LoginMessage.sex = sex;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        LoginMessage.college = college;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        LoginMessage.group = group;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        LoginMessage.tel = tel;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        LoginMessage.duty = duty;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        LoginMessage.grade = grade;
    }

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        LoginMessage.motto = motto;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        LoginMessage.password = password;
    }

    @Override
    public String toString() {
        return number + " " + userName + " " + name + " " + sex + " " + college + " " + group + " " + tel + " " + duty + " " + grade + " " + motto + " " + password;
    }
}
