package app.toyrobot.service.operation.impl;

import app.toyrobot.model.Robot;
import app.toyrobot.service.operation.Operation;

public class RightOperation implements Operation {
    
    @Override
    public Robot execute(Robot robot) {
        robot.setFacing(robot.getFacing().getRightFacing());
        return robot;
    }

}
