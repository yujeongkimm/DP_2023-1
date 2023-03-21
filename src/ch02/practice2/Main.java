package ch02.practice2;

// 클라이언트
public class Main {
    public static void main(String[] args) {

        // 가정: 클라이언트가 직접 Banner를 사용하지 못한다
        // Banner를 수정하면 클라이언트가 영향을 받는다.
        Banner b = new Banner("kyj");
        b.showWithParen();
        b.showWithAster();

        // 일을 Banner가 하지만 클라이언트는 Print 인터페이스를 이용하기를 원한다
        // Banner를 수정해도 클라이언트는 영향을 안 받는다. 
        // Banner를 수정하지 않고도 Print처럼 사용했다.
        Print x = new PrintBanner("kyj");
        x.printWeak();
        x.printStrong();
    }
}
