package cn.xtesiro.mapps.entity;

import java.util.Date;

public class LrmsLetter {
    private String id;

    private Integer referenceNum;

    private Date time;

    private String title;

    private String content;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getReferenceNum() {
        return referenceNum;
    }

    public void setReferenceNum(Integer referenceNum) {
        this.referenceNum = referenceNum;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}