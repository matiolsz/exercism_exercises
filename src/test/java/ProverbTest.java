
import org.example.Proverb;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
public class ProverbTest {
    @Test
    public void zeroWordsAreGiven() {
        String[] words  = new String[0];
        Assert.assertEquals(new Proverb(words).recite(),(""));
    }
    @Test
    public void singlePieceOfProverb() {
        String[] words  = new String[]{"nail"};
        Assert.assertEquals(new Proverb(words).recite()
                    ,("And all for the want of a nail."));
        }
    @Test
    public void twoPiecesOfProverb() {
        String[] words  = new String[]{"nail", "shoe"};
        Assert.assertEquals(new Proverb(words).recite()
                ,(
                        "For want of a nail the shoe was lost.\n" +
                                "And all for the want of a nail."));
    }
    @Test
    public void shortChainOfConsequences() {
        String[] words  = new String[]{"nail", "shoe", "horse"};
        Assert.assertEquals(new Proverb(words).recite()
                ,(
                        "For want of a nail the shoe was lost.\n" +
                                "For want of a shoe the horse was lost.\n" +
                                "And all for the want of a nail."));
    }
    @Test
    public void fullProverb() {
        String[] words  = new String[]{"nail", "shoe", "horse", "rider", "message", "battle", "kingdom"};
        Assert.assertEquals(new Proverb(words).recite()
                ,(
                        "For want of a nail the shoe was lost.\n" +
                                "For want of a shoe the horse was lost.\n" +
                                "For want of a horse the rider was lost.\n" +
                                "For want of a rider the message was lost.\n" +
                                "For want of a message the battle was lost.\n" +
                                "For want of a battle the kingdom was lost.\n" +
                                "And all for the want of a nail."));
    }
    @Test
    public void fourPiecesModernizedProverb() {
        String[] words  = new String[]{"pin", "gun", "soldier", "battle"};
        Assert.assertEquals(new Proverb(words).recite()
                ,(
                        "For want of a pin the gun was lost.\n" +
                                "For want of a gun the soldier was lost.\n" +
                                "For want of a soldier the battle was lost.\n" +
                                "And all for the want of a pin."));
    }
}
