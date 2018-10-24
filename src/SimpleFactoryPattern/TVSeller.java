package SimpleFactoryPattern;

/**
 * @author hsw
 * @create 2018-09-12  19:27
 */

interface TvInterface{
    void showBrand();
}

class HaiXinTV implements TvInterface {
    @Override
    public void showBrand() {
        System.out.println("我是海信电视");
    }
}

class XiaXinTV implements TvInterface {
    @Override
    public void showBrand() {
        System.out.println("我是夏新电视");
    }
}

class TVFactory {
    public static TvInterface productTV(String brandName) {
        if (brandName.equals("海信")) {
            return new HaiXinTV();
        } else if (brandName.equals("夏新")) {
            return new XiaXinTV();
        }
        return null;
    }
}

public class TVSeller {
    public static void main(String[] args) {
        TvInterface tv = TVFactory.productTV("夏新");
        tv.showBrand();
    }
}
