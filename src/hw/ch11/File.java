package hw.ch11;

public class File extends Entry {
    private String name;
    private int size;
    private String date;    //
    private String author;  //

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    // 추가: 생성자 확장
    public File(String name, String date, int size, String author) {
        this.name = name;
        this.date = date;
        this.size = size;
        this.author = author;
    }

    // 추가: 파일이므로 1 반환
    @Override
    public int getCount() {
        return 1;
    }

    // 추가 
    @Override
    public String getDate() {
        return date;
    }

    // 추가s
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
        return size;
    }

    @Override
    protected void printList(String prefix) {
        System.out.println(prefix + "/" + this);
    }
}
