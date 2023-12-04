package model;

import java.io.Serializable;

public class Exam extends Result implements Serializable {
    private int id;
    private int grade;

    private static final long serialVersionUID = -2801496011985171453L;

    //int resultId;
    private String subject;

    private String teacher;

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
