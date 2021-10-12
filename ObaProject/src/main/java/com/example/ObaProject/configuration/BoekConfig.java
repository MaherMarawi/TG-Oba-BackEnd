package com.example.ObaProject.configuration;

import com.example.ObaProject.data.Boek;
import org.springframework.context.annotation.Configuration;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.stream.events.EndElement;
import java.util.*;

@Configuration
public class BoekConfig {

    public List<Boek> resultsToJson(NodeList list) {

        List<Boek> boeken = new ArrayList<>();
        for (int itr = 0; itr < list.getLength(); itr++)
        {
            Node node = list.item(itr);
            if (node.getNodeType() == Node.ELEMENT_NODE)
            {
                Element eElement = (Element) node;
                String genre = checkValue(eElement, "format") ? eElement.getElementsByTagName("format").item(0).getTextContent() : "";
//                if (!genre.equals("Activiteiten") && !genre.equals("Cursus")) {
                    boeken.add(getBoek(eElement));
//                }
            }
        }
        return boeken;
    }
    public Boek getBoek(Element eElement) {
        Boek boek = new Boek();
        boek.setId(getId(eElement));
        boek.setBeschrijving(checkValue(eElement, "summaries") ? eElement.getElementsByTagName("summaries").item(0).getTextContent() : "");

        boek.setSubtitle(checkValue(eElement, "subtitle") ? eElement.getElementsByTagName("subtitle").item(0).getTextContent() : "");
        boek.setTitle(getTitle(boek.getSubtitle(), eElement));
        boek.setDetailPagina(checkValue(eElement, "detail-page") ? eElement.getElementsByTagName("detail-page").item(0).getTextContent() : "");
        boek.setOmslagafbeeldingen(checkValue(eElement, "coverimages") ? eElement.getElementsByTagName("coverimages").item(0).getTextContent() : "");
        boek.setLocatie(checkValue(eElement, "activity-location") ? eElement.getElementsByTagName("activity-location").item(0).getTextContent() : "");
        boek.setUitgave_jaar(checkValue(eElement, "year") ? eElement.getElementsByTagName("year").item(0).getTextContent() : "");
        boek.setDoelgroep(checkValue(eElement, "target-audience") ? eElement.getElementsByTagName("target-audience").item(0).getTextContent() : "");
        boek.setGenre(checkValue(eElement, "format") ? eElement.getElementsByTagName("format").item(0).getTextContent() : "");
        boek.setSeries(checkValue(eElement, "series-title") ? eElement.getElementsByTagName("series-title").item(0).getTextContent() : "");
        boek.setUitgever(checkValue(eElement, "publisher") ? eElement.getElementsByTagName("publisher").item(0).getTextContent() : "");
        boek.setTaal(checkValue(eElement, "language") ? eElement.getElementsByTagName("language").item(0).getTextContent() : "");
        boek.setAuteurs(checkValue(eElement, "main-author") ? eElement.getElementsByTagName("main-author").item(0).getTextContent() : "");
        boek.setTopical_subjects(checkValue(eElement, "subjects") ? eElement.getElementsByTagName("subjects").item(0).getTextContent() : "");
        return boek;
    }
    public static boolean checkValue(Element e, String attr) {
        Optional<Node> opt = Optional.ofNullable(e.getElementsByTagName(attr).item(0));
        return opt.isPresent();
    }
    public static int getId(Element e) {
        NodeList n = checkValue(e, "id") ? e.getElementsByTagName("id") : null;
        Element eE = (Element) n.item(0);
        return Integer.parseInt(eE.getAttribute("nativeid"));
    }
    public static String getTitle(String subtitle, Element e) {
        String title = checkValue(e, "short-title") ? e.getElementsByTagName("short-title").item(0).getTextContent() : "";
        if (!title.equals("") && !subtitle.equals("")) {
            Collection titleArray = new ArrayList(Arrays.asList(title.split(" ")));
            List subtitleArray = Arrays.asList(subtitle.split(" "));
            titleArray.removeAll(subtitleArray);
            String listString = String.join(",", titleArray).replaceAll(",", " ");
            return listString.replaceAll(":", "");
        }
        return title;
    }
}
