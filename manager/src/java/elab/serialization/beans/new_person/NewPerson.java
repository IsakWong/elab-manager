package elab.serialization.beans.new_person;

import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import org.apache.ibatis.type.Alias;

@Alias("newPerson")
public class NewPerson {

    private String number;
    private String name;
    private String sex;
    private String tel;
    private String group;
    private String specialty;
    private String birthplace;
    private String classes;
    private String duty;
    private String corporation;
    private String hobby;
    private String time;
    private String Email;
    private String experience;
    private String understanding;
    private String evaluation;
    private String oldNumber;
    private ScrollPane scrollPane;

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public String getCorporation() {
        return corporation;
    }

    public void setCorporation(String corporation) {
        this.corporation = corporation;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getUnderstanding() {
        return understanding;
    }

    public void setUnderstanding(String understanding) {
        this.understanding = understanding;
    }

    public String getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation;
    }

    public String getOldNumber() {
        return oldNumber;
    }

    public void setOldNumber(String oldNumber) {
        this.oldNumber = oldNumber;
    }

    public ScrollPane getScrollPane() { return scrollPane; }

    public void setScrollPane(ScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    @Override
    public String toString() {
        return number + " " + name + " " + sex + " " + tel + " " + group + " " + specialty + " " + birthplace + " " + classes + " " + duty  + " " + corporation + " " + hobby + " " + time + " " + Email + " " + experience + " " + understanding + " " + evaluation + " " +oldNumber + " " + scrollPane;
    }
}
