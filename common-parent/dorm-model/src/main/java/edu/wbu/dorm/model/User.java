package edu.wbu.dorm.model;

public class User {
    private String id;
    private String name;
    private String gender;
    private int age;
    private String institute;//所属学院
    private String dept;//专业名称
    private int dorm_id;//对应dorm表主键
    private String password;
    private int role;//角色(0学生1教职工)
    private String email;
    private String homeAddress;
    private String entrancetime;//入校时间
    private String headpic;
    private String aboutMe;
    private int permission;

    public User() {
    }

    public User(String id, int role, int permission) {
        this.id = id;
        this.role = role;
        this.permission = permission;
    }

    public User(String gender, int role) {
        this.gender = gender;
        this.role = role;
    }

    public int getPermission() {
        return permission;
    }

    public void setPermission(int permission) {
        this.permission = permission;
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

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getEntrancetime() {
        return entrancetime;
    }

    public void setEntrancetime(String entrancetime) {
        this.entrancetime = entrancetime;
    }

    public String getHeadpic() {
        return headpic;
    }

    public void setHeadpic(String headpic) {
        this.headpic = headpic;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", institute='" + institute + '\'' +
                ", dept='" + dept + '\'' +
                ", dorm_id=" + dorm_id +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", email='" + email + '\'' +
                ", homeAddress='" + homeAddress + '\'' +
                ", entrancetime='" + entrancetime + '\'' +
                ", headpic='" + headpic + '\'' +
                ", aboutMe='" + aboutMe + '\'' +
                ", permission=" + permission +
                '}';
    }
}
