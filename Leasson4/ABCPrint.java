package Task1;

public class ABCPrint {

    private String next = "A";

    public void print(String s, String next) {
        synchronized (this) {

            while (!this.next.equals(s)) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.print(s);
            this.next = next;
            notifyAll();
        }
    }
}
