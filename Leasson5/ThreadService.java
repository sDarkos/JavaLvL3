import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
    Да простит меня сенсей за этот класс. Не хотелось перенагружать конструктор Car кучей объектов или обращятся к ним
    через Main. Буду рад выслушать замечания по этому поводу, потому что не нашел решения как сделать лучше.
*/

public class ThreadService {
    private static final int CAR_COUNT = Main.CARS_COUNT;
    public static CyclicBarrier cbr = new CyclicBarrier(CAR_COUNT);
    public static CountDownLatch cdlStart = new CountDownLatch(CAR_COUNT);
    public static CountDownLatch cdlFinish = new CountDownLatch(CAR_COUNT);
    public static Semaphore tunnelSemaphore = new Semaphore(CAR_COUNT / 2);
    public static Lock lock = new ReentrantLock();

    public static void CDLAwaitStart(){
        CDLAwait(cdlStart);
    }

    public static void CDLAwaitFinish(){
        CDLAwait(cdlFinish);
    }

    private static void CDLAwait(CountDownLatch cdl){
        try {
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
