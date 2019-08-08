package cn.xtesiro.mapps.entity;

public class LrmsScoresetting {
    private String id;

    private Double score;

    private String changePointRule;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getChangePointRule() {
        return changePointRule;
    }

    public void setChangePointRule(String changePointRule) {
        this.changePointRule = changePointRule == null ? null : changePointRule.trim();
    }
}