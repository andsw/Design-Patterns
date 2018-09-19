package FactoryPattern;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * @author hsw
 * @create 2018-09-19  19:46
 */

interface Log{
    void createLog();
}

interface LogFactory{
    Log generateLog();
}

class DatabaseLog implements Log{

    @Override
    public void createLog() {
        System.out.println("create database log");
    }
}

class FileLog implements Log{

    @Override
    public void createLog() {
        System.out.println("create file log");
    }
}

class DatabaseLogFactory implements LogFactory {
    @Override
    public Log generateLog() {
        return new DatabaseLog();
    }
}

class FileLogFactory implements LogFactory{

    @Override
    public Log generateLog() {
        return new FileLog();
    }
}
//D:\文件\Design-Patterns\src\FactoryPattern\LogFactoryXml.xml
public class LogGeneratorInFactoryPattern {

    public static void main(String[] args) throws SAXException,
            IllegalAccessException, IOException, InstantiationException, ParserConfigurationException, ClassNotFoundException {
       LogFactory logFactory = (LogFactory) XmlUtil.GetFromXml("src\\FactoryPattern\\LogFactoryXml.xml", "filelog");
        assert logFactory != null;
        logFactory.generateLog().createLog();
    }
}
