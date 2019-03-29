package edu.wbu.dorm.model;

public class Against {
    private int id;
    private int dorm_id;
    private String description;
    private String createTime;
    private String punishment;

    public Against() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDorm_id() {
        return dorm_id;
    }

    public void setDorm_id(int dorm_id) {
        this.dorm_id = dorm_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getPunishment() {
        return punishment;
    }

    public void setPunishment(String punishment) {
        this.punishment = punishment;
    }

    @Override
    public String toString() {
        return "Against{" +
                "id=" + id +
                ", dorm_id=" + dorm_id +
                ", description='" + description + '\'' +
                ", createTime='" + createTime + '\'' +
                ", punishment='" + punishment + '\'' +
                '}';
    }
}
