package cn.xtesiro.mapps.entity;

public class LrmsDeviceRole {
    private String device_id;

    private String role_id;

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id == null ? null : device_id.trim();
    }

    public String getRole_id() {
        return role_id;
    }

    public void setRole_id(String role_id) {
        this.role_id = role_id == null ? null : role_id.trim();
    }
}