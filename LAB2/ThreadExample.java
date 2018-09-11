import java.util.Scanner;

public class ThreadExample {

  public static void main(String[] args){
    MyThread thread = new MyThread();
    boolean isInterrupted = false;
    Scanner scanner = new Scanner(System.in);
    String command = "";

    while(!command.equals("QUIT")) {
      System.out.println("Master, give your command: ");
      command = scanner.nextLine();

      if(command.equals("START") && !thread.isAlive()) {
        if (isInterrupted) {
          thread = new MyThread();
        }

        System.out.println("Starting thread");
        thread.start();
      }
      else if(command.equals("STOP") && thread.isAlive()) {
        thread.interrupt();
        isInterrupted = true;
      }
    }
    if(thread.isAlive()) {
      thread.interrupt();
      isInterrupted = true;
    }
  }
}
