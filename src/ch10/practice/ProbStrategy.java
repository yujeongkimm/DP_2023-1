package ch10.practice;

import java.util.Random;

public class ProbStrategy implements Strategy {
    private Random random;
    private int prevHandValue = 0;  // 지난번에 냈던 손
    private int currentHandValue = 0;   // 이번에 냈던 손
    // 2차원 배열
    private int[][] history = {
        { 1, 1, 1, },
        { 1, 1, 1, },
        { 1, 1, 1, },
    };

    public ProbStrategy(int seed) {
        random = new Random(seed);
    }

    // 다음에 낼 손을 반환
    @Override
    public Hand nextHand() {
        int bet = random.nextInt(getSum(currentHandValue)); // 0~14 임의의 난수 생성
        int handvalue = 0;
        if (bet < history[currentHandValue][0]) {   // 천번째 구간에 해당
            handvalue = 0;
        } else if (bet < history[currentHandValue][0] + history[currentHandValue][1]) { // 두번째 구간에 해당
            handvalue = 1;
        } else {
            handvalue = 2;
        }
        prevHandValue = currentHandValue;
        currentHandValue = handvalue;
        return Hand.getHand(handvalue);
    }

    // 행을 다 더함
    private int getSum(int handvalue) { // handvalue : 몇 번째 행
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += history[handvalue][i];   // handvalue 행을 다 더함
        }
        return sum;
    }

    // 전략을 위한 준비 작업을 하는 메소드
    @Override
    public void study(boolean win) {
        if (win) {  // 이기면 
            history[prevHandValue][currentHandValue]++;
        } else {    // currentHandValue가 아니면 (currentHandValue + a)
            // %3은 3일 경우 나머지를 0으로 만들기 위해서
            history[prevHandValue][(currentHandValue + 1) % 3]++;
            history[prevHandValue][(currentHandValue + 2) % 3]++;
        }
    }
}
