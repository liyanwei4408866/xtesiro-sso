package cn.xtesiro.mapps.entity;

public class LrmsInstrumentappointmentsettingWithBLOBs extends LrmsInstrumentappointmentsetting {
    private String closeReason;

    private String successInfo;

    public String getCloseReason() {
        return closeReason;
    }

    public void setCloseReason(String closeReason) {
        this.closeReason = closeReason == null ? null : closeReason.trim();
    }

    public String getSuccessInfo() {
        return successInfo;
    }

    public void setSuccessInfo(String successInfo) {
        this.successInfo = successInfo == null ? null : successInfo.trim();
    }
}