import java.lang.*;

public class ExampleThread extends Thread {

  private int progressCounter = 0;
  private int progress = 0;
  private int threadIdentifier = 0;
  public ExampleThread(int identifier){
    this.threadIdentifier = identifier;
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
          notifier.printProgress(progress, threadIdentifier);
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
