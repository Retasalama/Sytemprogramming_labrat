import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

public class ThreadsAndObservers implements ExampleInterface {

  private ArrayList<ExampleThread> threads = new ArrayList<ExampleThread>();
  private ExampleThread thread;
  private Scanner scanner;
  private String command = "";

  public static void main(String[] args) {
    ThreadsAndObservers tao = new ThreadsAndObservers();
    tao.startProgram();

  }

  public void startProgram() {
    scanner = new Scanner(System.in);
    System.out.println("START = Start a new thread, QUIT = quit the program");
    while(!command.equals("QUIT")){
      command = scanner.nextLine();
      if(command.equals("START")){
        thread = new ExampleThread(threads.size() + 1);
        threads.add(thread);
        thread.setNotifier(this);
        thread.start();
      }
    }
    for(ExampleThread thread : threads){
      thread.interrupt();
    }
  }

  @Override
  public void printProgress(int progress, int threadCounter) {
    Timestamp ts = new Timestamp(System.currentTimeMillis());
    String dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(ts);
    System.out.println(dateTime + " Thread " + threadCounter +
                  " progress = " + progress + "%");
  }

}
