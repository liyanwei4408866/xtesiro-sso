package cn.xtesiro.mapps.entity;

public class LrmsMessageWithBLOBs extends LrmsMessage {
    private String content;

    private String reply;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply == null ? null : reply.trim();
    }
}