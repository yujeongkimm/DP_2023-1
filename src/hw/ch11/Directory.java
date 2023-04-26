package hw.ch11;

import java.util.ArrayList;
import java.util.List;

public class Directory extends Entry {
    private String name;
    private List<Entry> directory = new ArrayList<>();
    private String date;    //
    private String author;  //

    public Directory(String name) {
        this.name = name;
    }

    // 생성자 확장
    public Directory(String name, String date, String author) {
        this.name = name;
        this.date = date;
        this.author = author;
    }

    // 추가: 자기 아래에 존재하는 모든 파일의 개수
    @Override
    public int getCount() {
        int size = 0;
        for (Entry entry : directory) {
            size+=entry.getCount();
        }
        return size;
    }

    // 추가
    @Override
    public String getDate() {
        return date;
    }

    // 추가
    @Override 
    public String getAuthor() {
        return author;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        int size = 0;
        for (Entry entry: directory) {
            size += entry.getSize();
        }
        return size;
    }

    @Override
    protected void printList(String prefix) {
        System.out.println(prefix + "/" + this);
        for (Entry entry: directory) {
            entry.printList(prefix + "/" + name);
        }
    }

    // 디렉터리 엔트리를 디렉터리에 추가한다
    public Entry add(Entry entry) {
        directory.add(entry);
        return this;
    }
}
