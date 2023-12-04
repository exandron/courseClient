package model;

import java.io.Serializable;

public class Group extends Speciality implements Serializable {
    int id;
    int number;

    Group(){
        super();
        this.id = -1;
        this.number = -1;
    }

    Group(int facultyId, String facultyName, int specialityId, String specialityName, int groupId, int number){
        super(facultyId, facultyName, specialityId, specialityName);
        this.id = groupId;
        this.number = number;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }
    public int getSpecialityId() {return super.getId(); }

    public void setSpecialityId(int id) { super.setId(id); }
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
