package oop.project.qldiemthi;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CandidateFunction {
    private static final String candidate_file = "candidate.xml";
    private List<Candidate> candidateList;

    public CandidateFunction() {
        this.candidateList = readCandidateList();
        if(candidateList == null) {
            candidateList = new ArrayList<Candidate>();
        }
    }

    private List<Candidate> readCandidateList() {
        List<Candidate> list = new ArrayList<Candidate>();
        CandidateXML candidateXML = (CandidateXML) readXMLFile(candidate_file, CandidateXML.class);
        if(candidateXML != null) {
            list = candidateXML.getCandidateList();
        }
        return list;
    }

    public void writeCandidateList(List<Candidate> candidates) {
        CandidateXML candidateXML = new CandidateXML();
        candidateXML.setCandidateList(candidates);
        writeXMLtoFile(candidate_file, candidateXML);
    }

    public static Object readXMLFile(String fileName, Class<?> clazz) {
        try {
            File xmlFile = new File(fileName);
            JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            return jaxbUnmarshaller.unmarshal(xmlFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void writeXMLtoFile(String fileName, Object object) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
            Marshaller jabxMarshaller = jaxbContext.createMarshaller();
            jabxMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            File xmlFile = new File(fileName);
            jabxMarshaller.marshal(object, xmlFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addCandidate(Candidate candidate) {
        candidateList.add(candidate);
        writeCandidateList(candidateList);
    }

    public void editCandidate(Candidate candidate, int index) {
        candidateList.get(index).setName(candidate.getName());
        candidateList.get(index).setSbd(candidate.getSbd());
        candidateList.get(index).setGender(candidate.getGender());
        candidateList.get(index).setDateOfBirth(candidate.getDateOfBirth());
        candidateList.get(index).setProvince(candidate.getProvince());
        candidateList.get(index).setExamBlock(candidate.getExamBlock());
        candidateList.get(index).setScore1(candidate.getScore1());
        candidateList.get(index).setScore2(candidate.getScore2());
        candidateList.get(index).setScore3(candidate.getScore3());
        candidateList.get(index).setTotalScore();

        writeCandidateList(candidateList);
    }

    public void deleteCandidate(Candidate candidate, int index) {
        candidateList.remove(index);
        writeCandidateList(candidateList);
    }
}
