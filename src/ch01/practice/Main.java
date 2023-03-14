package ch01.practice;

import java.util.Iterator;

public class Main{
    
    public static void main(String[] args) {
        //책 생성
        Book b1 = new Book("book1");
        Book b2 = new Book("book2");
        // System.out.println(b1.getName());

        //책꽂이 생성
        BookShelf bs1 = new BookShelf(10);

        bs1.appendBook(b1);
        // Book result1 = bs1.getBookAt(0);
        // System.out.println(result1.getName());

        bs1.appendBook(b2);
        // Book result2 = bs1.getBookAt(1);
        // System.out.println(result2.getName());

        //for 루프를 이용해서 책이름 출력 
        for(int i = 0; i < bs1.getLength() ; i++) {
            System.out.println(bs1.getBookAt(i).getName());
        }

        //확장 for 루프를 이용해서 책이름 출력하기 
        for( Book b : bs1 ) {
            System.out.println(b.getName());
        }

        //iterator를 이용해서 책이름 출력하기
        //iterator 얻기
        System.out.println("<book list using iterator>");
        // BookShelfIterator iterator = bs1.iterator();
        Iterator<Book> iterator = bs1.iterator();
        //iterator 이용해서 원소 얻어오기 
        while( iterator.hasNext() ) {
            Book b = iterator.next();
            System.out.println(b.getName());
        }
    }
    
}