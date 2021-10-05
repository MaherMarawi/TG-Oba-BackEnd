package com.example.ObaProject.results.facet;

import org.springframework.context.annotation.Configuration;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class FacetConfig {

    public Facet resultsToJson(NodeList list) {

        Facet facet = new Facet();
        for (int itr = 0; itr < list.getLength(); itr++)
        {
            List<FacetItem> facetItemList = new ArrayList<>();
            Node node = list.item(itr);
            if (node.getNodeType() == Node.ELEMENT_NODE)
            {
                NodeList n = ((Element) node).getElementsByTagName("value");
                for (int i = 0; i < n.getLength(); i++) {
                    Element e = (Element) n.item(i);
                    FacetItem facetItem = new FacetItem();
                    facetItem.setId(e.getAttribute("id"));
                    facetItem.setCount(e.getAttribute("count"));
                    facetItemList.add(facetItem);
                }
                switch (((Element) node).getAttribute("id")) {
                    case "Type":
                        facet.setType(facetItemList.toArray(new FacetItem[facetItemList.size()]));
                        break;
                    case "Activiteiten":
                        facet.setActiviteiten(facetItemList.toArray(new FacetItem[facetItemList.size()]));
                        break;
                    case "Doelgroep":
                        facet.setDoelgroep(facetItemList.toArray(new FacetItem[facetItemList.size()]));
                        break;
                    case "Auteur":
                        facet.setAuteur(facetItemList.toArray(new FacetItem[facetItemList.size()]));
                        break;
                    case "Genre":
                        facet.setGenre(facetItemList.toArray(new FacetItem[facetItemList.size()]));
                        break;
                    case "Topic":
                        facet.setTopic(facetItemList.toArray(new FacetItem[facetItemList.size()]));
                        break;
                    case "Language":
                        facet.setLanguage(facetItemList.toArray(new FacetItem[facetItemList.size()]));
                        break;
                    case "pubYearRange":
                        facet.setPubYearRange(facetItemList.toArray(new FacetItem[facetItemList.size()]));
                        break;
                    case "pubYear":
                        facet.setPubYear(facetItemList.toArray(new FacetItem[facetItemList.size()]));
                        break;
                }
            }
        }
        return facet;
    }
}
