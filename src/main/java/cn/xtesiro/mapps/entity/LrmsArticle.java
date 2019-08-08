package cn.xtesiro.mapps.entity;

import java.util.Date;

public class LrmsArticle {
    private String id;

    private String author;

    private Double isTop;

    private String newsTitle;

    private Date time;

    private String articleType_id;

    private Byte type;

    private String content;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public Double getIsTop() {
        return isTop;
    }

    public void setIsTop(Double isTop) {
        this.isTop = isTop;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle == null ? null : newsTitle.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getArticleType_id() {
        return articleType_id;
    }

    public void setArticleType_id(String articleType_id) {
        this.articleType_id = articleType_id == null ? null : articleType_id.trim();
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}