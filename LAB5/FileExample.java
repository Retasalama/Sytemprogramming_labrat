
import java.nio.charset.Charset;
import java.util.*;
import java.io.PrintWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.io.File;
import java.io.FileOutputStream;

public class FileExample {

  public static void main(String[] args) {

    new FileExample().fileHandler();

  }

  public void fileHandler(){

    Scanner scanner = new Scanner(System.in);
    System.out.println("Reading file...");

    try{
      List<String> lines = Files.readAllLines(Paths.get("myFile.txt"), Charset.defaultCharset());
      for(String line : lines) {
        System.out.println(line);
      }

    } catch (Exception e) {
      System.out.println("File not found or other error");

    }

    System.out.println("Please enter new text: ");
    String newTextToFile = scanner.nextLine();

    try{
      PrintWriter writer = new PrintWriter(new FileOutputStream(new File("myFile.txt"), true));
      writer.append(newTextToFile);
      writer.close();

    } catch (Exception e) {
      System.out.println("Couldn´t write to file");

    }

  }



}
