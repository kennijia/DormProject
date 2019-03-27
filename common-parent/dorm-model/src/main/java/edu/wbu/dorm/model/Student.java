package edu.wbu.dorm.model;

import java.util.Date;

public class Student {
    private String id;
    private String name;
    private String gender;
    private int age;
    private String dept;
    private int dorm_id;//对应dorm表主键
    private String  classname;
    private String password;
    private int power;
    private String email;
    private String homeAddress;
    private String entrancetime;
    private String headpic;
    private String aboutMe;

    public Student() {
    }

    public Student(String id, String name, String gender, int age, String dept, int dorm_id, String classname, String password, int power, String email, String homeAddress, String entrancetime, String headpic, String aboutMe) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.dept = dept;
        this.dorm_id = dorm_id;
        this.classname = classname;
        this.password = password;
        this.power = power;
        this.email = email;
        this.homeAddress = homeAddress;
        this.entrancetime = entrancetime;
        this.headpic = headpic;
        this.aboutMe = aboutMe;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public String getHeadpic() {
        return headpic;
    }

    public void setHeadpic(String headpic) {
        this.headpic = headpic;
    }

    public String getEntrancetime() {
        return entrancetime;
    }

    public void setEntrancetime(String entrancetime) {
        this.entrancetime = entrancetime;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public int getDorm_id() {
        return dorm_id;
    }

    public void setDorm_id(int dorm_id) {
        this.dorm_id = dorm_id;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", dept='" + dept + '\'' +
                ", dorm_id=" + dorm_id +
                ", classname='" + classname + '\'' +
                ", password='" + password + '\'' +
                ", power=" + power +
                ", email='" + email + '\'' +
                ", homeAddress='" + homeAddress + '\'' +
                ", entrancetime='" + entrancetime + '\'' +
                ", headpic='" + headpic + '\'' +
                ", aboutMe='" + aboutMe + '\'' +
                '}';
    }
}
