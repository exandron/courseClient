package model;

import java.io.Serializable;

public class User extends Person implements Serializable {
    private static final long serialVersionUID = -2401496011985171453L;
    private int id;
    private String login;
    private String password;
    private String role;


    public User(){
        super();
        this.id = -1;
        this.login = "";
        this.password = "";
        this.role = "";
    }

    public User(int person_id, String surname, String name, String patronymic, String phone, String email, int user_id, String login, String password, String role){
        super(person_id, surname, name, patronymic, phone, email);
        this.id = user_id;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public int getPersonId() { return super.getId(); }

    public void setPersonId(int id) { super.setId(id);}

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

}
