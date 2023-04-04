package hw.ch02;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        System.out.println("20201111 김유정");
        FileIO f = new FileProperties();    //어댑터 생성
        try {
            f.readFromFile("file.txt");
            f.setValue("Year", "2023");
            f.setValue("bornYear", "2000");
            f.setValue("StudentId", "20201111");
            f.setValue("Name", "KimYuJeong");
            f.setValue("Location", "Seoul");
            f.writeToFile("KimYuJeong.txt");
            System.out.println("KimYuJeong.txt is created.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
