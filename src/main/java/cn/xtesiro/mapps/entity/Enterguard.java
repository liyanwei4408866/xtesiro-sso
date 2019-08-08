package cn.xtesiro.mapps.entity;

import java.util.Date;

public class Enterguard {
    private String id;

    private String memberid;

    private String labid;

    private Date startTime;

    private Date endTime;

    private Date lagtime;

    private Date leadtime;

    private Byte isWritten;

    private Byte isFlag;

    private Byte isForcedOn;

    private String reservationid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getMemberid() {
        return memberid;
    }

    public void setMemberid(String memberid) {
        this.memberid = memberid == null ? null : memberid.trim();
    }

    public String getLabid() {
        return labid;
    }

    public void setLabid(String labid) {
        this.labid = labid == null ? null : labid.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getLagtime() {
        return lagtime;
    }

    public void setLagtime(Date lagtime) {
        this.lagtime = lagtime;
    }

    public Date getLeadtime() {
        return leadtime;
    }

    public void setLeadtime(Date leadtime) {
        this.leadtime = leadtime;
    }

    public Byte getIsWritten() {
        return isWritten;
    }

    public void setIsWritten(Byte isWritten) {
        this.isWritten = isWritten;
    }

    public Byte getIsFlag() {
        return isFlag;
    }

    public void setIsFlag(Byte isFlag) {
        this.isFlag = isFlag;
    }

    public Byte getIsForcedOn() {
        return isForcedOn;
    }

    public void setIsForcedOn(Byte isForcedOn) {
        this.isForcedOn = isForcedOn;
    }

    public String getReservationid() {
        return reservationid;
    }

    public void setReservationid(String reservationid) {
        this.reservationid = reservationid == null ? null : reservationid.trim();
    }
}