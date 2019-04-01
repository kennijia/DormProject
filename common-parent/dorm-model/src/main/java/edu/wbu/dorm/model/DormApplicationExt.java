package edu.wbu.dorm.model;

public class DormApplicationExt {
    private int id;
    private String pid;//申请人学号/工号
    private String reason;
    private int to_db_id;
    private int to_dorm_number;
    private int status;//受理状态(0未处理1驳回2同意)
    private String time;
    private String username;

    public DormApplicationExt() {
    }

    public DormApplicationExt(String pid, String reason, int to_db_id, int to_dorm_number) {
        this.pid = pid;
        this.reason = reason;
        this.to_db_id = to_db_id;
        this.to_dorm_number = to_dorm_number;
    }

    public DormApplicationExt(int id, int status) {
        this.id = id;
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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

    public int getTo_dorm_number() {
        return to_dorm_number;
    }

    public void setTo_dorm_number(int to_dorm_number) {
        this.to_dorm_number = to_dorm_number;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "DormApplicationExt{" +
                "id=" + id +
                ", pid='" + pid + '\'' +
                ", reason='" + reason + '\'' +
                ", to_db_id=" + to_db_id +
                ", to_dorm_number=" + to_dorm_number +
                ", status=" + status +
                ", time='" + time + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
