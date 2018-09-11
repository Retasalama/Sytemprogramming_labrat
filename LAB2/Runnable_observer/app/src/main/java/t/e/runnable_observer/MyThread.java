package t.e.runnable_observer;

import java.util.Observable;

import static java.lang.Thread.sleep;

public class MyThread extends Observable implements Runnable {
    @Override
    public void run() {

        try {
            System.out.println("Thread started");
            while (true) {
                String response = "Tiisu, we want more!";
                setChanged();
                notifyObservers(response);
                sleep(5000);
            }
        }
        catch (Exception e) {
            String interuuptMsg = "Tread interrupted";
        }
    }
}
