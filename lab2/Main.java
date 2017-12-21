package com.company;

import jdk.internal.org.xml.sax.SAXException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    private static String XML_FILE = "G:\\навчання\\5 курс\\Інженерія даних та знань\\lab2\\lab2\\xmlFile.xml";
    private static String CSV_FILE = "G:\\навчання\\5 курс\\Інженерія даних та знань\\lab2\\lab2\\csvFile.csv";

    public static void main(String[] args) throws Exception {
        List<String> xmlStrings = readXMLFile();
        List<StringItem> csvStrings = readCSV(CSV_FILE);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(String.format("Choose xml string number (enabled %d strings)", xmlStrings.size()));
        int xmlIndex = Integer.parseInt(br.readLine());
        System.out.println(String.format("Choose csv string number (enabled %d strings)", csvStrings.size()));
        int csvIndex = Integer.parseInt(br.readLine());

        int result = WordCmp(xmlStrings.get(xmlIndex), csvStrings.get(csvIndex).content);
        System.out.println("Strings:");
        System.out.println("S1: " + xmlStrings.get(xmlIndex));
        System.out.println("S2: " + csvStrings.get(csvIndex).content);
        if (result == 0) {
            System.out.println("String have equal length");
        } else if (result == 1) {
            System.out.println("S1 bigger");
        } else {
            System.out.println("S2 bigger");
        }

        System.out.println();
    }

    private static int WordCmp(String s1, String s2) {
        s1 = s1.replaceAll("\\s{2,}", " ").trim();
        s2 = s2.replaceAll("\\s{2,}", " ").trim();
        if (s1.length() == s2.length()) {
            return 0;
        }
        return s1.length() > s2.length() ? 1 : -1;
    }

    private static List<String> readXMLFile() throws Exception {
        List<String> elementList = new ArrayList<>();

        File fXmlFile = new File(XML_FILE);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);
        doc.getDocumentElement().normalize();

        System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
        NodeList nList = doc.getElementsByTagName("stringItem");
        for (int i = 0; i < nList.getLength(); i++) {
            elementList.add(nList.item(i).getTextContent());
        }

        return elementList;
    }

    private static List<StringItem> readCSV(String inputFilePath) {
        List<StringItem> inputList = new ArrayList<>();
        try{
            File inputF = new File(inputFilePath);
            InputStream inputFS = new FileInputStream(inputF);
            BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));
            inputList = br.lines().map(mapToItem).collect(Collectors.toList());
            br.close();
        } catch (Exception e) {
        }
        return inputList ;
    }

    private static Function<String, StringItem> mapToItem = (line) -> {
        String[] p = line.split(",");
        StringItem item = new StringItem();
        item.number = Integer.parseInt(p[0]);
        if (p[1] != null && p[1].trim().length() > 0) {
            item.content = p[1];
        }
        return item;
    };
}
