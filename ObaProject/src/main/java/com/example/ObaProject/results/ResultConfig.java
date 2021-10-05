package com.example.ObaProject.results;

import com.example.ObaProject.results.activiteiten.Activiteit;
import com.example.ObaProject.results.activiteiten.ActiviteitConfig;
import com.example.ObaProject.results.boeken.Boek;
import com.example.ObaProject.results.boeken.BoekConfig;
import com.example.ObaProject.results.cursussen.Cursus;
import com.example.ObaProject.results.cursussen.CursusConfig;
import com.example.ObaProject.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Configuration
public class ResultConfig {
    private final ActiviteitConfig activiteitConfig;
    private final CursusConfig cursusConfig;
    private final BoekConfig boekConfig;

    @Autowired
    public ResultConfig(ActiviteitConfig activiteitConfig,
                        CursusConfig cursusConfig,
                        BoekConfig boekConfig) {
        this.activiteitConfig = activiteitConfig;
        this.cursusConfig = cursusConfig;
        this.boekConfig = boekConfig;
    }

    public Response resultsToJson(NodeList list) {

        List<Activiteit> activiteiten = new ArrayList<>();
        List<Cursus> cursussen = new ArrayList<>();
        List<Boek> boeken = new ArrayList<>();

        for (int itr = 0; itr < list.getLength(); itr++)
        {
            Node node = list.item(itr);
            if (node.getNodeType() == Node.ELEMENT_NODE)
            {
                Element eElement = (Element) node;
                Result result = new Result();

                String genre = checkValue(eElement, "format") ? eElement.getElementsByTagName("format").item(0).getTextContent() : "";
                System.out.println(genre);
                switch (genre) {
                    case "Activiteiten":
                        activiteiten.add(activiteitConfig.getActiviteit(eElement));
                        break;
                    case "Cursus":
                        cursussen.add(cursusConfig.getCursus(eElement));
                        break;
                    default :
                        boeken.add(boekConfig.getBoek(eElement));
                }
            }
        }
        return new Response();
    }

    public static boolean checkValue(Element e, String attr) {
        Optional<Node> opt = Optional.ofNullable(e.getElementsByTagName(attr).item(0));
        return opt.isPresent();
    }
}
