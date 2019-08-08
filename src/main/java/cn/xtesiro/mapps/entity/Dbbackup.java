package cn.xtesiro.mapps.entity;

public class Dbbackup {
    private String id;

    private String selectType;

    private String period;

    private String startHour;

    private String startMin;

    private String startWeekDay;

    private String startDay;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getSelectType() {
        return selectType;
    }

    public void setSelectType(String selectType) {
        this.selectType = selectType == null ? null : selectType.trim();
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period == null ? null : period.trim();
    }

    public String getStartHour() {
        return startHour;
    }

    public void setStartHour(String startHour) {
        this.startHour = startHour == null ? null : startHour.trim();
    }

    public String getStartMin() {
        return startMin;
    }

    public void setStartMin(String startMin) {
        this.startMin = startMin == null ? null : startMin.trim();
    }

    public String getStartWeekDay() {
        return startWeekDay;
    }

    public void setStartWeekDay(String startWeekDay) {
        this.startWeekDay = startWeekDay == null ? null : startWeekDay.trim();
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay == null ? null : startDay.trim();
    }
}