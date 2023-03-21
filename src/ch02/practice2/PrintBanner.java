package ch02.practice2;

// 어댑터 (위임을 이용함)
public class PrintBanner extends Print{
    // 어탭티를 갖는 속성
    // 자바는 다중상속 지원하지 않음 
    // 위임은 클래스를 속성으로 가짐
    private Banner banner; //220v

    public PrintBanner(String string) {
        this.banner = new Banner(string);
    }

    // 클라이언트는 12v 호출하지만 220v(adaptee)로 동작
    public void printWeak() { //12v
        banner.showWithParen(); //220v (위임)
    }

    public void printStrong() { //12v
        banner.showWithAster(); //220v
    }
    
}
