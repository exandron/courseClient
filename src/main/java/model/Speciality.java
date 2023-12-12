package model;

import java.io.Serializable;

public class Speciality extends Faculty implements Serializable {
    private int specialityId;
    private String specialityName;

    public Speciality(){
        super();
        this.specialityId = -1;
        this.specialityName="";
    }

    public Speciality(int facultyId, String facultyName, int specialityId, String specialityName){
        super(facultyId, facultyName);
        this.specialityId = specialityId;
        this.specialityName= specialityName;
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

    public int getFacultyId() {return super.getFacultyId(); }
    public void setFacultyId(int facultyId) { super.setFacultyId(facultyId); }

    public String getFacultyName() {
        return super.getFacultyName();
    }

    public void setFacultyName(String facultyName) {
        super.setFacultyName(facultyName);
    }
}
