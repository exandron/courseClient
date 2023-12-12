package model;

import java.io.Serializable;

public class Exam extends Result implements Serializable {
    private int id;
    private int grade;

    private static final long serialVersionUID = -2801496011985171453L;

    private String subject;

    private String teacher;

    private int subjectTeacherId;

    public Exam() {
        super();
        this.id = -1;
        this.grade = -1;
        this.subject = "";
        this.teacher = "";
    }

    public Exam(int semester) {
        super(semester);
        this.id = -1;
        this.grade = -1;
        this.subject = "";
        this.teacher = "";
    }

    public Exam(int resultId, String date, int semester, int studentId, int subjectTeacherId, String subject, String teacher, int id, int grade) {
        super(resultId, date, semester, studentId, subjectTeacherId);
        this.subject = subject;
        this.teacher = teacher;
        this.id = id;
        this.grade = grade;
    }


    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }
    public int getStudentId() {
        return super.getStudentId();
    }

    public void setStudentId(int studentId) {
        super.setStudentId(studentId);
    }
    public int getResultId() {
        return super.getId();
    }

    public void setResultId(int id) {
        super.setId(id);
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


    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
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
