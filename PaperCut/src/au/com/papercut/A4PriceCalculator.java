package au.com.papercut;

import java.math.BigDecimal;

import au.com.papercut.enums.PrintSide;
import au.com.papercut.enums.PrintStyle;

public class A4PriceCalculator{

  public static BigDecimal calculate(PrintSide side, PrintStyle color, int pageNumber) {
    
    BigDecimal cost = BigDecimal.ZERO;
    if(side == PrintSide.DOUBLE){
      if(PrintStyle.BLACKWHITE == color){
        cost = new BigDecimal("0.1");
      } else {
        cost = new BigDecimal("0.2");
      }
    } else {
      if(PrintStyle.BLACKWHITE == color){
        cost = new BigDecimal("0.15");
      } else {
        cost = new BigDecimal("0.25");
      }
    }
    
    return cost.multiply(new BigDecimal(pageNumber));
  }

}
