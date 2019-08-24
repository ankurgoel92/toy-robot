package app.toyrobot.service.opertaion;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import app.toyrobot.model.Facing;
import app.toyrobot.model.Robot;
import app.toyrobot.service.operation.impl.RightOperation;

@RunWith(SpringRunner.class)
public class RightOperationTest {

    private RightOperation rightOperation;

    @BeforeEach
    public void setUp() {
        rightOperation = new RightOperation();
    }

    @Test
    public void testExecuteFromNorth() {
        Robot robot = new Robot(0, 0, Facing.NORTH);

        Robot rotatedRobot = rightOperation.execute(robot);

        assertThat(rotatedRobot, is(notNullValue()));
        assertThat(rotatedRobot.getFacing(), is(Facing.EAST));
    }

    @Test
    public void testExecuteFromWest() {
        Robot robot = new Robot(0, 0, Facing.EAST);

        Robot rotatedRobot = rightOperation.execute(robot);

        assertThat(rotatedRobot, is(notNullValue()));
        assertThat(rotatedRobot.getFacing(), is(Facing.SOUTH));
    }

    @Test
    public void testExecuteFromSouth() {
        Robot robot = new Robot(0, 0, Facing.SOUTH);

        Robot rotatedRobot = rightOperation.execute(robot);

        assertThat(rotatedRobot, is(notNullValue()));
        assertThat(rotatedRobot.getFacing(), is(Facing.WEST));
    }

    @Test
    public void testExecuteFromEast() {
        Robot robot = new Robot(0, 0, Facing.WEST);

        Robot rotatedRobot = rightOperation.execute(robot);

        assertThat(rotatedRobot, is(notNullValue()));
        assertThat(rotatedRobot.getFacing(), is(Facing.NORTH));
    }

}
