package ch05.A3a;

// Main 클래스가 스레드 클래스 
public class Main extends Thread {
    public static void main(String[] args) {
        System.out.println("Start.");
        // 스레드 객체가 3개 생성됨     
        // start()는 자동으로 run() 호출
        new Main("A").start();  // 시작
        new Main("B").start();  // 시작
        new Main("C").start();  // 시작 
        System.out.println("End.");
    }

    @Override
    public void run() { // 이 스레드가 하는 일 
        Singleton obj = Singleton.getInstance();
        System.out.println(getName() + ": obj = " + obj);
    }

    // 생성자
    public Main(String name) {
        super(name);
    }
}
