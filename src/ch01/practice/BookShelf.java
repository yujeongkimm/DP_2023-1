package ch01.practice;

import java.util.Iterator;

public class BookShelf implements Iterable<Book>{   //< >안은 원소 타입 
    private Book[] books;   // 배열 선언 
    private int last = 0; // 책의 마지막 위치, 갯수

    public BookShelf(int maxsize) {
        this.books = new Book[maxsize];
    }

    // 책을 꽂는 메소드
    public void appendBook(Book book) {
        this.books[last] = book;
        last++;
    }

    // 책을 꺼내오는 메소드
    public Book getBookAt(int index) {
        return books[index];
    }

    // 책 개수를 리턴하는 메소드
    public int getLength() {
        return last;
    }

    // //iterator 반환하는 메소드
    // public BookShelfIterator iterator()
    @Override
    public Iterator<Book> iterator() {
        return new BookShelfIterator(this); //현재 책꽃이와 iterator가 연결됨 
    }
}