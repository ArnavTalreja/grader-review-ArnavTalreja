import static org.junit.Assert.*;
import org.junit.*;
import java.util.Arrays;
import java.util.List;

class numerals implements StringChecker {
  public boolean checkString(String s) {
    if (s.equalsIgnoreCase("one") || s.equalsIgnoreCase("nine") || s.equalsIgnoreCase("nineteen")){
      return true;
    }
    else{
      return false;
    }
  }
}

public class TestListExamples {
  @Test(timeout = 500)
  public void testFilter() {
    List<String> list = Arrays.asList("one","thrity","two","fifteen","fifty","nine","nineteen","nine","one","one","one");
    List<String> expected = Arrays.asList("one","nine","nineteen","nine","one","one","one");
    List<String> actual = ListExamples.filter(list,new numerals());
    assertEquals(expected, actual);
  }
  
  @Test(timeout = 500)
  public void testMergeRightEnd() {
    List<String> left = Arrays.asList("a", "b", "c");
    List<String> right = Arrays.asList("a", "d");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("a", "a", "b", "c", "d");
    assertEquals(expected, merged);
  }
}
