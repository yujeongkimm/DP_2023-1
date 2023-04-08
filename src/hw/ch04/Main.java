package hw.ch04;

import hw.ch04.car.CarFactory;
import hw.ch04.framework.Factory;
import hw.ch04.framework.Product;

public class Main {
    public static void main(String args[]) {
        System.out.println("<<20201111, 김유정>>>");

        Factory f = new CarFactory();
        Product p1 = f.create("김유정");
        Product p2 = f.create("그랜저");
        Product p3 = f.create("소나타");
        Product p4 = f.create("캐스퍼");
        p1.use();
        p2.use();
        p3.use();
        p4.use();


        System.out.println();
        CarFactory cf = (CarFactory)f;  // 다운 캐스팅
        cf.printAllModelNames();
        
    }
    
}
