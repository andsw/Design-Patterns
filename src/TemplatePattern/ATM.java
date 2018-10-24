package TemplatePattern;

/**
 * @author hsw
 * @create 2018-10-24  18:54
 */

abstract class BankTemptlateMethod{

    protected void takeNumber(){
        System.out.println("taking number...");
    }

    protected abstract void transact();

    protected void evaluate(){
        System.out.println("evaluating...");
    }

    public void process(){
        takeNumber();
        transact();
        evaluate();
    }
}

class Transfer extends BankTemptlateMethod{

    @Override
    protected void transact() {
        System.out.println("transfer is transacting");
    }
}

class Withdraw extends BankTemptlateMethod {

    @Override
    protected void transact() {
        System.out.println("deposit is transacting");
    }
}

class Deposit extends BankTemptlateMethod {

    @Override
    protected void transact() {
        System.out.println("deposit is transacting");
    }
}

public class ATM {
    public static void main(String[] args) {
        BankTemptlateMethod deposit = new Deposit();
        deposit.process();
    }
}
