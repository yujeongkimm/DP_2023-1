package ch17.practice;

import java.util.ArrayList;
import java.util.List;

// 관찰대상
public abstract class NumberGenerator {
    // Observer를 저장한다  
    private List<Observer> observers = new ArrayList<>();

    // Observer를 추가한다 
    // 관찰자 등록 
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    // Observer(관찰자)를 제거한다 
    public void deleteObserver(Observer observer) {
        observers.remove(observer);
    }

    // Observer에 통지한다 
    public void notifyObservers() {
        // 확장 for 문
        for (Observer o: observers) {
            o.update(this); // 관찰자에게 통지
        }
    }

    // 수를 취득한다 
    public abstract int getNumber();

    // 수를 생성한다 
    public abstract void execute();
}
