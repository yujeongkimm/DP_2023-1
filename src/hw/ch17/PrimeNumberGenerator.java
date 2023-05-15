package hw.ch17;

import java.util.Random;

public class PrimeNumberGenerator extends NumberGenerator{
    private Random random = new Random(); 	// 난수 생성기 
    private int number;                   		// 현재 수 

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public void execute() {
        for (int i = 0; i < 100; i++) {
            number = random.nextInt(100)+1; //1~100까지 난수 
            if (isPrimeNumber(number)) {
                notifyObservers();
            }
        }
    }
    
    public boolean isPrimeNumber(int num) {
        for(int i = 2; i < num; i++) {
        	// 순차적으로 i를 num에 나누어본다.
			if(num%i == 0) {
            	// num이 i로 나눠져 나머지가 0이 되면 isPrime에 false(소수가 아님)을 입력한다.
				return false;
			}
		}
        return true;
    }
}
