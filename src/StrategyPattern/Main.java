package StrategyPattern;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

interface CalcInterface{
    int calcu(int a,int b);
}

class AddCalc implements CalcInterface{

    @Override
    public int calcu(int a, int b) {
        // TODO Auto-generated method stub
        return a + b;
    }

}

class SubCalc implements CalcInterface{

    @Override
    public int calcu(int a, int b) {
        // TODO Auto-generated method stub
        return a + b;
    }

}

class DivCalc implements CalcInterface{

    @Override
    public int calcu(int a, int b) {
        // TODO Auto-generated method stub
        if(b==0)throw new ArithmeticException();
        return a / b;
    }

}

class MulCalc implements CalcInterface{

    @Override
    public int calcu(int a, int b) {
        // TODO Auto-generated method stub
        return a * b;
    }

}


class Calculator{

    private CalcInterface calcInterface;

    public void setCalcInterface(CalcInterface calcInterface) {
        this.calcInterface = calcInterface;
    }

    private void setOperatorClass(String operator) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        FileInputStream fileInputStream = new FileInputStream(new File("config.properties"));
        Properties properties = new Properties();
        properties.load(fileInputStream);
        //if can not find corresponding value, return default value ""
        String className = properties.getProperty(operator,"");
        fileInputStream.close();
        if (!"".equals(className)) {
            Class clazz = Class.forName(className);
            setCalcInterface((CalcInterface) clazz.newInstance());
        }
    }

    public int calcu(String expression) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
        String pattern = "[1-9]\\d*.+[1-9]\\d*=?";
        if(!Pattern.matches(pattern,expression))throw new PatternSyntaxException("表达式格式错误！",pattern,-1);
        //why this pattern string can not to group expression to string array!
        String splitPattern = "([1-9]\\d*)(.+)([1-9]\\d*)(=?)";
        Pattern pattern1 = Pattern.compile(splitPattern);
        Matcher matcher = pattern1.matcher(expression);
        setOperatorClass(matcher.group(1));
        return calcInterface.calcu(Integer.parseInt(matcher.group(0)), Integer.parseInt(matcher.group(1)));
    }
}

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IOException, InstantiationException, IllegalAccessException {
        Calculator calculator = new Calculator();
        calculator.calcu("1+1=");
    }
}
