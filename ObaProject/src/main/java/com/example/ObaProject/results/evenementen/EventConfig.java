package com.example.ObaProject.results.evenementen;

import com.example.ObaProject.results.evenementen.Event;
import org.springframework.context.annotation.Configuration;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Configuration
public class EventConfig {


    public List<Event> resultsToJson(NodeList list) {
        List<Event> events = new ArrayList<>();
        for (int itr = 0; itr < list.getLength(); itr++)
        {
            Node node = list.item(itr);
            if (node.getNodeType() == Node.ELEMENT_NODE)
            {
                Element eElement = (Element) node;
                Event event = new Event();
                event.setJaar(checkValue(eElement, "year") ? eElement.getElementsByTagName("year").item(0).getTextContent() : "");
                event.setBeschrijving(checkValue(eElement, "summaries") ? eElement.getElementsByTagName("summaries").item(0).getTextContent() : "");
                event.setTitle(checkValue(eElement, "title") ? eElement.getElementsByTagName("title").item(0).getTextContent() : "");
                event.setDetailPagina(checkValue(eElement, "detail-page") ? eElement.getElementsByTagName("detail-page").item(0).getTextContent() : "");
                event.setOmslagafbeeldingen(checkValue(eElement, "coverimages") ? eElement.getElementsByTagName("coverimages").item(0).getTextContent() : "");
                event.setDoelgroep(checkValue(eElement, "target-audience") ? eElement.getElementsByTagName("target-audience").item(0).getTextContent() : "");
                event.setLocatie(checkValue(eElement, "activity-location") ? eElement.getElementsByTagName("activity-location").item(0).getTextContent() : "");
                event.setBegin(checkValue(eElement, "activity-start") ? eElement.getElementsByTagName("activity-start").item(0).getTextContent() : "");
                event.setEinde(checkValue(eElement, "activity-end") ? eElement.getElementsByTagName("activity-end").item(0).getTextContent() : "");

                events.add(event);
            }
        }

        return events;
    }
    public static boolean checkValue(Element e, String attr) {
        Optional<Node> opt = Optional.ofNullable(e.getElementsByTagName(attr).item(0));
        return opt.isPresent();
    }
}
