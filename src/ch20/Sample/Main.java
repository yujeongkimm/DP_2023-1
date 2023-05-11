package ch20.Sample;

public class Main {
    public static void main(String[] args) {    // 명령행 인자

        BigChar bc = new BigChar('1');
        bc.print();

        if (args.length == 0) {
            System.out.println("Usage: java Main digits");
            System.out.println("Example: java Main 1212123");
            System.exit(0);
        }

        BigString bs = new BigString(args[0]);
        bs.print();
    }
}
