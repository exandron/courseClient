package model;

import java.io.Serializable;

public class Subject implements Serializable {
    private int subjectId;
    private String subjectName;

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Subject() {
        this.subjectId = -1;
        this.subjectName = "";
    }

    public Subject(int subjectId, String subjectName) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
    }
}
