package ch02.Q2;

import java.io.IOException;

// properties는 jdk에서 이미 제공되는 클래스 (어댑티)
// targetInterface
public interface FileIO {
    public void readFromFile(String filename) throws IOException;
    public void writeToFile(String filename) throws IOException;
    public void setValue(String key, String value);
    public String getValue(String key);
}
