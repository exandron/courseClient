package model;

import java.io.Serializable;

public class Admin extends User implements Serializable{
    private int id;
    private String surname;
    private String name;
    private String patronymic;
    private String phone_number;
    private String email;

    public Admin() {
        this.id = -1;
        this.name = "";
        this.surname = "";
        this.patronymic = "";
        this.phone_number = "";
        this.email = "";
    }

    public Admin(int id, String surname, String name, String patronymic, String phone_number, String email) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.phone_number = phone_number;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getPhoneNumber() {
        return phone_number;
    }

    public void setPhoneNumber(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Admin(int user_id, String login, String password, String role,
                 String name, String surname, String patronymic, String phone_number, String email,
                 int admin_id){
        setUserId(user_id);
        setLogin(login);
        setPassword(password);
        setRole(role);
        if(name == null) name="";
        setName(name);
        if(surname == null) surname="";
        setSurname(surname);
        if(patronymic == null) patronymic="";
        setPatronymic(patronymic);
        if(phone_number == null) phone_number="";
        setPhoneNumber(phone_number);
        if(email == null) email="";
        setEmail(email);
        this.id = admin_id;
    }


    public Admin(Admin admin) {
        this.id = admin.getId();
        setUserId(admin.getUserId());
        setLogin(admin.getLogin());
        setPassword(admin.getPassword());
        setRole(admin.getRole());
        setSurname(admin.getSurname());
        setName(admin.getName());
        setPatronymic(admin.getPatronymic());
        setPhoneNumber(admin.getPhoneNumber());
        setEmail(admin.getEmail());
    }

    public Admin(int id, int user_id) {
        this.id = id;
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

}
