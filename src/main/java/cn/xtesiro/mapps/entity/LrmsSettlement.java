package cn.xtesiro.mapps.entity;

import java.util.Date;

public class LrmsSettlement {
    private String id;

    private Double settlementMoney;

    private Date settlementTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Double getSettlementMoney() {
        return settlementMoney;
    }

    public void setSettlementMoney(Double settlementMoney) {
        this.settlementMoney = settlementMoney;
    }

    public Date getSettlementTime() {
        return settlementTime;
    }

    public void setSettlementTime(Date settlementTime) {
        this.settlementTime = settlementTime;
    }
}