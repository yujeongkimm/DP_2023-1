package hw.ch03;

public class KimYuJeongDisplay extends AbstractDisplay {
    private String name;  
    private String studentId;
    private int grade;      

    // 생성자 
    public KimYuJeongDisplay(String name, String studentId, int grade) {
        this.name = name;
        this.studentId = studentId;
        this.grade = grade;
    }

    @Override
    public void open() {
        System.out.println("====================");
        System.out.println("덕성여대 소프트웨어학과");
    }

    @Override
    public void print() {
        System.out.println("학번 " + this.studentId + " / " + this.grade + "학년 / " + this.name );
    }

    @Override
    public void close() {
        System.out.println("템플릿 메소드 패턴 숙제입니다.");
        System.out.println("====================");
    }

}
