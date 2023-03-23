package ch03.practice;

public class Main {
    public static void main(String args[]) {
        AbstractDisplay x;

        x = new CharDisplay('a');   // 타입은 부모타입으로 선언하는게 좋다 
        x.open();
        x.print();
        x.close();

        x.display();

        //AbstractDisplay s = new StringDisplay("김유정");
        
        // 부모타입으로 선언하면 자식 다 가리킬 수 있음
        x = new StringDisplay("김유정");

        x.open();
        x.print();
        x.close();

        x.display();
    }
}
