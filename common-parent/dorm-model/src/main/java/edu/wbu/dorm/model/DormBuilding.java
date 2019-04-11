package edu.wbu.dorm.model;

import java.util.List;

public class DormBuilding {
    private int id;//宿舍楼唯一id
    private int type;//宿舍楼类型(1.男生宿舍2.女生宿舍3.男教职工宿舍4.女教职工宿舍)
    private int floors;//宿舍楼层数
    private String location;//宿舍楼地理位置
    private String builtuptime;//宿舍楼建立时间
    private int capacity;//宿舍楼的房间数
    private int occupy;//该宿舍楼已住人的宿舍数量

    private List<Dorm> dormList;

    public DormBuilding() {
    }

    public DormBuilding(int id, int type, int floors, String location, String builtuptime, int capacity) {
        this.id = id;
        this.type = type;
        this.floors = floors;
        this.location = location;
        this.builtuptime = builtuptime;
        this.capacity = capacity;
    }

    public int getOccupy() {
        return occupy;
    }

    public void setOccupy(int occupy) {
        this.occupy = occupy;
    }

    public List<Dorm> getDormList() {
        return dormList;
    }

    public void setDormList(List<Dorm> dormList) {
        this.dormList = dormList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBuiltuptime() {
        return builtuptime;
    }

    public void setBuiltuptime(String builtuptime) {
        this.builtuptime = builtuptime;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
