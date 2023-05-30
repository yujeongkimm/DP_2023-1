package ch07.practice;

import ch15.A2.pagemaker.HtmlWriter;

public class Main {
    public static void main(String args[]) {


        // textBuilder를 이용
        TextBuilder tb = new TextBuilder();
        Director d1 = new Director(tb); // 구체적인 빌더를 외에 주입함 (Dependency Injection)
        d1.construct();
        String result = tb.getTextResult();
        System.out.println(result);

        // HTMLBuilder를 이용
        HTMLBuilder hb = new HTMLBuilder();
        Director d2 = new Director(hb);
        d2.construct();
        String filename = hb.getHTMLResult();
        System.out.println("HTML 파일 " + filename + "이 작성되었습니다.");
    }
}
