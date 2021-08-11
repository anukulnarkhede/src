import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class daily_range{

  public static void main(String[] args) throws FileNotFoundException {

    String path = "";
    String Line = "";
    float High = 0;
    float Low = 0;
    float daily_range = 0;

    PrintWriter printWriter = new PrintWriter(new File("/Users/apple/Desktop/src/daily_range.csv"));
    StringBuilder stringBuilder = new StringBuilder();

    System.out.println("Enter the CSV File Path: ");
    Scanner scanner = new Scanner(System.in);
    path = scanner.nextLine();

    try {
      BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
      try {

        while((Line = bufferedReader.readLine()) != null){

          String[] values = Line.split(",");

          if (Objects.equals(values[3], "HIGH") && Objects.equals(values[4], "LOW")){
            bufferedReader.skip(0);
            stringBuilder.append("SYMBOL");
            stringBuilder.append(",");
            stringBuilder.append("HIGH");
            stringBuilder.append(",");
            stringBuilder.append("LOW");
            stringBuilder.append(",");
            stringBuilder.append("DAILY RANGE");
            stringBuilder.append("\r\n");
          }else{
            High = Float.parseFloat(values[3]);
            Low = Float.parseFloat(values[4]);
            daily_range = High - Low;
            stringBuilder.append(values[0]);
            stringBuilder.append(",");
            stringBuilder.append(values[3]);
            stringBuilder.append(",");
            stringBuilder.append(values[4]);
            stringBuilder.append(",");
            stringBuilder.append(daily_range);
            stringBuilder.append("\r\n");

          }

        }
        printWriter.write(stringBuilder.toString());
        printWriter.close();


      } catch (IOException e) {
        e.printStackTrace();
      }


    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

  }
}
