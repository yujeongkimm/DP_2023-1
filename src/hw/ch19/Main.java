package hw.ch19;

public class Main {
    public static void main(String[] args) {
        SafeFrame frame = new SafeFrame("학번: 20201111, 이름: 김유정");
        while (true) {
            for (int hour = 15; hour < 24; hour++) {
                frame.setClock(hour);   // 시간 설정
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                }
            }
        }
    }
}
