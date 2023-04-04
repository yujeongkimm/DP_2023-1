package ch06.Sample;

import ch06.Sample.framework.Manager;
import ch06.Sample.framework.Product;

public class Main {
    public static void main(String[] args) {
        // 준비 
        Manager manager = new Manager();
        UnderlinePen upen = new UnderlinePen('-');
        MessageBox mbox = new MessageBox('*');
        MessageBox sbox = new MessageBox('/');

        MessageBox box1 = new MessageBox('$');
        box1.use("Kim Yu Jeong");

        // 등록 
        manager.register("strong message", upen);
        manager.register("warning box", mbox);
        manager.register("slash box", sbox);
        manager.register("kyj box", box1);

        // 생성과 사용 
        // 클래스 이름 대신 문자열로 객체를 얻음 
        Product p1 = manager.create("strong message");
        p1.use("Hello, world.");

        Product p2 = manager.create("warning box");
        p2.use("Hello, world.");

        Product p3 = manager.create("slash box");
        p3.use("Hello, world.");

        Product p4 = manager.create("kyj box");
        p4.use("Duksung University");
    }
}
