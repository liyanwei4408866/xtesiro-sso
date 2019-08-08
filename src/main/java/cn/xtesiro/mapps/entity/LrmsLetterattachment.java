package cn.xtesiro.mapps.entity;

public class LrmsLetterattachment {
    private String id;

    private String attachmentName;

    private String letter_id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getAttachmentName() {
        return attachmentName;
    }

    public void setAttachmentName(String attachmentName) {
        this.attachmentName = attachmentName == null ? null : attachmentName.trim();
    }

    public String getLetter_id() {
        return letter_id;
    }

    public void setLetter_id(String letter_id) {
        this.letter_id = letter_id == null ? null : letter_id.trim();
    }
}