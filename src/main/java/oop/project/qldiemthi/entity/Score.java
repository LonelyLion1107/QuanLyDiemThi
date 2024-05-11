package oop.project.qldiemthi.entity;

public class Score {
    private String subject1;
    private float score1;
    private String subject2;
    private float score2;
    private String subject3;
    private float score3;

    public Score(String subject1, float score1, String subject2, float score2, String subject3, float score3) {
        this.subject1 = subject1;
        this.score1 = score1;
        this.subject2 = subject2;
        this.score2 = score2;
        this.subject3 = subject3;
        this.score3 = score3;
    }

    public String getSubject1() {
        return subject1;
    }

    public void setSubject1(String subject1) {
        this.subject1 = subject1;
    }

    public float getScore1() {
        return score1;
    }

    public void setScore1(float score1) {
        this.score1 = score1;
    }

    public String getSubject2() {
        return subject2;
    }

    public void setSubject2(String subject2) {
        this.subject2 = subject2;
    }

    public float getScore2() {
        return score2;
    }

    public void setScore2(float score2) {
        this.score2 = score2;
    }

    public String getSubject3() {
        return subject3;
    }

    public void setSubject3(String subject3) {
        this.subject3 = subject3;
    }

    public float getScore3() {
        return score3;
    }

    public void setScore3(float score3) {
        this.score3 = score3;
    }
}
