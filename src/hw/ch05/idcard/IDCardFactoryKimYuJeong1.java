package hw.ch05.idcard;

import hw.ch05.framework.Factory;
import hw.ch05.framework.Product;

public class IDCardFactoryKimYuJeong1 extends Factory {
    // eager initialization 
    private static IDCardFactoryKimYuJeong1 singleton = new IDCardFactoryKimYuJeong1();

    private IDCardFactoryKimYuJeong1() {
        System.out.println("인스턴스를 생성했습니다.");
    }

    public static IDCardFactoryKimYuJeong1 getInstance() {
        return singleton;
    }

    @Override
    protected Product createProduct(String owner) {
        return new IDCard(owner);
    }

    @Override
    protected void registerProduct(Product product) {
        System.out.println(product + "을 등록했습니다.");
    }
    
}