package ch04.Sample.framework;

// 공장이 객체 생성
public abstract class Factory {
    public final Product create(String owner) {
        Product p = createProduct(owner);
        registerProduct(p);
        return p;
    }

    // 추상 메소드
    protected abstract Product createProduct(String owner);
    protected abstract void registerProduct(Product product);
}
