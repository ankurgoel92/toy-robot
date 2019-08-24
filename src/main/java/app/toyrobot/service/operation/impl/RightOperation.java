package app.toyrobot.service.operation.impl;

import app.toyrobot.model.Robot;
import app.toyrobot.service.operation.Operation;

public class RightOperation implements Operation {

    @Override
    public Robot execute(Robot robot) {
        if (!robot.isPlaced()) {
            throw new RuntimeException(Robot.ROBOT_MISSING);
        }

        robot.setFacing(robot.getFacing().getRightFacing());

        return robot;
    }

}
