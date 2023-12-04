package model;

import java.io.Serializable;

public class Student extends User implements Serializable {
    private static final long serialVersionUID = -2501496011985171453L;
    private int id;

    private String DOB;
    private int formOfEducation;
    private String address;
    private int numberOfGroup;

    private int groupId;

    private int facultyId;

    private String facultyName;
    private int specialityId;
    private String specialityName;

    public Student() {
        this.id = -1;
        this.DOB = "";
        this.formOfEducation = -1;
        this.address = "";
        this.groupId = -1;
        this.numberOfGroup = -1;
        this.facultyId = -1;
        this.facultyName = "";
        this.specialityId = -1;
        this.specialityName = "";
    }

    public Student(int person_id, String surname, String name, String patronymic, String phone, String email, int user_id, String login, String password, String role, int id, String DOB, int formOfEducation, String address, int groupId, int numberOfGroup, int facultyId, String facultyName, int specialityId, String specialityName) {
        super(person_id, surname, name, patronymic, phone, email, user_id, login, password, role);
        this.id = id;
        this.DOB = DOB;
        this.formOfEducation = formOfEducation;
        this.address = address;
        this.groupId = groupId;
        this.numberOfGroup = numberOfGroup;
        this.facultyId = facultyId;
        this.facultyName = facultyName;
        this.specialityId = specialityId;
        this.specialityName = specialityName;
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

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public int getUserId() {return super.getId(); }

    public void setUserId(int id) { super.setId(id); }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getNumberOfGroup() {
        return numberOfGroup;
    }

    public void setNumberOfGroup(int numberOfGroup) {
        this.numberOfGroup = numberOfGroup;
    }
    public int getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public int getSpecialityId() {
        return specialityId;
    }

    public void setSpecialityId(int specialityId) {
        this.specialityId = specialityId;
    }

    public String getSpecialityName() {
        return specialityName;
    }

    public void setSpecialityName(String specialityName) {
        this.specialityName = specialityName;
    }

}
