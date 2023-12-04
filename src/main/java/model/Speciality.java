package model;

import java.io.Serializable;

public class Speciality extends Faculty implements Serializable {
    int id;
    String name;

    Speciality(){
        super();
        this.id = -1;
        this.name="";
    }

    Speciality(int facultyId, String facultyName, int specialityId, String specialityName){
        super(facultyId, facultyName);
        this.id = specialityId;
        this.name= specialityName;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public int getFacultyId() {return super.getId(); }

    public void setFacultyId(int id) { super.setId(id); }
}
