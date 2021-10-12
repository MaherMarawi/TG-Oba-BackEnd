package com.example.ObaProject.configuration;

import com.example.ObaProject.data.Meta;
import org.springframework.context.annotation.Configuration;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@Configuration
public class MetaConfig {
    public Meta resultsToJson(NodeList list) {
        Meta meta = new Meta();
        for (int itr = 0; itr < list.getLength(); itr++)
        {
            Node node = list.item(itr);
            if (node.getNodeType() == Node.ELEMENT_NODE)
            {
                NodeList n = ((Element) node).getElementsByTagName("count");
                meta.setCount(((Element) node).getElementsByTagName("count").item(0).getTextContent());
                meta.setPage(((Element) node).getElementsByTagName("page").item(0).getTextContent());
            }
        }
        return meta;
    }
}
