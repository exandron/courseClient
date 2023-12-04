package model;

import java.io.Serializable;

public class SubjectTeacher implements Serializable {
    private int id;
    private int teacherId;

    private int subjectId;

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public SubjectTeacher() {
        this.id = -1;
        this.subjectId = -1;
        this.teacherId = -1;
    }

    public SubjectTeacher(int id, int teacherId, int subjectId) {
        this.id = id;
        this.teacherId = teacherId;
        this.subjectId = subjectId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
