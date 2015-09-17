package au.com.papercut;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

public class PrintJobTest {
  
  @Test(expected=IllegalArgumentException.class)
  public void testInvalidConstructor1(){
    A4PrintJob job = new A4PrintJob("aa", "bb", "false");
    job.print();
  }
  
  @Test(expected=IllegalArgumentException.class)
  public void testInvalidConstructor2(){
    A4PrintJob job = new A4PrintJob("10", "20", "false");
    job.print();
  }

  @Test
  public void testConstructor(){
    A4PrintJob job = new A4PrintJob("20", "10", "false");
    assertTrue(new BigDecimal("4").compareTo(job.print())==0);
  }
  
  @Test
  public void testPrint(){
    A4PrintJob job = new A4PrintJob("30", "7", "true");
    assertTrue(new BigDecimal("3.7").compareTo(job.print())==0);
  }
}
