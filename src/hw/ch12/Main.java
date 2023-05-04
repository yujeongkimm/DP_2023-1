package hw.ch12;

public class Main {
    public static void main(String args[]) {
        System.out.println("학번: 20201111, 이름: 김유정");

        MultiStringDisplay md = new MultiStringDisplay();
        md.add("학번: 20201111"); 
        md.add("이름: 김유정"); 
        md.add("핸드폰 번호: 010-3101-5617"); 

        Display b4 = 
                    new MultiSideBorder(
                        new UpDownBorder(
                            new FullBorder(
                                new SideBorder(md, '%'))
                        , '='), 
                    '*', 3);
        b4.show();
    }
}
