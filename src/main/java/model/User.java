package model;

import java.io.Serializable;

public class User implements Serializable{
    private static final long serialVersionUID = -2401496011985171453L;
    private int id;
    private String login;
    private String password;
    private String role;
    //private String work_phone;

    public User(){
        super();
        this.id = -1;
        this.login = "";
        this.password = "";
        this.role = "";
        //this.work_phone = "";
    }

    public User(int user_id, String login, String password, String role){
        this.id = user_id;
        this.login = login;
        this.password = password;
        this.role = role;
        //if(work_phone == null) work_phone = "";
       // this.work_phone = work_phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

//    public String getWork_phone() {
//        return work_phone;
//    }
//
//    public void setWork_phone(String work_phone) {
//        this.work_phone = work_phone;
//    }
}
