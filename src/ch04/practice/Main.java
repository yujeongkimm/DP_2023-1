package ch04.practice;

import ch04.practice.framework.Factory;
import ch04.practice.framework.Product;
import ch04.practice.idcard.IDCard;
import ch04.practice.idcard.IDCardFactory;

public class Main {
    public static void main(String args[]) {
        // 신분증 직접 생성
        //Product id01 = new IDCard("kyj");    // 부모 타입으로 선언
        //id01.use();


        // 신분증을 공장을 통해 생성
        Factory f = new IDCardFactory();
        Product id02 = f.create("kyj");
        id02.use();
    }
}
