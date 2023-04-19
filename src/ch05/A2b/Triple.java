package ch05.A2b;

public enum Triple {
    ALPHA, BETA, GAMMA;

    // 생성자 private으로
    private Triple() {
        System.out.println("The instance " + this + " is created.");
    }

    // getInstance는 static으로
    // valueOf() : 매개변수로 주어진 String과 열거형에서 일치하는 이름을 갖는 원소를 반환
    public static Triple getInstance(String name) {
        return valueOf(name);   
    }
}
