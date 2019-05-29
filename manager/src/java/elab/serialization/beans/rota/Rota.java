package elab.serialization.beans.rota;

import org.apache.ibatis.type.Alias;

@Alias("rota")
public class Rota {

    private String number;
    private String name;
    private String group;
    private String time;
    private String week;
    private String day;

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

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return number + "" + name + "" + group + "" + time + "" + week + "" + day;
    }

    public Rota(String number, String name, String group, String time, String week, String day){
        this.number = number;
        this.name = name;
        this.group = group;
        this.time = time;
        this.week = week;
        this.day = day;
    }

    public Rota() {
    }
}
