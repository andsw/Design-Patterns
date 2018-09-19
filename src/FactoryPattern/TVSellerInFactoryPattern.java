package FactoryPattern;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * @author hsw
 * @create 2018-09-19  19:25
 */

interface TV{
    void showBrand();
}

interface TVFactory{
    TV creatFactory();
}

class HaierTV implements TV{

    @Override
    public void showBrand() {
        System.out.println("I am Haier TV");
    }
}

class HisenseTV implements TV{

    @Override
    public void showBrand() {
        System.out.println("I an Hisense TV!");
    }
}

class HaierTVFactory implements TVFactory{

    @Override
    public TV creatFactory() {
        return new HaierTV();
    }
}

class HisenseTVFactory implements TVFactory{
    @Override
    public TV creatFactory() {
        return new HisenseTV();
    }
}

public class TVSellerInFactoryPattern {
    public static void main(String[] args) throws SAXException, IllegalAccessException, IOException, InstantiationException, ParserConfigurationException, ClassNotFoundException {
        TVFactory TVFactory = (TVFactory) XmlUtil.GetFromXml("src\\FactoryPattern\\TVFactoryXml.xml", "haiertv");
        assert TVFactory != null;
        TVFactory.creatFactory().showBrand();
    }
}
