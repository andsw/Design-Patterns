package FactoryPattern;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * @author hsw
 * @create 2018-09-19  20:16
 */
public class XmlUtil {

    public static Object GetFromXml(String filename, String des) throws ParserConfigurationException, IOException,
            SAXException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        File file = new File(filename);
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(file);
        NodeList nodeList = document.getElementsByTagName("map");
        for (int i = 0; i < nodeList.getLength(); i++) {
            if (document.getElementsByTagName("name").item(i).getFirstChild().getNodeValue().equals(des)) {
                String className = document.getElementsByTagName("value").item(i).getFirstChild().getNodeValue();
                return Class.forName("FactoryPattern." + className).newInstance();
            }
        }
        return null;
    }

}
