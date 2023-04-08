package hw.ch04.car;

import java.util.Iterator;
import java.util.Vector;

import hw.ch04.framework.Factory;
import hw.ch04.framework.Product;

public class CarFactory extends Factory{
    private Vector<String> modelNames;

    // 생성자에서 백터 생성
    public CarFactory() {
        this.modelNames = new Vector<String>();
    }

    @Override
    public Product createProduct(String modelName) {
        return new Car_KimYuJeong(modelName);
    }

    @Override
    public void registerProduct(Product product) {
        Car_KimYuJeong c = (Car_KimYuJeong) product;    // 다운 캐스팅
        modelNames.add(c.getModelName());
    }

    public void printAllModelNames() {
        System.out.println("<모델명 리스트>");
        Iterator<String> itr = modelNames.iterator();
        while(itr.hasNext()) {
            System.out.println(itr.next());
        }
    }

}
