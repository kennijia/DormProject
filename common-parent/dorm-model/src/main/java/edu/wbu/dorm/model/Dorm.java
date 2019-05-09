package edu.wbu.dorm.model;

public class Dorm {
    private int id;//值为0时代表住在校外
    private int db_id;//宿舍楼
    private int dorm_number;//宿舍编号
    private String dorm_gender;//宿舍性别
    private int capacity;//宿舍容量
    private int occupy;//宿舍已住人数
    private int fee_id;//对应费用表的主键

    public Dorm(int db_id, int dorm_number) {
        this.db_id = db_id;
        this.dorm_number = dorm_number;
    }

    public Dorm() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDb_id() {
        return db_id;
    }

    public void setDb_id(int db_id) {
        this.db_id = db_id;
    }

    public int getDorm_number() {
        return dorm_number;
    }

    public void setDorm_number(int dorm_number) {
        this.dorm_number = dorm_number;
    }

    public String getDorm_gender() {
        return dorm_gender;
    }

    public void setDorm_gender(String dorm_gender) {
        this.dorm_gender = dorm_gender;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getOccupy() {
        return occupy;
    }

    public void setOccupy(int occupy) {
        this.occupy = occupy;
    }

    public int getFee_id() {
        return fee_id;
    }

    public void setFee_id(int fee_id) {
        this.fee_id = fee_id;
    }

    @Override
    public String toString() {
        return "Dorm{" +
                "id=" + id +
                ", db_id=" + db_id +
                ", dorm_number=" + dorm_number +
                ", dorm_gender='" + dorm_gender + '\'' +
                ", capacity=" + capacity +
                ", occupy=" + occupy +
                ", fee_id=" + fee_id +
                '}';
    }
}
