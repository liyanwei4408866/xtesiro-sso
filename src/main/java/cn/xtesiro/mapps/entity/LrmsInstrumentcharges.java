package cn.xtesiro.mapps.entity;

public class LrmsInstrumentcharges {
    private String id;

    private Double money;

    private String instrument_id;

    private String userGroup_id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getInstrument_id() {
        return instrument_id;
    }

    public void setInstrument_id(String instrument_id) {
        this.instrument_id = instrument_id == null ? null : instrument_id.trim();
    }

    public String getUserGroup_id() {
        return userGroup_id;
    }

    public void setUserGroup_id(String userGroup_id) {
        this.userGroup_id = userGroup_id == null ? null : userGroup_id.trim();
    }
}