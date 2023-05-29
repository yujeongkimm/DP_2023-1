package ch15.Sample;

import ch15.Sample.pagemaker.PageMaker;

public class Main {
    public static void main(String[] args) {
        PageMaker.makeWelcomePage("hyuki@example.com", "welcome.html");

        PageMaker.makeWelcomePage("20202222@duksung.ac.kr", "welcome2.html");
    }
}
