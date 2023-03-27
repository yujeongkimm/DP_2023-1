package hw.ch03;

public class Main {
    public static void main(String[] args) {
        System.out.println("20201111 김유정");
        // KimYuJeongDisplay 인스턴스를 하나 만든다 
        AbstractDisplay d1 = new KimYuJeongDisplay("김유정", "20201111", 4);

        // d1은 AbstractDisplay의 하위 클래스의 인스턴스이므로
        // 상속한 display 메소드를 호출할 수 있다
        // 실제 동작은 KimYuJeongDisplay 클래스에서 정해진다
        d1.display(10);
        d1.display(5);
    }
}
