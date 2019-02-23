package elab.serialization.beans.school_opening_information;

import org.apache.ibatis.type.Alias;

@Alias("schoolOpen")
public class SchoolOpeningInformation {

    private String schoolOpeningDate;
    private String term;
    private String hardTheory;
    private String softTheory;
    private String maintenanceTheory;
    private String hardWeeks;
    private String softWeeks;
    private String maintenanceWeeks;
    private String closeChooseClasses;
    private String onDutyForm;
    private String classCapacity;

    public String getSchoolOpeningDate() {
        return schoolOpeningDate;
    }

    public void setSchoolOpeningDate(String schoolOpeningDate) {
        this.schoolOpeningDate = schoolOpeningDate;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getHardTheory() {
        return hardTheory;
    }

    public void setHardTheory(String hardTheory) {
        this.hardTheory = hardTheory;
    }

    public String getSoftTheory() {
        return softTheory;
    }

    public void setSoftTheory(String softTheory) {
        this.softTheory = softTheory;
    }

    public String getMaintenanceTheory() {
        return maintenanceTheory;
    }

    public void setMaintenanceTheory(String maintenanceTheory) {
        this.maintenanceTheory = maintenanceTheory;
    }

    public String getHardWeeks() {
        return hardWeeks;
    }

    public void setHardWeeks(String hardWeeks) {
        this.hardWeeks = hardWeeks;
    }

    public String getSoftWeeks() {
        return softWeeks;
    }

    public void setSoftWeeks(String softWeeks) {
        this.softWeeks = softWeeks;
    }

    public String getMaintenanceWeeks() {
        return maintenanceWeeks;
    }

    public void setMaintenanceWeeks(String maintenanceWeeks) {
        this.maintenanceWeeks = maintenanceWeeks;
    }

    public String getCloseChooseClasses() {
        return closeChooseClasses;
    }

    public void setCloseChooseClasses(String closeChooseClasses) {
        this.closeChooseClasses = closeChooseClasses;
    }

    public String getOnDutyForm() {
        return onDutyForm;
    }

    public void setOnDutyForm(String onDutyForm) {
        this.onDutyForm = onDutyForm;
    }

    public String getClassCapacity() {
        return classCapacity;
    }

    public void setClassCapacity(String classCapacity) {
        this.classCapacity = classCapacity;
    }

    @Override
    public String toString() {
        return schoolOpeningDate + " " + term + " " + hardTheory + " " + softTheory + " " + maintenanceTheory + " " + hardWeeks + " " + softWeeks + " " + maintenanceWeeks + " " + closeChooseClasses + " " + onDutyForm + " " + classCapacity;
    }
}
