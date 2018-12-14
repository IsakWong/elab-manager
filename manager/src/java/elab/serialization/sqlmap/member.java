package elab.serialization.sqlmap;

public class member {
    private int number;
    private String username;
    private String name;
    private String sex;
    private String college;
    private String group;
    private String tel;
    private String duty;
    private String grade;
    private String motto;
    private String password;
    private int teachingAmount;
    private int assistTeachingAmount;
    private String freeTimeRemark;

    public int getId() {
        return number;
    }

    public void setId(int number) {
        this.number = number;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getAssistTeachingAmount() {
        return assistTeachingAmount;
    }

    public void setAssistTeachingAmount(int assistTeachingAmount) {
        this.assistTeachingAmount = assistTeachingAmount;
    }

    public String getFreeTimeRemark() {
        return freeTimeRemark;
    }

    public void setFreeTimeRemark(String freeTimeRemark) {
        this.freeTimeRemark = freeTimeRemark;
    }

    @Override
    public String toString() {
        return number + " " + username + " " + name + " " + sex + " " + college + " " + group + " " + tel + " " + duty + " " + grade + " " + motto + " " + password + " " + teachingAmount + " " + assistTeachingAmount + " " + freeTimeRemark;
    }
}
