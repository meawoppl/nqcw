package nqcw;


import org.junit.Test;

public class EntryPointTest {
  @Test
  public void testEntryPointSmoke(){
    EntryPoint.main(new String[]{});
    EntryPoint.main(new String[]{"-t"});
    EntryPoint.main(new String[]{"4"});
    EntryPoint.main(new String[]{"4", "-t"});
  }
}