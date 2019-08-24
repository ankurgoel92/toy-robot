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
import app.toyrobot.service.operation.impl.MoveOperation;

@RunWith(SpringRunner.class)
public class MoveOperationTest {

    private MoveOperation moveOperation;

    @BeforeEach
    public void setUp() {
        moveOperation = new MoveOperation();
    }

    @Test
    public void testExecuteFrom00AndNorth() {
        Robot robot = new Robot(0, 0, Facing.NORTH);

        Robot moved = moveOperation.execute(robot);

        assertThat(moved, is(notNullValue()));
        assertThat(moved.getX(), is(0));
        assertThat(moved.getY(), is(1));
    }
    
    @Test
    public void testExecuteFrom04AndNorth() {
        Robot robot = new Robot(0, 4, Facing.NORTH);

        Robot moved = moveOperation.execute(robot);

        assertThat(moved, is(notNullValue()));
        assertThat(moved.getX(), is(0));
        assertThat(moved.getY(), is(4));
    }
    
    @Test
    public void testExecuteFrom00AndSouth() {
        Robot robot = new Robot(0, 0, Facing.SOUTH);

        Robot moved = moveOperation.execute(robot);

        assertThat(moved, is(notNullValue()));
        assertThat(moved.getX(), is(0));
        assertThat(moved.getY(), is(0));
    }
    
    @Test
    public void testExecuteFrom04AndSouth() {
        Robot robot = new Robot(0, 4, Facing.SOUTH);

        Robot moved = moveOperation.execute(robot);

        assertThat(moved, is(notNullValue()));
        assertThat(moved.getX(), is(0));
        assertThat(moved.getY(), is(3));
    }
    
    @Test
    public void testExecuteFrom00AndEast() {
        Robot robot = new Robot(0, 0, Facing.EAST);

        Robot moved = moveOperation.execute(robot);

        assertThat(moved, is(notNullValue()));
        assertThat(moved.getX(), is(1));
        assertThat(moved.getY(), is(0));
    }
    
    @Test
    public void testExecuteFrom40AndEast() {
        Robot robot = new Robot(4, 0, Facing.EAST);

        Robot moved = moveOperation.execute(robot);

        assertThat(moved, is(notNullValue()));
        assertThat(moved.getX(), is(4));
        assertThat(moved.getY(), is(0));
    }
    
    @Test
    public void testExecuteFrom00AndWest() {
        Robot robot = new Robot(0, 0, Facing.WEST);

        Robot moved = moveOperation.execute(robot);

        assertThat(moved, is(notNullValue()));
        assertThat(moved.getX(), is(0));
        assertThat(moved.getY(), is(0));
    }
    
    @Test
    public void testExecuteFrom40AndWest() {
        Robot robot = new Robot(4, 0, Facing.WEST);

        Robot moved = moveOperation.execute(robot);

        assertThat(moved, is(notNullValue()));
        assertThat(moved.getX(), is(3));
        assertThat(moved.getY(), is(0));
    }

}
