package model;

import java.io.Serializable;

public class SubjectTeacher extends Teacher implements Serializable {
    private int subjectTeacherId;
    private int subjectId;
    private String subjectName;


    public SubjectTeacher() {
        this.subjectTeacherId = -1;
        this.subjectId = -1;
    }

    public SubjectTeacher(int id, int subjectId) {
        this.subjectTeacherId = id;
        this.subjectId = subjectId;
    }

    public SubjectTeacher(int person_id, String surname, String name, String patronymic, String phone, String email, int user_id, String login, String password, String role, int teacherId, String post, String department, int subjectId, String subjectName, int subjectTeacherId) {
        super(person_id, surname, name, patronymic, phone, email, user_id, login, password, role, teacherId, post, department);
        this.subjectTeacherId = subjectTeacherId;
        this.subjectId = subjectId;
        this.subjectName = subjectName;
    }
    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public int getSubjectTeacherId() {
        return subjectTeacherId;
    }

    public void setSubjectTeacherId(int subjectTeacherId) {
        this.subjectTeacherId = subjectTeacherId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public void setId(int teacherId) {
        super.setId(teacherId);
    }
}
