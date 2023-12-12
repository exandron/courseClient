package model;

import java.io.Serializable;

public class Test extends Result implements Serializable {
    int id;
    String isPassed;

    private String subject;

    private String teacher;
    private int subjectTeacherId;

    public Test() {
        super();
        this.id = -1;
        this.isPassed = "";
        this.subject = "";
        this.teacher = "";
    }

    public Test(int resultId, String date, int semester, int studentId, int subjectTeacherId, String subject, String teacher, int id, String isPassed) {
        super(resultId, date, semester, studentId, subjectTeacherId);
        this.subject = subject;
        this.teacher = teacher;
        this.id = id;
        this.isPassed = isPassed;
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
    public int getStudentId() {
        return super.getStudentId();
    }
    @Override
    public void setStudentId(int studentId) {
        super.setStudentId(studentId);
    }
    @Override
    public int getSemester() {
        return super.getSemester();
    }
    @Override
    public void setSemester(int semester) {
        super.setSemester(semester);
    }
    @Override
    public String getDate() {
        return super.getDate();
    }
    @Override
    public void setDate(String DOB) {
        super.setDate(DOB);
    }

    @Override
    public int getSubjectTeacherId() {
        return subjectTeacherId;
    }

    @Override
    public void setSubjectTeacherId(int subjectTeacherId) {
        this.subjectTeacherId = subjectTeacherId;
    }


    public String isPassed() {
        return isPassed;
    }

    public void setPassed(String passed) {
        isPassed = passed;
    }
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }
}
