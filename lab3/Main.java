package com.company;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    private static String XML_FILE = "G:\\навчання\\5 курс\\Інженерія даних та знань\\lab3\\lab3\\xmlFile.xml";

    public static void main(String[] args) throws Exception {
	List<Team> teams = readFromXml();
	Collections.sort(teams);
	teams.forEach(team -> Collections.sort(team.getMembers()));
	teams.forEach(team -> System.out.println(team.toString()));
    }

    private static List<Team> readFromXml() throws Exception {
        List<Team> elementList = new ArrayList<>();

        File fXmlFile = new File(XML_FILE);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);
        doc.getDocumentElement().normalize();

        Element node = doc.getDocumentElement();
        NodeList nList = node.getElementsByTagName("Team");
        for (int i = 0; i < nList.getLength(); i++) {
            Team team = fromNode(nList.item(i));
            if (team != null) {
                elementList.add(team);
            }
        }

        return elementList;
    }

    private static Team fromNode(Node node) {
        if (node.getNodeType() != Node.ELEMENT_NODE) {
            return null;
        }
        Element element = (Element) node;
        Team team = new Team();
        team.setId(Integer.parseInt(element.getAttribute("id")));
        team.setName(element.getAttribute("name"));
        team.setType(SportType.fromId(Integer.parseInt(((Element) node).getAttribute("sportType"))));

        NodeList membersNodes =  element.getElementsByTagName("SportsMan");
        for (int i = 0; i < membersNodes.getLength(); i++) {
            Sportsman sportsman = getSportsmanFromNode(membersNodes.item(i));
            if (sportsman != null) {
                team.addMember(sportsman);
                sportsman.setTeam(team);
            }
        }
        return team;
    }

    private static Sportsman getSportsmanFromNode(Node node) {
        if (node.getNodeType() != Node.ELEMENT_NODE) {
            return null;
        }
        Element element = (Element) node;
        Sportsman sportsman = new Sportsman();
        sportsman.setName(element.getAttribute("name"));
        sportsman.setSurname(element.getAttribute("surname"));
        sportsman.setSportType(SportType.fromId(Integer.parseInt(element.getAttribute("sportType"))));
        sportsman.setResult(Integer.parseInt(element.getAttribute("result")));
        sportsman.setFinePoints(Integer.parseInt(element.getAttribute("fine")));
        return sportsman;
    }

}
