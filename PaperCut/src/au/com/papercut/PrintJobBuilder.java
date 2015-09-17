package au.com.papercut;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import au.com.papercut.enums.PaperSize;

/**
 * Create print jobs
 * @author kevin
 *
 */
public class PrintJobBuilder {

  private final List<IPrint> jobList = new ArrayList<IPrint>();

  private BigDecimal cost = BigDecimal.ZERO;

  public void addJob(String line) {
    IPrint job = createJobFromStr(line);
    if (job != null)
      jobList.add(job);
  }

  /*
   * This method will create A4 and A5 print jobs based on input file
   * By default it create A4 job
   */
  private IPrint createJobFromStr(String line) {
    if (line == null || line.trim().length() < 1)
      return null;
    String[] strs = line.trim().replaceAll("\\s+", "").split(",");
    
    if (strs.length != 3) {
      return null;
    }
    
    PaperSize paperSize = PaperSize.A4;
    
    if(PaperSize.A4 == paperSize){
      return new A4PrintJob(strs[0], strs[1], strs[2]);
    } else {
      return null;
    }
  }

  public void printJobs() {
    if (jobList.size() > 0) {
      for (IPrint job : jobList) {
        cost = cost.add(job.print());
      }
    }
  }

  public BigDecimal getTotalCost() {
    return cost;
  }

}
