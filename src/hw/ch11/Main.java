package hw.ch11;

public class Main {
    public static void main(String args[]) {
        System.out.println("학번: 20201111, 이름: 김유정");

        Directory rootDir = new Directory("MyDocuments", "20230401", "KimYuJeong");
        rootDir.add(new File("김유정0.doc", "20230501", 1000, "KimYuJeong"));
        
        Directory myDataDir = new Directory("MyData", "20230401", "KimYuJeong");
        myDataDir.add(new File("김유정1.doc", "20230501", 2000, "KimYuJeong"));
        myDataDir.add(new File("김유정2.java", "20230501", 3000, "KimYuJeong"));
        
        Directory myPicDir = new Directory("MyPictures", "20230401", "KimYuJeong");
        myPicDir.add(new File("김유정3.gif", "20230601", 4000, "KimYuJeong"));
        myPicDir.add(new File("김유정4.jpg", "20230601", 5000, "KimYuJeong"));
        myPicDir.add(new File("김유정5.png", "20230601", 6000, "KimYuJeong"));

        myDataDir.add(myPicDir);
        
        rootDir.add(myDataDir);

        rootDir.printList();
    }
}
