package elab.serialization.beans.free_time;

import org.apache.ibatis.type.Alias;

@Alias("freeTime")
public class FreeTime {

    private int number;
    private String name;
    private String freeTime;
    private String term;
    private String remarks;
    private String modificationDate;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFreeTime() {
        return freeTime;
    }

    public void setFreeTime(String freeTime) {
        this.freeTime = freeTime;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(String modificationDate) {
        this.modificationDate = modificationDate;
    }

    @Override
    public String toString() {
        return number + " " + name + " " + freeTime + " " + term + " " + remarks + " " + modificationDate;
    }
}
