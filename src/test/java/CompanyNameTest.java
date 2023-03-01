import org.example.CompanyName;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class CompanyNameTest {

@Test
    public void testCase1(){
    CompanyName companyName = new CompanyName();
    String[] items = {"coffee","donuts","time","toffee"};
    Assert.assertEquals(6L, companyName.distinctNames(items));
     }
}
