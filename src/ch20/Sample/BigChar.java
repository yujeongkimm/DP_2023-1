package ch20.Sample;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BigChar {
    // 문자의 이름 
    private char charname;
    // 큰 문자를 표현하는 문자열('#' '.' '\n'으로 이루어진 열)
    private String fontdata;    // 파일의 내용을 담고 있음

    // 생성자 
    public BigChar(char charname) { // '1'
        this.charname = charname;
        try {
            String filename = "big" + charname + ".txt";    // big1.txt
            
            StringBuilder sb = new StringBuilder();
            
            // 확장 for문 , 오른쪽이 collection (List<String>)
            for (String line: Files.readAllLines(Path.of(filename))) {
                sb.append(line);
                sb.append("\n");
            }
            
            this.fontdata = sb.toString();  // 저장
        } catch (IOException e) {
            this.fontdata = charname + "?";
        }
    }

    // 큰 문자를 표시한다
    public void print() {
        System.out.print(fontdata);
    }
}
