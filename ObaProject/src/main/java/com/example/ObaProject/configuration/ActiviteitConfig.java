package com.example.ObaProject.configuration;

import com.example.ObaProject.data.Activiteit;
import org.springframework.context.annotation.Configuration;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Configuration
public class ActiviteitConfig {


    public List<Activiteit> resultsToJson(NodeList list) {
        List<Activiteit> activiteiten = new ArrayList<>();
        for (int itr = 0; itr < list.getLength(); itr++)
        {
            Node node = list.item(itr);
            if (node.getNodeType() == Node.ELEMENT_NODE)
            {
                Element eElement = (Element) node;
                activiteiten.add(getActiviteit(eElement));
            }
        }
        return activiteiten;
    }
    public Activiteit getActiviteit(Element eElement) {
        Activiteit activiteit = new Activiteit();
        activiteit.setId(getId(eElement));
        activiteit.setJaar(checkValue(eElement, "year") ? eElement.getElementsByTagName("year").item(0).getTextContent() : "");
        activiteit.setBeschrijving(checkValue(eElement, "summaries") ? eElement.getElementsByTagName("summaries").item(0).getTextContent() : "");
        activiteit.setGenre(checkValue(eElement, "format") ? eElement.getElementsByTagName("format").item(0).getTextContent() : "");
        activiteit.setTitle(checkValue(eElement, "title") ? eElement.getElementsByTagName("title").item(0).getTextContent() : "");
        activiteit.setDetailPagina(checkValue(eElement, "detail-page") ? eElement.getElementsByTagName("detail-page").item(0).getTextContent() : "");
        activiteit.setOmslagafbeeldingen(checkValue(eElement, "coverimages") ? eElement.getElementsByTagName("coverimages").item(0).getTextContent() : "");
        activiteit.setDoelgroep(checkValue(eElement, "target-audience") ? eElement.getElementsByTagName("target-audience").item(0).getTextContent() : "");
        activiteit.setLocatie(checkValue(eElement, "activity-location") ? eElement.getElementsByTagName("activity-location").item(0).getTextContent() : "");
        activiteit.setTijd(getTime(eElement));
        activiteit.setDatum(getDate(eElement));
        return activiteit;
    }
    public static boolean checkValue(Element e, String attr) {
        Optional<Node> opt = Optional.ofNullable(e.getElementsByTagName(attr).item(0));
        return opt.isPresent();
    }
    public static String getId(Element e) {
        NodeList n = checkValue(e, "id") ? e.getElementsByTagName("id") : null;
        Element eE = (Element) n.item(0);
        return eE.getAttribute("nativeid");
    }

    public static String getTime(Element e) {
        String strTijd = checkValue(e, "activity-start") ? e.getElementsByTagName("activity-start").item(0).getTextContent() : "";
        int iB = strTijd.indexOf('T');
        int iE = strTijd.indexOf('Z');
        String startTijd = strTijd.substring(iB + 1, iE);
        strTijd = checkValue(e, "activity-end") ? e.getElementsByTagName("activity-end").item(0).getTextContent() : "";
        iB = strTijd.indexOf('T');
        iE = strTijd.indexOf('Z');
        String endTijd = strTijd.substring(iB + 1, iE);
        return startTijd.substring(0, startTijd.length() - 3) + " - " + endTijd.substring(0, startTijd.length() - 3);
    }

    public static String getDate(Element e) {
        String strTijd = checkValue(e, "activity-start") ? e.getElementsByTagName("activity-start").item(0).getTextContent() : "";
        int iB = strTijd.indexOf('T');
        int iE = strTijd.indexOf('Z');
        String startTijd = strTijd.substring(0, iB);
        strTijd = checkValue(e, "activity-end") ? e.getElementsByTagName("activity-end").item(0).getTextContent() : "";
        iB = strTijd.indexOf('T');
        iE = strTijd.indexOf('Z');
        String endTijd = strTijd.substring(0, iB);
        return startTijd;
    }
}
