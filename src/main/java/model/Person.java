package model;

import java.io.Serializable;

public class Person implements Serializable{
    private int id;
    private String surname;
    private String name;
    private String patronymic;
    private String phone;
    private String email;

    public Person() {
        this.id = -1;
        this.name = "";
        this.surname = "";
        this.patronymic = "";
        this.phone = "";
        this.email = "";
    }

    public Person(int id, String surname, String name, String patronymic, String phone, String email) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.phone = phone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setPatronymic(String lastname) {
        this.patronymic = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

