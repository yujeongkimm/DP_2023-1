package hw.ch05;

import hw.ch05.idcard.IDCardFactoryKimYuJeong1;

public class Main1 {
    public static void main(String args[]) {
        System.out.println("<<20201111, 김유정>>>");

        IDCardFactoryKimYuJeong1 factory1 = IDCardFactoryKimYuJeong1.getInstance();
        IDCardFactoryKimYuJeong1 factory2 = IDCardFactoryKimYuJeong1.getInstance();

        if (factory1 == factory2) {
            System.out.println("factory1과 factory2는 같은 인스턴스입니다.");
        } else {
            System.out.println("factory1과 factory2는 같은 인스턴스가 아닙니다.");
        }
    }
}
