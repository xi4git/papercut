package au.com.papercut;

import java.math.BigDecimal;

/**
 * The interface is for all print jobs
 * @author kevin
 **/
public interface IPrint {
  /*
   * The print method will do the print job and calculate price. Combine these two methods into one
   * because nothing to do with the print job.
   */
  public BigDecimal print();

}
