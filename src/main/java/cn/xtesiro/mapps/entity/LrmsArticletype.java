package cn.xtesiro.mapps.entity;

public class LrmsArticletype {
    private String id;

    private String descn;

    private String typeName;

    private Byte isLogin;

    private Byte isEnable;

    private Byte ord;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getDescn() {
        return descn;
    }

    public void setDescn(String descn) {
        this.descn = descn == null ? null : descn.trim();
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    public Byte getIsLogin() {
        return isLogin;
    }

    public void setIsLogin(Byte isLogin) {
        this.isLogin = isLogin;
    }

    public Byte getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Byte isEnable) {
        this.isEnable = isEnable;
    }

    public Byte getOrd() {
        return ord;
    }

    public void setOrd(Byte ord) {
        this.ord = ord;
    }
}