package hw.ch10;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String args[]) {
        System.out.println("학번: 20201111, 이름: 김유정");

        List<Student> list = new ArrayList<>();
        list.add(new Student("최승훈", "20201234", 175));
        list.add(new Student("김유정", "20201111", 167));
        list.add(new Student("김혜정", "20209876", 156));
        list.add(new Student("이윤서", "20207777", 166));
        list.add(new Student("김민지", "20206666", 165));

        // 오름차순 정렬
        System.out.println("** (1) 정렬 결과 (오름차순)");
        list.sort(new ComparatorAscending());
        for(Student s : list) {
            System.out.println(s);
        }

        // 내림차순 정렬
        System.out.println("** (2) 정렬 결과 (내림차순)");
        list.sort(new ComparatorDescending());
        for(Student s : list) {
            System.out.println(s);
        }
    }
}
