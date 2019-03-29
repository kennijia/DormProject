package edu.wbu.dorm.model;

public class Fee {
    private int id;//一个宿舍对应一个费用表id
    private Double waterFee;
    private Double electricityFee;

    public Fee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getWaterFee() {
        return waterFee;
    }

    public void setWaterFee(Double waterFee) {
        this.waterFee = waterFee;
    }

    public Double getElectricityFee() {
        return electricityFee;
    }

    public void setElectricityFee(Double electricityFee) {
        this.electricityFee = electricityFee;
    }

    @Override
    public String toString() {
        return "Fee{" +
                "id=" + id +
                ", waterFee=" + waterFee +
                ", electricityFee=" + electricityFee +
                '}';
    }
}
