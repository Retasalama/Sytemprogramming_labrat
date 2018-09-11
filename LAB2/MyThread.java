import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class MyThread extends Thread {

  @Override
  public void run(){
    try {
      System.out.println("Thread started");
      while (true) {
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        String dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(ts);
        System.out.println("Tiisu, we want more! " + dateTime);
        sleep(5000);
      }
    }
    catch (Exception e) {
      System.out.println("Thread interrupted");
    }
  }
}
