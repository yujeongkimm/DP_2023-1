package ch04.practice.framework;

// 공장이 객체 생성
public abstract class Factory {
    // 제품 생산 시 하는 큰 흐름 => 템플릿 메소드
    // final : 상속에서 사용할 수 없음! 
    public final Product create(String owner) {
        Product p = createProduct(owner);
        registerProduct(p);
        return p;
    }

    // 추상 메소드
    // factoryMethod
    // 실제로 어떤 제품(객체)를 생성할 지는 자식에게 맡긴다.
    protected abstract Product createProduct(String owner);
    protected abstract void registerProduct(Product product);
}
