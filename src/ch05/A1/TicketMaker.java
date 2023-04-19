package ch05.A1;

public class TicketMaker {
    private int ticket = 1000;
    // private static
    private static TicketMaker singleton = new TicketMaker();

    // 생성자 private 
    private TicketMaker() {
    }

    // getInstance static
    public static TicketMaker getInstance() {
        return singleton;
    }

    public synchronized int getNextTicketNumber() {
        return ticket++;
    }
}
