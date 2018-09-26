package AbstractFactoryPattern;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * @author hsw
 * @create 2018-09-26  19:15
 */

interface TelevisionIter{
    void play();
}

interface AirConditionerIter{
    void changeTemperature();
}

interface EFactory{
    TelevisionIter produceTelevision();
    AirConditionerIter produceAirConditioner();
}

class HaierTelevision implements TelevisionIter {
    @Override
    public void play() {
        System.out.println("this is Haier TV");
    }
}

class TCLTelevision implements TelevisionIter {
    @Override
    public void play() {
        System.out.println("this is TCL TV");
    }
}

class HaierAirConditioner implements AirConditionerIter {
    @Override
    public void changeTemperature() {
        System.out.println("this is Haier AirConditioner");
    }
}

class TCLAirConditioner implements AirConditionerIter {
    @Override
    public void changeTemperature() {
        System.out.println("this is TCL AirConditioner");
    }
}

class HaierFactory implements EFactory {
    @Override
    public TelevisionIter produceTelevision() {
        return new HaierTelevision();
    }

    @Override
    public AirConditionerIter produceAirConditioner() {
        return new HaierAirConditioner();
    }
}

class TCLFactory implements EFactory {
    @Override
    public TelevisionIter produceTelevision() {
        return new TCLTelevision();
    }

    @Override
    public AirConditionerIter produceAirConditioner() {
        return new TCLAirConditioner();
    }
}

public class AppliancesAbstractFactory {
    public static void main(String[] args) throws SAXException, IllegalAccessException, IOException, InstantiationException, ParserConfigurationException, ClassNotFoundException {
        EFactory haierFactory = (EFactory) XmlUtil.GetFromXml(new File("src\\AbstractFactoryPattern\\ApplianceXml.xml"), "haier");
        TelevisionIter tv = haierFactory.produceTelevision();
        tv.play();
    }
}
