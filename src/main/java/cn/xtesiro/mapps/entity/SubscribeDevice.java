package cn.xtesiro.mapps.entity;

public class SubscribeDevice {
    private String id;

    private String subscribe_id;

    private String device_id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getSubscribe_id() {
        return subscribe_id;
    }

    public void setSubscribe_id(String subscribe_id) {
        this.subscribe_id = subscribe_id == null ? null : subscribe_id.trim();
    }

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id == null ? null : device_id.trim();
    }
}