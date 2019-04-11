package edu.wbu.dorm.model;

public class DormExt {
    private int db_id;//宿舍楼id
    private int number;//该宿舍楼已住人的房间数量

    public DormExt() {
    }

    public int getDb_id() {
        return db_id;
    }

    public void setDb_id(int db_id) {
        this.db_id = db_id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
