package hw.ch04.car;

import hw.ch04.framework.Product;

public class Car_KimYuJeong extends Product{
    private String modelName;

    Car_KimYuJeong(String modelName) {
        this.modelName = modelName;
    }

    @Override
    public void use() {
        System.out.println(this + "를 사용합니다."); 
    }

    @Override
    public String toString() {  // Object 클래스로부터 상속
        return "모델명 " + modelName + "인 Car";
    }

    public String getModelName() {
        return modelName;
    }
}
