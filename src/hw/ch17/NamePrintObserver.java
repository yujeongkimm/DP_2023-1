package hw.ch17;

public class NamePrintObserver implements Observer {

    @Override
    public void update(NumberGenerator generator) {
        int num = generator.getNumber();
        for (int i=0; i<num; i++) {
            System.out.print("김유정" + " ");
        }
        System.out.println();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
    }
}