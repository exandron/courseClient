package model;

import java.io.Serializable;

public class Result implements Serializable {
    private int id;

    private static final long serialVersionUID = -2701496011985171453L;
    private String date;
    private int semester;
    private int studentId;
    private int subjectTeacherId;

    public Result() {
        this.id = -1;
        this.date = "";
        this.semester = -1;
        this.studentId = -1;
        this.subjectTeacherId = -1;
    }

    public Result(int semester) {
        this.id = -1;
        this.date = "";
        this.semester = semester;
        this.studentId = -1;
        this.subjectTeacherId = -1;
    }

    public Result(int id, String date, int semester, int studentId, int subjectTeacherId) {
        this.id = id;
        this.date = date;
        this.semester = semester;
        this.studentId = studentId;
        this.subjectTeacherId = subjectTeacherId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String DOB) {
        this.date = date;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getSubjectTeacherId() {
        return subjectTeacherId;
    }

    public void setSubjectTeacherId(int subjectTeacherId) {
        this.subjectTeacherId = subjectTeacherId;
    }
}
