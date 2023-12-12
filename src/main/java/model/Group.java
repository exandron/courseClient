package model;

import java.io.Serializable;

public class Group extends Speciality implements Serializable {
    private int groupId;
    private int numberOfGroup;

    public Group(){
        super();
        this.groupId = -1;
        this.numberOfGroup = -1;
    }
    public Group(int groupId, int number){
        super();
        this.groupId = groupId;
        this.numberOfGroup = number;
    }

    public Group(int facultyId, String facultyName, int specialityId, String specialityName, int groupId, int number){
        super(facultyId, facultyName, specialityId, specialityName);
        this.groupId = groupId;
        this.numberOfGroup = number;
    }

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

    public int getFacultyId() {return super.getFacultyId(); }
    public void setFacultyId(int facultyId) { super.setFacultyId(facultyId); }

    public String getFacultyName() {
        return super.getFacultyName();
    }

    public void setFacultyName(String facultyName) {
        super.setFacultyName(facultyName);
    }
    public String getSpecialityName() {
        return super.getSpecialityName();
    }

    public void setSpecialityName(String specialityName) {
        super.setSpecialityName(specialityName);
    }

    public int getSpecialityId() {return super.getSpecialityId(); }
    public void setSpecialityId(int specialityId) { super.setSpecialityId(specialityId); }

}
