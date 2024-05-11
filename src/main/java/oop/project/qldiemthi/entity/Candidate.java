package oop.project.qldiemthi.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Candidate")
@XmlAccessorType(XmlAccessType.FIELD)
public class Candidate implements Serializable {
    private String name;
    private LocalDate dayOfBirth;
    private int id;
    private boolean gender;
    private String examBlock;
    private Score score;
    private String province;
    private float totalScore;

    public Candidate(String name, LocalDate dayOfBirth, int id, boolean gender, String province) {
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.id = id;
        this.gender = gender;
        this.province = province;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(LocalDate dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getExamBlock() {
        return examBlock;
    }

    public void setExamBlock(String examBlock) {
        this.examBlock = examBlock;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public void setTotalScore() {
        this.totalScore = this.score.getScore1() + this.score.getScore2() + this.score.getScore3();
    }

    public float getTotalScore() {
        return this.totalScore;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
