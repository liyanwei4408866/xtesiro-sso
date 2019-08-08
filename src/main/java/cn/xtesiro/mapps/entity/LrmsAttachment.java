package cn.xtesiro.mapps.entity;

public class LrmsAttachment {
    private String id;

    private String attachmentName;

    private String artile_id;

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

    public String getArtile_id() {
        return artile_id;
    }

    public void setArtile_id(String artile_id) {
        this.artile_id = artile_id == null ? null : artile_id.trim();
    }
}