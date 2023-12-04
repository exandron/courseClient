package model;

import java.io.Serializable;

public class Test extends Result implements Serializable {
    int id;
    boolean isPassed;

    private String subject;

    private String teacher;

    public Test() {
        super();
        this.id = -1;
        this.isPassed = false;
        this.subject = "";
        this.teacher = "";
    }

    public Test(int resultId, String date, int semester, int studentId, int subjectTeacherId, String subject, String teacher, int id, boolean isPassed) {
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

    public boolean isPassed() {
        return isPassed;
    }

    public void setPassed(boolean passed) {
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
