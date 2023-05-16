package ch20.Sample;

public class BigString {
    // '큰 문자'의 배열
    private BigChar[] bigchars; // 배열을 선언

    // 생성자 
    public BigString(String string) {   // "1212123"
        // 공장을 얻음
        BigCharFactory factory = BigCharFactory.getInstance();
        // 배열을 생성 
        bigchars = new BigChar[string.length()];    
        // BigChar 생성을 공장에게 위임 
        for (int i = 0; i < bigchars.length; i++) {
            bigchars[i] = factory.getBigChar(string.charAt(i));
        }
    }

    // 표시
    public void print() {
        for (BigChar bc: bigchars) {
            bc.print();
        }
    }
}
