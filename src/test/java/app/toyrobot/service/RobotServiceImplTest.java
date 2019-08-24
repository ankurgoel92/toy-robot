package app.toyrobot.service;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import app.toyrobot.model.Facing;
import app.toyrobot.model.Robot;
import app.toyrobot.repository.RobotRepository;
import app.toyrobot.service.impl.RobotServiceImpl;
import app.toyrobot.web.dto.InputCommand;
import app.toyrobot.web.dto.Report;

@RunWith(SpringRunner.class)
public class RobotServiceImplTest {

    private RobotServiceImpl robotService;
    private RobotRepository robotRepository = Mockito.mock(RobotRepository.class);

    @BeforeEach
    public void setUp() {
        robotService = new RobotServiceImpl();
        robotService.setRobotRepository(robotRepository);
    }

    @Test
    public void testPlaceRobot() {
        Robot robot = new Robot(0, 0, Facing.NORTH);
        when(robotRepository.save(robot)).thenReturn(robot);

        final InputCommand placeCommand = new InputCommand();
        placeCommand.setCommand("PLACE 0,0,NORTH");

        final Robot savedRobot = robotService.placeRobot(placeCommand);
        assertThat(savedRobot, is(notNullValue()));
        assertThat(savedRobot, is(robot));
    }

    @Test
    public void testMoveRobot() {
        Robot robot = new Robot(0, 0, Facing.NORTH);
        Robot movedRobot = new Robot(0, 1, Facing.NORTH);

        when(robotRepository.findById((long) 1)).thenReturn(Optional.of(robot));
        when(robotRepository.save(movedRobot)).thenReturn(movedRobot);

        final InputCommand moveCommand = new InputCommand();
        moveCommand.setCommand("MOVE");

        final Robot actualRobot = robotService.moveOrRotateRobot((long) 1, moveCommand);
        assertThat(actualRobot, is(notNullValue()));
        assertThat(actualRobot, is(movedRobot));
    }

    @Test
    public void testLeftRotateRobot() {
        Robot robot = new Robot(0, 0, Facing.NORTH);
        Robot movedRobot = new Robot(0, 0, Facing.WEST);

        when(robotRepository.findById((long) 1)).thenReturn(Optional.of(robot));
        when(robotRepository.save(movedRobot)).thenReturn(movedRobot);

        final InputCommand moveCommand = new InputCommand();
        moveCommand.setCommand("LEFT");

        final Robot actualRobot = robotService.moveOrRotateRobot((long) 1, moveCommand);
        assertThat(actualRobot, is(notNullValue()));
        assertThat(actualRobot, is(movedRobot));
    }

    @Test
    public void testRightRotateRobot() {
        Robot robot = new Robot(0, 0, Facing.NORTH);
        Robot movedRobot = new Robot(0, 0, Facing.EAST);

        when(robotRepository.findById((long) 1)).thenReturn(Optional.of(robot));
        when(robotRepository.save(movedRobot)).thenReturn(movedRobot);

        final InputCommand moveCommand = new InputCommand();
        moveCommand.setCommand("RIGHT");

        final Robot actualRobot = robotService.moveOrRotateRobot((long) 1, moveCommand);
        assertThat(actualRobot, is(notNullValue()));
        assertThat(actualRobot, is(movedRobot));
    }

    @Test
    public void testReportRobot() {
        Robot robot = new Robot(0, 0, Facing.NORTH);
        Report expectedReport = new Report("0,0,NORTH");
        
        when(robotRepository.findById((long) 1)).thenReturn(Optional.of(robot));

        final InputCommand moveCommand = new InputCommand();
        moveCommand.setCommand("REPORT");

        final Report actualReport = robotService.reportRobot((long) 1);
        assertThat(actualReport, is(notNullValue()));
        assertThat(actualReport.getOutput(), is(expectedReport.getOutput()));
    }
}
