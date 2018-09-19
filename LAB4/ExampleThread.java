import java.lang.*;

public class ExampleThread extends Thread {

  private int progressCounter = 0;
  private int progress = 0;
  private int threadCounter = 0;
  public ExampleThread(int counter){
    this.threadCounter = counter;
  }
  protected ExampleInterface notifier = null;
  public void setNotifier(ExampleInterface notifier) {
    this.notifier = notifier;
  }

  public void run(){
    while(progressCounter < 10){
      try{
        sleep(3000);
        progress = progress + 10;
        if(notifier != null){
          notifier.printProgress(progress, threadCounter);
        }
        progressCounter++;
      }
      catch (Exception e) {
        System.out.println("Keskeytys");
        return;
      }
    }
  }
}
