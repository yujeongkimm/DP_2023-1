package ch03.practice;

public abstract class AbstractDisplay {
    // open, print, close는 하위 클래스에 구현을 맡기는 추상 메소드 
    public abstract void open();
    public abstract void print();
    public abstract void close();

    // display는 AbstractDisplay에서 구현하는 메소드 
    public final void display() {   // 구상 메소드 : 흐름의 큰 틀을 제공함 => 탬플릿 메소드

        // 추상 메소드들을 이용해서 구현 
        open();
        for (int i = 0; i < 5; i++) {   // 하드코딩
            print();
        }
        close();
    }
}
