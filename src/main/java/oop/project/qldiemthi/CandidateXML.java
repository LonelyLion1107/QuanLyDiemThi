package oop.project.qldiemthi;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class CandidateXML {

    public CandidateXML() {
    }

    public List<Candidate> readListCandidates() {
        List<Candidate> candidateList = new ArrayList<>();
        Candidate candidate = null;

        try {
            File candidateFile = new File("candidate.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(candidateFile);

            NodeList nodeListCandidate = doc.getElementsByTagName("candidate");

            for (int i = 0; i < nodeListCandidate.getLength(); i++) {
                candidate = new Candidate();
                Node nNode = nodeListCandidate.item(i);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    candidate.setName(eElement.getElementsByTagName("name").item(0).getTextContent());
                    candidate.setSbd(Integer.parseInt(eElement.getElementsByTagName("sbd").item(0).getTextContent()));
                    candidate.setGender(eElement.getElementsByTagName("gender").item(0).getTextContent());
                    candidate.setDateOfBirth(eElement.getElementsByTagName("dateOfBirth").item(0).getTextContent());
                    candidate.setProvince(eElement.getElementsByTagName("province").item(0).getTextContent());
                    candidate.setExamBlock(eElement.getElementsByTagName("examBlock").item(0).getTextContent());
                    candidate.setScore1(Float.parseFloat(eElement.getElementsByTagName("score1").item(0).getTextContent()));
                    candidate.setScore2(Float.parseFloat(eElement.getElementsByTagName("score2").item(0).getTextContent()));
                    candidate.setScore3(Float.parseFloat(eElement.getElementsByTagName("score3").item(0).getTextContent()));
                    candidate.setTotalScore();
                }
                candidateList.add(candidate);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return candidateList;
    }

    public void createXML(List<Candidate> candidateList) {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            //Tạo phần tử gốc
            Element rootElement = doc.createElement("candidateList");
            doc.appendChild(rootElement);

            for(int i = 0; i < candidateList.size(); i++) {
                //Tạo phần tử
                Element candidate = doc.createElement("candidate");
                rootElement.appendChild(candidate);

                //Tạo các thẻ
                Element name = doc.createElement("name");
                name.appendChild(doc.createTextNode(candidateList.get(i).getName()));
                candidate.appendChild(name);

                Element sbd = doc.createElement("sbd");
                sbd.appendChild(doc.createTextNode(String.valueOf(candidateList.get(i).getSbd())));
                candidate.appendChild(sbd);

                Element gender = doc.createElement("gender");
                gender.appendChild(doc.createTextNode(candidateList.get(i).getGender()));
                candidate.appendChild(gender);

                Element dateOfBirth = doc.createElement("dateOfBirth");
                dateOfBirth.appendChild(doc.createTextNode(candidateList.get(i).getDateOfBirth()));
                candidate.appendChild(dateOfBirth);

                Element province = doc.createElement("province");
                province.appendChild(doc.createTextNode(candidateList.get(i).getProvince()));
                candidate.appendChild(province);

                Element examBlock = doc.createElement("examBlock");
                examBlock.appendChild(doc.createTextNode(candidateList.get(i).getExamBlock()));
                candidate.appendChild(examBlock);

                Element score1 = doc.createElement("score1");
                score1.appendChild(doc.createTextNode(String.valueOf(candidateList.get(i).getScore1())));
                candidate.appendChild(score1);

                Element score2 = doc.createElement("score2");
                score2.appendChild(doc.createTextNode(String.valueOf(candidateList.get(i).getScore2())));
                candidate.appendChild(score2);

                Element score3 = doc.createElement("score3");
                score3.appendChild(doc.createTextNode(String.valueOf(candidateList.get(i).getScore3())));
                candidate.appendChild(score3);

                Element totalScore = doc.createElement("totalScore");
                totalScore.appendChild(doc.createTextNode(String.valueOf(candidateList.get(i).getTotalScore())));
                candidate.appendChild(totalScore);
            }

            //Ghi nội dung vào file XML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("candidate.xml"));
            transformer.transform(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
