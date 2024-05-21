package oop.project.qldiemthi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "candidates")
@XmlAccessorType(XmlAccessType.FIELD)
public class CandidateXML {
    private List<Candidate> listCandidates;

    public List<Candidate> getCandidateList() {
        return listCandidates;
    }

    public void setCandidateList(List<Candidate> listCandidates) {
        this.listCandidates = listCandidates;
    }
}
