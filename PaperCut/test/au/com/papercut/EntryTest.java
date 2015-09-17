package au.com.papercut;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

public class EntryTest {

  @Test
  public void testReadJobs() {
    String path = "test/resource/testjobs.csv";
    assertTrue((new BigDecimal("64.1")).compareTo(Entry.readJobs(path)) == 0);
  }
  
  @Test(expected=IllegalArgumentException.class)
  public void testMain(){
    String[] path = {"fake.csv"};
    Entry.main(path);
  }

}
