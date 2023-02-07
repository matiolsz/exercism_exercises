import org.example.ResistorColorDuo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;

public class ResistorColorDuoTest {
    private ResistorColorDuo resistorColorDuo;
    @Before
    public void setup() {
        resistorColorDuo = new ResistorColorDuo();
    }
    @Test
    public void testBrownAndBlack() {
        Assert.assertEquals(
                resistorColorDuo.value(new String[]{"brown", "black"})
       ,10);
    }
    @Test
    public void testBlueAndGrey() {
        Assert.assertEquals(
                resistorColorDuo.value(new String[]{ "blue", "grey" })
       ,68);
    }
    
    @Test
    public void testYellowAndViolet() {
        Assert.assertEquals(resistorColorDuo.value(
                new String[]{ "yellow", "violet" })
       ,47);
    }
    
    @Test
    public void testOrangeAndOrange() {
        Assert.assertEquals(
                resistorColorDuo.value(new String[]{ "orange", "orange" })
       ,33);
    }
    
    @Test
    public void testIgnoreAdditionalColors() {
        Assert.assertEquals(
                resistorColorDuo.value(new String[]{ "green", "brown", "orange" })
       ,51);
    }
}