package edu.wbu.dorm.model;

public class ExcellentDorm {
    private int id;
    private int dorm_id;//对应宿舍表的id
    private String imgs;//该宿舍的多张图片地址
    private String introduce;//该宿舍的介绍

    public ExcellentDorm() {
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

    public String getImgs() {
        return imgs;
    }

    public void setImgs(String imgs) {
        this.imgs = imgs;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    @Override
    public String toString() {
        return "ExcellentDorm{" +
                "id=" + id +
                ", dorm_id=" + dorm_id +
                ", imgs='" + imgs + '\'' +
                ", introduce='" + introduce + '\'' +
                '}';
    }
}
