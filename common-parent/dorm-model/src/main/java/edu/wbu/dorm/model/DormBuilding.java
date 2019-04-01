package edu.wbu.dorm.model;

public class DormBuilding {
    private int id;//宿舍楼唯一id
    private int type;//宿舍楼类型(1.男生宿舍2.女生宿舍3.教职工宿舍)
    private int floors;//宿舍楼层数
    private String location;//宿舍楼地理位置
    private String builtuptime;//宿舍楼建立时间
    private int capacity;//宿舍楼的房间数

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

    @Override
    public String toString() {
        return "DormBuilding{" +
                "id=" + id +
                ", type=" + type +
                ", floors=" + floors +
                ", location='" + location + '\'' +
                ", builtuptime='" + builtuptime + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
