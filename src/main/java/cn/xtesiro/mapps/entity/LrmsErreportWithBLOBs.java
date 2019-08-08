package cn.xtesiro.mapps.entity;

public class LrmsErreportWithBLOBs extends LrmsErreport {
    private String error;

    private String deal;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error == null ? null : error.trim();
    }

    public String getDeal() {
        return deal;
    }

    public void setDeal(String deal) {
        this.deal = deal == null ? null : deal.trim();
    }
}