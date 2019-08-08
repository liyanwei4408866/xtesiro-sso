package cn.xtesiro.mapps.entity;

public class Enterguarddevice {
    private String id;

    private String labid;

    private String devicesn;

    private Byte devicetype;

    private Byte deviceprotocol;

    private Byte commport;

    private String ip;

    private Short port;

    private Short doorNo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getLabid() {
        return labid;
    }

    public void setLabid(String labid) {
        this.labid = labid == null ? null : labid.trim();
    }

    public String getDevicesn() {
        return devicesn;
    }

    public void setDevicesn(String devicesn) {
        this.devicesn = devicesn == null ? null : devicesn.trim();
    }

    public Byte getDevicetype() {
        return devicetype;
    }

    public void setDevicetype(Byte devicetype) {
        this.devicetype = devicetype;
    }

    public Byte getDeviceprotocol() {
        return deviceprotocol;
    }

    public void setDeviceprotocol(Byte deviceprotocol) {
        this.deviceprotocol = deviceprotocol;
    }

    public Byte getCommport() {
        return commport;
    }

    public void setCommport(Byte commport) {
        this.commport = commport;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public Short getPort() {
        return port;
    }

    public void setPort(Short port) {
        this.port = port;
    }

    public Short getDoorNo() {
        return doorNo;
    }

    public void setDoorNo(Short doorNo) {
        this.doorNo = doorNo;
    }
}