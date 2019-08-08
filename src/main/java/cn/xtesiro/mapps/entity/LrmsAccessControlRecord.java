package cn.xtesiro.mapps.entity;

import java.util.Date;

public class LrmsAccessControlRecord {
    private String id;

    private String sn;

    private Integer record_index;

    private Byte record_type;

    private Byte record_result;

    private Byte doorno;

    private Byte direction;

    private String cardno;

    private Date record_accesstime;

    private Byte record_errorcode;

    private String batch_id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn == null ? null : sn.trim();
    }

    public Integer getRecord_index() {
        return record_index;
    }

    public void setRecord_index(Integer record_index) {
        this.record_index = record_index;
    }

    public Byte getRecord_type() {
        return record_type;
    }

    public void setRecord_type(Byte record_type) {
        this.record_type = record_type;
    }

    public Byte getRecord_result() {
        return record_result;
    }

    public void setRecord_result(Byte record_result) {
        this.record_result = record_result;
    }

    public Byte getDoorno() {
        return doorno;
    }

    public void setDoorno(Byte doorno) {
        this.doorno = doorno;
    }

    public Byte getDirection() {
        return direction;
    }

    public void setDirection(Byte direction) {
        this.direction = direction;
    }

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno == null ? null : cardno.trim();
    }

    public Date getRecord_accesstime() {
        return record_accesstime;
    }

    public void setRecord_accesstime(Date record_accesstime) {
        this.record_accesstime = record_accesstime;
    }

    public Byte getRecord_errorcode() {
        return record_errorcode;
    }

    public void setRecord_errorcode(Byte record_errorcode) {
        this.record_errorcode = record_errorcode;
    }

    public String getBatch_id() {
        return batch_id;
    }

    public void setBatch_id(String batch_id) {
        this.batch_id = batch_id == null ? null : batch_id.trim();
    }
}