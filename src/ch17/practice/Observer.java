package ch17.practice;

// 관찰자
public interface Observer {
    // 통지 받을 때  호출되는 메소드
    public abstract void update(NumberGenerator generator);
}
