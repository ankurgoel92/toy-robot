package app.toyrobot.service.operation.impl;

import app.toyrobot.model.Robot;
import app.toyrobot.service.operation.Operation;

public class MoveOperation implements Operation {

    @Override
    public Robot execute(Robot robot) {
        robot.getFacing().moveRobot(robot);
        return robot;
    }

}
