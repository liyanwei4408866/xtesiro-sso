package cn.xtesiro.mapps.entity;

public class LrmsLab {
    private String id;

    private String labName;

    private String location;

    private String member_id;

    private Integer isDelete;

    private String ctrl_id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getLabName() {
        return labName;
    }

    public void setLabName(String labName) {
        this.labName = labName == null ? null : labName.trim();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id == null ? null : member_id.trim();
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getCtrl_id() {
        return ctrl_id;
    }

    public void setCtrl_id(String ctrl_id) {
        this.ctrl_id = ctrl_id == null ? null : ctrl_id.trim();
    }
}