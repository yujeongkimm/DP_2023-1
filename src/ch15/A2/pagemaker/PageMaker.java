package ch15.A2.pagemaker;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PageMaker {
    private PageMaker() {
    }

    public static void makeWelcomePage(String mailaddr, String filename) {
        try {
            Properties mailprop = Database.getProperties("maildata");
            
            String username = mailprop.getProperty(mailaddr);
            
            HtmlWriter writer = new HtmlWriter(new FileWriter(filename));
            
            writer.title(username + "'s web page");
            writer.paragraph("Welcome to " + username + "'s web page!");
            writer.paragraph("Nice to meet you!");
            writer.mailto(mailaddr, username);
            
            writer.close();
            
            System.out.println(filename + " is created for " + mailaddr + " (" + username + ")");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 추가 
     * @param filename
     */
    public static void makeLinkPage(String filename) {
        try {
            HtmlWriter writer = new HtmlWriter(new FileWriter(filename));
            
            writer.title("Link page");
            
            Properties mailprop = Database.getProperties("maildata");
            
            for (String mailaddr: mailprop.stringPropertyNames()) {
                // txt 파일의 라인 하나씩 꺼내옴 
                // mailaddr -> txt파일에서 = 의 왼쪽 부분 
                String username = mailprop.getProperty(mailaddr, "(unknown)");
               
                writer.mailto(mailaddr, username);
            }
            
            writer.close();
            
            System.out.println(filename + " is created.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
