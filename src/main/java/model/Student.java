package model;

import java.io.Serializable;

public class Student extends User implements Serializable {
    private static final long serialVersionUID = -2501496011985171453L;
    private int id;
    private String surname;
    private String name;
    private String patronymic;
    private String phone_number;
    private String DOB;
    private int formOfEducation;
    private String address;

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String  getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public int getFormOfEducation() {
        return formOfEducation;
    }

    public void setFormOfEducation(int formOfEducation) {
        this.formOfEducation = formOfEducation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Student() {
        this.id = -1;
        this.name = "";
        this.surname = "";
        this.patronymic = "";
        this.phone_number = "";
        this.DOB = "";
        this.formOfEducation = -1;
        this.address = "";
    }
    public Student(int id,  String name,String surname, String patronymic, String phone_number, String DOB, int formOfEducation, String address) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.phone_number = phone_number;
        this.DOB = DOB;
        this.formOfEducation = formOfEducation;
        this.address = address;
    }

    public Student(int user_id, String login, String password, String role,
                 String name, String surname, String patronymic, String phone_number, String DOB, int formOfEducation, String address,
                 int student_id){
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
        setPhone_number(phone_number);
        if(DOB == null) DOB="";
        setDOB(DOB);
        if(formOfEducation == -1) formOfEducation=-1;
        setFormOfEducation(formOfEducation);
        if(address == null) address="";
        setAddress(address);
        this.id = student_id;
    }


    public Student (Student student) {
        this.id = student.getId();
        setUserId(student.getUserId());
        setLogin(student.getLogin());
        setPassword(student.getPassword());
        setRole(student.getRole());
        setSurname(student.getSurname());
        setName(student.getName());
        setPatronymic(student.getPatronymic());
        setPhone_number(student.getPhone_number());
        setDOB(student.getDOB());
        setFormOfEducation(student.getFormOfEducation());
        setAddress(student.getAddress());
    }

    public Student(int id, int user_id) {
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
