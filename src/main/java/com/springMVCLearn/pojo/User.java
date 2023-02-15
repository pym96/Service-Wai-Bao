package com.springMVCLearn.pojo;

/**
 * @author DJS
 * Date create 12:38 2023/2/7
 * Modified By DJS
 **/
public class User {
    private String username;
    private String password;
    private String addr;
    private String gender;
    private Integer id;

    public String getPassword() {
        return password;
    }

    public void setPsd(String psd) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", addr='" + addr + '\'' +
                ", gender='" + gender + '\'' +
                ", id=" + id +
                '}';
    }
}
