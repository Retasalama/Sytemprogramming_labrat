
import java.util.Scanner;

public class DataFetchExample implements NetworkLoaderThread.ResultInterface {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    String URL = "";
    System.out.println("Give URL: ");
    URL = scanner.nextLine();
    if (!URL.equals("")) {
      NetworkLoaderThread networkLoaderThread = new NetworkLoaderThread(URL);
      DataFetchExample dfe = new DataFetchExample();
      networkLoaderThread.setListener(dfe);
      networkLoaderThread.start();
    }
  }

  @Override
  public void threadProgress(String data){
    System.out.println(data);
  }
}
