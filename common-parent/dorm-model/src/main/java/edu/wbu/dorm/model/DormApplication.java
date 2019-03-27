package edu.wbu.dorm.model;

public class DormApplication {
    private int id;
    private String pid;//申请人学号/工号
    private String reason;
    private int to_db_id;
    private int to_dorm_id;
    private int status;//受理状态

    public DormApplication() {
    }

    public DormApplication(int id, String pid, String reason, int to_db_id, int to_dorm_id, int status) {
        this.id = id;
        this.pid = pid;
        this.reason = reason;
        this.to_db_id = to_db_id;
        this.to_dorm_id = to_dorm_id;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getTo_db_id() {
        return to_db_id;
    }

    public void setTo_db_id(int to_db_id) {
        this.to_db_id = to_db_id;
    }

    public int getTo_dorm_id() {
        return to_dorm_id;
    }

    public void setTo_dorm_id(int to_dorm_id) {
        this.to_dorm_id = to_dorm_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "DormApplication{" +
                "id=" + id +
                ", pid='" + pid + '\'' +
                ", reason='" + reason + '\'' +
                ", to_db_id=" + to_db_id +
                ", to_dorm_id=" + to_dorm_id +
                ", status=" + status +
                '}';
    }
}
