
public class MyThread extends Thread {

  @Override
  public void run(){
    try {
      System.out.println("Thread started");
      while (true) {
        System.out.println("Tiisu, we want more!");
        sleep(5000);
      }
    }
    catch (Exception e) {
      System.out.println("Thread interrupted");
    }
  }
}
