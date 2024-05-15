package oop.project.qldiemthi;

import java.io.Serializable;
import java.time.LocalDate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Candidate")
@XmlAccessorType(XmlAccessType.FIELD)
public class Candidate implements Serializable {
    private String name;
    private String dateOfBirth;
    private int sbd;
    private String gender;
    private String province;
    private String examBlock;
    private float score1;
    private float score2;
    private float score3;
    private float totalScore;

    public Candidate(String name, String dateOfBirth, int sbd, String gender, String province) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.sbd = sbd;
        this.gender = gender;
        this.province = province;
    }

    public Candidate() {
        this.name = "";
        this.sbd = 0;
        this.dateOfBirth = "";
        this.gender = "";
        this.province = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSbd() {
        return sbd;
    }

    public void setSbd(int sbd) {
        this.sbd = sbd;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getExamBlock() {
        return examBlock;
    }

    public void setExamBlock(String examBlock) {
        this.examBlock = examBlock;
    }

    public float getScore1() {
        return score1;
    }

    public void setScore1(float score1) {
        this.score1 = score1;
    }

    public float getScore2() {
        return score2;
    }

    public void setScore2(float score2) {
        this.score2 = score2;
    }

    public float getScore3() {
        return score3;
    }

    public void setScore3(float score3) {
        this.score3 = score3;
    }

    public void setTotalScore() {
        this.totalScore = score1 + score2 + score3;
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
