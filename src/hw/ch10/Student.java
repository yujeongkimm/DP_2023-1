package hw.ch10;

public class Student implements Comparable<Student>{
    private String name;
    private String id;
    private int height;

    public Student(String name, String id, int height) {
        this.name = name;
        this.id = id;
        this.height = height;
    }

    @Override
    public int compareTo(Student s) {
        if(height < s.height) {
            return -1;
        } else if (height == s.height) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public String toString() {
        return "이름: " + name + ", 학번: " + id + ", 키: " + height;
    }
    
}
