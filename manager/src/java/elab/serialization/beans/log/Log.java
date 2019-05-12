package elab.serialization.beans.log;

import org.apache.ibatis.type.Alias;

@Alias("log")
public class Log {

    private String ID;
    private String operatingNumber;
    private String time;
    private String IP;
    private String operatedNumber;
    private String hardScore;
    private String softScore;
    private String paperScore;
    private String information;
    private String version;
    private String term;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getOperatingNumber() {
        return operatingNumber;
    }

    public void setOperatingNumber(String operatingNumber) {
        this.operatingNumber = operatingNumber;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public String getOperatedNumber() {
        return operatedNumber;
    }

    public void setOperatedNumber(String operatedNumber) {
        this.operatedNumber = operatedNumber;
    }

    public String getHardScore() {
        return hardScore;
    }

    public void setHardScore(String hardScore) {
        this.hardScore = hardScore;
    }

    public String getSoftScore() {
        return softScore;
    }

    public void setSoftScore(String softScore) {
        this.softScore = softScore;
    }

    public String getPaperScore() {
        return paperScore;
    }

    public void setPaperScore(String paperScore) {
        this.paperScore = paperScore;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    @Override
    public String toString() {
        return ID + " " + operatingNumber + " " + time + " " + IP + " " + operatedNumber + " " + hardScore + " " + softScore + " " + paperScore + " " + information + " " + version + " " + term;
    }
}
