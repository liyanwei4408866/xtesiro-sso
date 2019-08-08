package cn.xtesiro.mapps.entity;

public class LrmsResearvationinstrument {
    private String id;

    private String researvation_id;

    private String instrument_id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getResearvation_id() {
        return researvation_id;
    }

    public void setResearvation_id(String researvation_id) {
        this.researvation_id = researvation_id == null ? null : researvation_id.trim();
    }

    public String getInstrument_id() {
        return instrument_id;
    }

    public void setInstrument_id(String instrument_id) {
        this.instrument_id = instrument_id == null ? null : instrument_id.trim();
    }
}