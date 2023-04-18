package ch11.practice;

public class Main {
    public static void main(String args[]) {
        // Entry f1 = new File("vi", 100);
        // System.out.println(f1.getName());
        // System.out.println(f1.getSize());
        // System.out.println(f1);
        
        ///Users/kimyujeong/2023_DP
        Directory root = new Directory("Users");

        Directory bin = new Directory("kimyujeong");
        Directory tmp = new Directory("2023_DP");
        //Directory usr = new Directory("usr");

        //((Directory)root).add(bin);
        root.add(bin);
        root.add(tmp);
        //root.add(usr);

        bin.add(new File("vi", 100));
        bin.add(new File("latex", 200));

        System.out.println(root.getSize());
        
        root.printList();
        // root.printList(""); // 둘 다 같다 
    }
}
