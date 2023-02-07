import java.util.HashSet;
import java.util.Set;
import java.util.regex.MatchResult;

import org.example.Robot;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class RobotTest {
    private static final String EXPECTED_ROBOT_NAME_PATTERN = "[A-Z]{2}\\d{3}";
    private Robot robot;
    @Before
    public void setUp() {
        robot = new Robot();
    }
    @Test
    public void hasName() {
        assertIsValidName(robot.getName());
    }

    @Test
    public void differentRobotsHaveDifferentNames() {
        Assert.assertNotEquals(robot.getName(), new Robot().getName());
    }
    @Test
    public void resetName() {
        final String name = robot.getName();
        robot.reset();
        final String name2 = robot.getName();
        Assert.assertNotEquals(name,name2);
        assertIsValidName(name2);
    }

    @Test
    public void robotNamesAreUnique() {
        Set<String> robotNames = new HashSet<>();
        int sampleSize = 5000;
        for (int i = 0; i < sampleSize; i++) {
            robotNames.add(new Robot().getName());
        }
        Assert.assertEquals(robotNames.size(), sampleSize);
    }

    public void assertIsValidName(String name) {
        Assert.assertTrue(name.matches(EXPECTED_ROBOT_NAME_PATTERN));
    }
}
