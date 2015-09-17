package au.com.papercut;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;

import au.com.papercut.enums.PrintSide;
import au.com.papercut.enums.PrintStyle;

public class PriceCaulatorTest {

  @Test
  public void testCalcu(){
    BigDecimal doubleBWCost = A4PriceCalculator.calculate(PrintSide.DOUBLE, PrintStyle.BLACKWHITE, 3);
    assertTrue(doubleBWCost.compareTo(new BigDecimal("0.3"))==0);
    
    BigDecimal doubleColourCost = A4PriceCalculator.calculate(PrintSide.DOUBLE, PrintStyle.COLOR, 4);
    assertTrue(doubleColourCost.compareTo(new BigDecimal("0.8"))==0);
    
    BigDecimal singleBWCost = A4PriceCalculator.calculate(PrintSide.SINGLE, PrintStyle.BLACKWHITE, 3);
    assertTrue(singleBWCost.compareTo(new BigDecimal("0.45"))==0);
    
    BigDecimal singleColourCost = A4PriceCalculator.calculate(PrintSide.SINGLE, PrintStyle.COLOR, 4);
    assertTrue(singleColourCost.compareTo(new BigDecimal("1"))==0);
  }
}
