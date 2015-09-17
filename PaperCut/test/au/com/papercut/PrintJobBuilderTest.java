package au.com.papercut;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

public class PrintJobBuilderTest {

  @Test
  public void testNoJob() {
    PrintJobBuilder builder = new PrintJobBuilder();
    assertTrue(BigDecimal.ZERO.compareTo(builder.getTotalCost()) == 0);
  }
  
  @Test
  public void testAddJob(){
    PrintJobBuilder builder = new PrintJobBuilder();
    builder.addJob("");
    builder.printJobs();
    assertTrue(BigDecimal.ZERO.compareTo(builder.getTotalCost()) == 0);
    
    PrintJobBuilder builder2 = new PrintJobBuilder();
    builder2.addJob(null);
    builder2.printJobs();
    assertTrue(BigDecimal.ZERO.compareTo(builder2.getTotalCost()) == 0);
    
    PrintJobBuilder builder3 = new PrintJobBuilder();
    builder3.addJob("lasjfllasjkdfklsdf");
    builder3.printJobs();
    assertTrue(BigDecimal.ZERO.compareTo(builder3.getTotalCost()) == 0);
  }
  
  @Test
  public void testPrint(){
    PrintJobBuilder builder = new PrintJobBuilder();
    builder.addJob("25, 10, false");
    builder.printJobs();
    assertTrue( (new BigDecimal("4.75")).compareTo(builder.getTotalCost()) == 0);
  }
  
  @Test
  public void testPrintMoreJobs(){
    PrintJobBuilder builder = new PrintJobBuilder();
    builder.addJob("55, 13, true");
    builder.addJob("1, 0, false");
    builder.printJobs();
    assertTrue( (new BigDecimal("6.95")).compareTo(builder.getTotalCost()) == 0);
  }
}
