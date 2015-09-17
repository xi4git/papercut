package au.com.papercut;

import java.math.BigDecimal;

import au.com.papercut.enums.PrintSide;
import au.com.papercut.enums.PrintStyle;

/**
 * Print and calculate cost
 * 
 * @author kevin
 *
 */
public class A4PrintJob implements IPrint {

  private int totalPageNumber;

  private int colourPageNumber;

  private int bwPageNumber;

  private PrintSide side;

  public A4PrintJob(String totalPageStr, String colorPageStr, String isDoubleSided) {
    validateParameters(totalPageStr, colorPageStr);

    if ("true".equalsIgnoreCase(isDoubleSided == null ? "" : isDoubleSided.toLowerCase())) {
      side = PrintSide.DOUBLE;
    } else {
      side = PrintSide.SINGLE;
    }

    bwPageNumber = totalPageNumber - colourPageNumber;
  }

  /*
   * Validate parameters to make sure print job is valid
   */
  private void validateParameters(String totalPageStr, String colorPageStr) {
    totalPageNumber = parseToInt(totalPageStr, "Total page number is invalid. ");

    colourPageNumber = parseToInt(colorPageStr, "Colour page number is invalid. ");
    if (colourPageNumber > totalPageNumber) {
      throw new IllegalArgumentException("Colour pages is more that total pages");
    }

  }

  private int parseToInt(String str, String errorMsg) {
    int number = 0;
    try {
      number = Integer.parseInt(str);
    } catch (Exception ex) {
      throw new IllegalArgumentException(errorMsg + ex.getMessage());
    }
    return number;
  }

  @Override
  public BigDecimal print() {
    if (side == null) {
      return BigDecimal.ZERO;
    }
    BigDecimal colourPageCost =
        A4PriceCalculator.calculate(side, PrintStyle.COLOR, colourPageNumber);
    BigDecimal bwPageCost = A4PriceCalculator.calculate(side, PrintStyle.BLACKWHITE, bwPageNumber);
    BigDecimal totalCost = colourPageCost.add(bwPageCost);

    Utils.print(colourPageNumber + " colour pages printed. cost $" + colourPageCost);
    Utils.print(bwPageNumber + " black and white pages printed. cost $" + bwPageCost);
    Utils.print("The job costs $" + totalCost + "\n");

    return totalCost;
  }

}
