package cn.xtesiro.mapps.entity;

public class LrmsInstrumentreservationWithBLOBs extends LrmsInstrumentreservation {
    private String failureReason;

    private String modifyTimeReason;

    private String notes;

    private String subjectContent;

    private String subjectDescription;

    public String getFailureReason() {
        return failureReason;
    }

    public void setFailureReason(String failureReason) {
        this.failureReason = failureReason == null ? null : failureReason.trim();
    }

    public String getModifyTimeReason() {
        return modifyTimeReason;
    }

    public void setModifyTimeReason(String modifyTimeReason) {
        this.modifyTimeReason = modifyTimeReason == null ? null : modifyTimeReason.trim();
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes == null ? null : notes.trim();
    }

    public String getSubjectContent() {
        return subjectContent;
    }

    public void setSubjectContent(String subjectContent) {
        this.subjectContent = subjectContent == null ? null : subjectContent.trim();
    }

    public String getSubjectDescription() {
        return subjectDescription;
    }

    public void setSubjectDescription(String subjectDescription) {
        this.subjectDescription = subjectDescription == null ? null : subjectDescription.trim();
    }
}