package edu.wbu.dorm.model;

public class RepairExt {
    private int id;
    private int dorm_id;
    private String content;//报修内容
    private int status;//报修申请受理状态
    private String createTime;//报修申请时间
    private String comments;//报修完成后报修人对此次报修的评价
    private Dorm dorm;

    public RepairExt() {
    }

    public RepairExt(int dorm_id, String content) {
        this.dorm_id = dorm_id;
        this.content = content;
    }

    public Dorm getDorm() {
        return dorm;
    }

    public void setDorm(Dorm dorm) {
        this.dorm = dorm;
    }

    public int getDorm_id() {
        return dorm_id;
    }

    public void setDorm_id(int dorm_id) {
        this.dorm_id = dorm_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "RepairExt{" +
                "id=" + id +
                ", dorm_id=" + dorm_id +
                ", content='" + content + '\'' +
                ", status=" + status +
                ", createTime='" + createTime + '\'' +
                ", comments='" + comments + '\'' +
                ", dorm=" + dorm +
                '}';
    }
}
