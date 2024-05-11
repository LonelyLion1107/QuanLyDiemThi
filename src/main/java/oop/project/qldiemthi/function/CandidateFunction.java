package oop.project.qldiemthi.function;

import oop.project.qldiemthi.entity.Candidate;
import oop.project.qldiemthi.entity.CandidateXML;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CandidateFunction {
    private static final String Candidate_File_Name = "candidate.xml";
    private List<Candidate> candidateList;

    public CandidateFunction() {
        this.candidateList = readCandidateList();
        if(candidateList == null) {
            candidateList = new ArrayList<Candidate>();
        }
    }

    public void writeCandidateList(List<Candidate> candidates) {
        CandidateXML candidateXML = new CandidateXML();
        candidateXML.setCandidates(candidates);

    }

    public List<Candidate> readCandidateList() {
        List<Candidate> list = new ArrayList<Candidate>();


        return list;
    }

    public void addCandidate(Candidate candidate) {
        int id = 1;
        if (candidateList != null && candidateList.size() > 0) {
            id = candidateList.size() + 1;
        }
        candidate.setId(id);
        candidateList.add(candidate);
        writeCandidateList(candidateList);
    }

    public void edit(Candidate candidate) {
        int size = candidateList.size();

        for(int i = 0; i < size; i++) {
            if(candidateList.get(i).getId() == candidate.getId()) {
                candidateList.get(i).setName(candidate.getName());
                candidateList.get(i).setDayOfBirth(candidate.getDayOfBirth());
                candidateList.get(i).setGender(candidate.getGender());
                candidateList.get(i).setExamBlock(candidate.getExamBlock());
                candidateList.get(i).setScore(candidate.getScore());
                candidateList.get(i).setProvince(candidate.getProvince());
                candidateList.get(i).setTotalScore();
                writeCandidateList(candidateList);
                break;
            }
        }
    }

    public boolean delete(Candidate candidate) {
        boolean isFound = false;
        int size = candidateList.size();
        for (int i = 0; i < size; i++) {
            if (candidateList.get(i).getId() == candidate.getId()) {
                candidate = candidateList.get(i);
                isFound = true;
                break;
            }
        }
        if (isFound) {
            candidateList.remove(candidate);
            writeCandidateList(candidateList);
            return true;
        }
        return false;
    }

    public void sortByName() {
        Collections.sort(candidateList, new Comparator<Candidate>() {
            @Override
            public int compare(Candidate o1, Candidate o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
    }

    public void sortByTotalScore() {
        Collections.sort(candidateList, new Comparator<Candidate>() {
            @Override
            public int compare(Candidate o1, Candidate o2) {
                if(o1.getTotalScore() > o2.getTotalScore()){
                    return 1;
                } else if(o1.getTotalScore() < o2.getTotalScore()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
    }

    public List<Candidate> findByName(String name) {
        List<Candidate> foundList = new ArrayList<Candidate>();
        int size = candidateList.size();
        for(int i = 0; i < size; i++) {
            if(candidateList.get(i).getName().contains(name)) {
                foundList.add(candidateList.get(i));
            }
        }
        return foundList;
    }


    public Candidate findById(int id) {
        int size = candidateList.size();
        Candidate result = null;
        for(int i = 0; i < size; i++) {
            if(candidateList.get(i).getId() == id) {
                result = candidateList.get(i);
            }
        }
        return result;
    }

    public List<Candidate> getCandidateList() {
        return candidateList;
    }

    public void setCandidateList(List<Candidate> candidateList) {
        this.candidateList = candidateList;
    }
}
