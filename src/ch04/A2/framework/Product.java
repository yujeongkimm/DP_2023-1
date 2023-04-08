package ch04.A2.framework;

public abstract class Product {
    // 추상 클래스 정의 시, 생성자는 상속되지 않는다.
    // abstract한 생성자는 무의미함
    // public abstract Product(String name);
    public abstract void use();
}
