package au.com.papercut;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;

/*
 * Read print jobs from file and pass to PrintJobBuilder.
 * Now only support A4 page, you can create a
 * A5PrintJob and create it's own price calculator to support A5 page.
 */
public class Entry {

  public static void main(String[] args) {
    String path = "src/resource/printjobs.csv";

    if (args != null && args.length == 1) {
      path = args[0];
    }

    File file = new File(path);

    if (file.isFile() && file.exists()) {
      readJobs(path);
    } else {
      throw new IllegalArgumentException("Not found input file.");
    }

  }

  public static BigDecimal readJobs(String path) {
    try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
      PrintJobBuilder builder = new PrintJobBuilder();
      BigDecimal totalCost = BigDecimal.ZERO;
      String line = "";
      while ((line = reader.readLine()) != null) {
        builder.addJob(line);
      }
      builder.printJobs();
      totalCost = totalCost.add(builder.getTotalCost());

      Utils.print("Total cost for all jobs is $" + totalCost);
      return totalCost;
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return BigDecimal.ZERO;
  }

}
