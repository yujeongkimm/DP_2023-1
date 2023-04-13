package ch11.practice;

import java.util.ArrayList;
import java.util.List;

// composite(그릇)을 나타냄
public class Directory extends Entry {
    private String name;
    private List<Entry> directory = new ArrayList<>();  // Entry: 부모 타입

    // 자기 내용물 리스트를 관리하는 변수
    public Directory(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    // 자기 내용물들의 getSize()를 호출함
    public int getSize() {
        int size = 0;
        // 확장 for 문
        for (Entry entry: directory) {  // 자기의 하위 요소 개수 출력
            size += entry.getSize(); // 재귀적 호출
        }
        return size;
    }

    @Override
    protected void printList(String prefix) {
        System.out.println(prefix + "/" + this);
        
        for (Entry entry: directory) {
            entry.printList(prefix + "/" + name);   // 재귀적 호출
        }
    }

    // 디렉터리 엔트리를 디렉터리에 추가한다
    public Entry add(Entry entry) {
        directory.add(entry);
        return this;
    }
}
