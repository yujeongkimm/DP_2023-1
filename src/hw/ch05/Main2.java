package hw.ch05;

import hw.ch05.idcard.IDCardFactoryKimYuJeong2;

public class Main2 extends Thread{
    public static void main(String args[]) {
        System.out.println("<<20201111, 김유정>>>");
        
        new Main2("최승훈").start();
        new Main2("김유정").start();
        new Main2("김혜정").start();
    }

    @Override
    public void run() {
        IDCardFactoryKimYuJeong2 obj = IDCardFactoryKimYuJeong2.getInstance();
        System.out.println(getName() + ": obj = " + obj);
    }

    public Main2(String name) {
        super(name);
    }
    
}
