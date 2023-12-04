package model;

import java.io.Serializable;

public class Teacher extends User implements Serializable {
    private int id;
    private String post;
    private String department;

    public Teacher() {
        this.id = -1;
        this.post = "";
        this.department = "";
    }

    public Teacher(int person_id, String surname, String name, String patronymic, String phone, String email, int user_id, String login, String password, String role, int id, String post, String department) {
        super(person_id, surname, name, patronymic, phone, email, user_id, login, password, role);
        this.id = id;
        this.post = post;
        this.department = department;
    }
    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {return super.getId(); }

    public void setUserId(int id) { super.setId(id); }
    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
