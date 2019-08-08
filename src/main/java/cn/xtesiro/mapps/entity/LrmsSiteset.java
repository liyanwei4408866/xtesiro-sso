package cn.xtesiro.mapps.entity;

public class LrmsSiteset {
    private String id;

    private String banner;

    private Integer memberReview;

    private Integer openRegistration;

    private String siteTitle;

    private String styleTheme;

    private Integer exam;

    private Integer passRate;

    private String copyrightInfo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner == null ? null : banner.trim();
    }

    public Integer getMemberReview() {
        return memberReview;
    }

    public void setMemberReview(Integer memberReview) {
        this.memberReview = memberReview;
    }

    public Integer getOpenRegistration() {
        return openRegistration;
    }

    public void setOpenRegistration(Integer openRegistration) {
        this.openRegistration = openRegistration;
    }

    public String getSiteTitle() {
        return siteTitle;
    }

    public void setSiteTitle(String siteTitle) {
        this.siteTitle = siteTitle == null ? null : siteTitle.trim();
    }

    public String getStyleTheme() {
        return styleTheme;
    }

    public void setStyleTheme(String styleTheme) {
        this.styleTheme = styleTheme == null ? null : styleTheme.trim();
    }

    public Integer getExam() {
        return exam;
    }

    public void setExam(Integer exam) {
        this.exam = exam;
    }

    public Integer getPassRate() {
        return passRate;
    }

    public void setPassRate(Integer passRate) {
        this.passRate = passRate;
    }

    public String getCopyrightInfo() {
        return copyrightInfo;
    }

    public void setCopyrightInfo(String copyrightInfo) {
        this.copyrightInfo = copyrightInfo == null ? null : copyrightInfo.trim();
    }
}