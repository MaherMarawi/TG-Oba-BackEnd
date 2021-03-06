package com.example.ObaProject.configuration;

import com.example.ObaProject.data.Cursus;
import org.springframework.context.annotation.Configuration;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Configuration
public class CursusConfig {

    public List<Cursus> resultsToJson(NodeList list) {
        List<Cursus> cursussen = new ArrayList<>();
        for (int itr = 0; itr < list.getLength(); itr++)
        {
            Node node = list.item(itr);
            if (node.getNodeType() == Node.ELEMENT_NODE)
            {
                Element eElement = (Element) node;
                    cursussen.add(getCursus(eElement));
            }
        }
        return cursussen;
    }
    public Cursus getCursus(Element eElement) {
        Cursus cursus = new Cursus();
        cursus.setId(getId(eElement));
        cursus.setBeschrijving(checkValue(eElement, "summaries") ? eElement.getElementsByTagName("summaries").item(0).getTextContent() : "");
        cursus.setGenre(checkValue(eElement, "format") ? eElement.getElementsByTagName("format").item(0).getTextContent() : "");
        cursus.setTitle(checkValue(eElement, "title") ? eElement.getElementsByTagName("title").item(0).getTextContent() : "");
        cursus.setDetailPagina(checkValue(eElement, "detail-page") ? eElement.getElementsByTagName("detail-page").item(0).getTextContent() : "");
        cursus.setOmslagafbeeldingen(checkValue(eElement, "coverimages") ? eElement.getElementsByTagName("coverimages").item(0).getTextContent() : "");
        cursus.setInfo(checkValue(eElement, "course-info") ? eElement.getElementsByTagName("course-info").item(0).getTextContent() : "");
        cursus.setPrijs(checkValue(eElement, "course-price") ? eElement.getElementsByTagName("course-price").item(0).getTextContent() : "");
        cursus.setBijlesdocent(checkValue(eElement, "course-tutor") ? eElement.getElementsByTagName("course-tutors").item(0).getTextContent() : "");
        cursus.setLocatie(checkValue(eElement, "course-location") ? eElement.getElementsByTagName("course-location").item(0).getTextContent() : "");
        return cursus;
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
}
