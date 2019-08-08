package cn.xtesiro.mapps.entity;

public class LrmsSendmail {
    private String id;

    private String fromId;

    private String letter_id;

    private String toNames;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getFromId() {
        return fromId;
    }

    public void setFromId(String fromId) {
        this.fromId = fromId == null ? null : fromId.trim();
    }

    public String getLetter_id() {
        return letter_id;
    }

    public void setLetter_id(String letter_id) {
        this.letter_id = letter_id == null ? null : letter_id.trim();
    }

    public String getToNames() {
        return toNames;
    }

    public void setToNames(String toNames) {
        this.toNames = toNames == null ? null : toNames.trim();
    }
}