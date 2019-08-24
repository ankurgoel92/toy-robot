package app.toyrobot.web.controller;

import app.toyrobot.model.Robot;
import app.toyrobot.web.dto.InputCommand;
import app.toyrobot.web.dto.Report;
import io.swagger.annotations.ApiOperation;

public interface RobotController {

    @ApiOperation(value = "Places the Robot on the grid.", notes = "This should be the very first opertaion for the robot to be able to move or chage directions.", response = Robot.class)
    Robot place(InputCommand command);

    @ApiOperation(value = "Moves the robot forward or changes the facing.", notes = "This operation can only be performed after the robot has been placed.", response = Robot.class)
    Robot moveOrRotate(Long id, InputCommand command);

    @ApiOperation(value = "Returns the current state of the Robot.", notes = "This is ideally the last operation in the chain.", response = Robot.class)
    Report report(Long id);

    @ApiOperation(value = "Deletes a Robot.")
    void delete(Long id);

}
