package edu.wbu.dorm.model;
//宿舍卫生情况，一个宿舍每次检查都有不同的卫生情况
public class Hygiene {
    private int id;
    private int dorm_id;
    private String description;
    private String comments;//宿管会评价
    private String createTime;//该条记录写入日期

    public Hygiene() {
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

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Hygiene{" +
                "id=" + id +
                ", dorm_id=" + dorm_id +
                ", description='" + description + '\'' +
                ", comments='" + comments + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}


