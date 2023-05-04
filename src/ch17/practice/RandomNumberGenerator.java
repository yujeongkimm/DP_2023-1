package ch17.practice;

import java.util.Random;

// 구체적인 관찰대상 (임의의 숫자 생성)
public class RandomNumberGenerator extends NumberGenerator {
    private Random random = new Random(); 	// 난수 생성기 
    private int number;                   		// 현재 수 (이 객체의 상태를 나타냄)

    // 수를 취득한다 
    @Override
    public int getNumber() {
        return number;
    }

    // 수를 생성한다 
    @Override
    public void execute() {
        for (int i = 0; i < 20; i++) {
            number = random.nextInt(50);    // 0~49 사이의 임의의 수 생성 => 상태변화
            notifyObservers();  // 관찰자에 통지 
        }
    }
}
