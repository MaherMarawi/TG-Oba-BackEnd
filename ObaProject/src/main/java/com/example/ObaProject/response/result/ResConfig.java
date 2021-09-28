package com.example.ObaProject.response.result;

import org.springframework.context.annotation.Configuration;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Configuration
public class ResConfig {


    public List<Res> resultsToJson(NodeList list) {
        List<Res> results = new ArrayList<>();
        for (int itr = 0; itr < list.getLength(); itr++)
        {
            Node node = list.item(itr);
            if (node.getNodeType() == Node.ELEMENT_NODE)
            {
                Element eElement = (Element) node;
                Res res = new Res();
                res.setDetail_page(checkValue(eElement, "detail-page") ? eElement.getElementsByTagName("detail-page").item(0).getTextContent() : "");
                res.setTypes(checkValue(eElement, "types") ? eElement.getElementsByTagName("types").item(0).getTextContent() : "");
                res.setFormats(checkValue(eElement, "formats") ? eElement.getElementsByTagName("formats").item(0).getTextContent() : "");
                res.setNotes(checkValue(eElement, "notes") ? eElement.getElementsByTagName("notes").item(0).getTextContent() : "");
                res.setCoverimages(checkValue(eElement, "coverimages") ? eElement.getElementsByTagName("coverimages").item(0).getTextContent() : "");
                res.setLanguages(checkValue(eElement, "languages") ? eElement.getElementsByTagName("languages").item(0).getTextContent() : "");
                res.setUndup_info(checkValue(eElement, "undup-info") ? eElement.getElementsByTagName("undup-info").item(0).getTextContent() : "");
                res.setIdentifiers(checkValue(eElement, "identifiers") ? eElement.getElementsByTagName("identifiers").item(0).getTextContent() : "");
                res.setSubjects(checkValue(eElement, "subjects") ? eElement.getElementsByTagName("subjects").item(0).getTextContent() : "");
                res.setDescription(checkValue(eElement, "description") ? eElement.getElementsByTagName("description").item(0).getTextContent() : "");
                res.setTitles(checkValue(eElement, "titles") ? eElement.getElementsByTagName("titles").item(0).getTextContent() : "");
                res.setFrabl(checkValue(eElement, "frabl") ? eElement.getElementsByTagName("frabl").item(0).getTextContent() : "");
                res.setSeries(checkValue(eElement, "series") ? eElement.getElementsByTagName("series").item(0).getTextContent() : "");
                res.setPublication(checkValue(eElement, "publication") ? eElement.getElementsByTagName("publication").item(0).getTextContent() : "");
                res.setId(checkValue(eElement, "id") ? eElement.getElementsByTagName("id").item(0).getTextContent() : "");
                res.setAuthors(checkValue(eElement, "authors") ? eElement.getElementsByTagName("authors").item(0).getTextContent() : "");
                res.setGenres(checkValue(eElement, "genres") ? eElement.getElementsByTagName("genres").item(0).getTextContent() : "");
                res.setSummaries(checkValue(eElement, "summaries") ? eElement.getElementsByTagName("summaries").item(0).getTextContent() : "");
                res.setClassification(checkValue(eElement, "classification") ? eElement.getElementsByTagName("classification").item(0).getTextContent() : "");
                res.setYear(checkValue(eElement, "year") ? eElement.getElementsByTagName("year").item(0).getTextContent() : "");
                res.setSubject_topical(checkValue(eElement, "subject-topical") ? eElement.getElementsByTagName("subject-topical").item(0).getTextContent() : "");
                res.setEresources(checkValue(eElement, "eresources") ? eElement.getElementsByTagName("eresources").item(0).getTextContent() : "");
                res.setCustom(checkValue(eElement, "custom") ? eElement.getElementsByTagName("custom").item(0).getTextContent() : "");
                results.add(res);
            }
        }

        return results;
    }
    public static boolean checkValue(Element e, String attr) {
        Optional<Node> opt = Optional.ofNullable(e.getElementsByTagName(attr).item(0));
        return opt.isPresent();
    }

}
