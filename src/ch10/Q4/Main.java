package ch10.Q4;

import java.util.*;

class Main {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("D", "B", "C", "E", "A");

        // 사전순으로 작은 순서
        // 1. 익명의 내부 클래스를 만드는 방법
        list.sort( new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return a.compareTo(b);
            }
        });
        System.out.println(list);

        // 2. 람다식을 이용함
        // Functional interface: 메소드가 한 개만 선언되어 있는 인터페이스
        // Functional Interface 들어갈 자리에 람다식을 넣을 수 있다.
        // 인자 -> 메소드 바디
        // Comparator 인터페이스 functional 인터페이스이다. 
        list.sort((a,b) -> a.compareTo(b)); // compare 메소드 바디를 제공한 것과 같다.

        // 3. 
        // list: 전략을 가지는 컨텍스트
        // comparator: 전략에 해당됨
        list.sort( new ComparatorAscending() );
        System.out.println(list);

        // 4. 사전순으로 큰 순서 
        list.sort( new ComparatorDescending() );
        System.out.println(list);
    }
}
