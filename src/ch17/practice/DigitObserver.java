package ch17.practice;

// 구체적인 관찰자
public class DigitObserver implements Observer {
    // 통지 받아서 하는 일
    @Override
    public void update(NumberGenerator generator) {
        System.out.println("DigitObserver:" + generator.getNumber());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
    }
}
