package SimpleFactoryPattern;

/**
 * @author hsw
 * @create 2018-09-12  19:25
 */

interface OperationInte {
    int calc(int a, int b);
}

class AddOper implements OperationInte{
    @Override
    public int calc(int a, int b) {
        return a + b;
    }
}

class SubOper implements OperationInte {
    @Override
    public int calc(int a, int b) {
        return a - b;
    }
}

class DivOper implements OperationInte {
    @Override
    public int calc(int a, int b) {
        int result;
        try {
            result = a / b;
        } catch (Exception e) {
            System.out.println("被除数不能等于0");
            return Integer.MIN_VALUE;
        }
        return result;
    }
}

class MulOper implements OperationInte {
    @Override
    public int calc(int a, int b) {
        return a * b;
    }
}

class OperationFactroy {
    public static OperationInte generateOperation(String type) {
        if (type.equals("add")) {
            return new AddOper();
        } else if (type.equals("div")) {
            return new DivOper();
        } else if (type.equals("sub")) {
            return new SubOper();
        } else if (type.equals("mul")) {
            return new MulOper();
        }
        return null;
    }
}

public class Calculator {
    public static void main(String[] args) {
        OperationInte operation = OperationFactroy.generateOperation("add");
        System.out.println("the result is " + operation.calc(100, 200));
    }
}
