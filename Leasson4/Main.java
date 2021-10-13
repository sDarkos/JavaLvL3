package Task1;

public class Main {
    private static final int count = 5;

    public static void main(String[] args) {

        ABCPrint abcPrint = new ABCPrint();

        for (int i = 0; i < count; i++) {
            new Thread(() -> abcPrint.print("A", "B")).start();
            new Thread(() -> abcPrint.print("B", "C")).start();
            new Thread(() -> abcPrint.print("C", "A")).start();
        }
    }
}
