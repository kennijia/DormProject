package edu.wbu.dorm.model;

public class DormBuilding {
    private int id;
    private int type;
    private int floors;
    private String location;
    private String builtuptime;
    private int capacity;

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
