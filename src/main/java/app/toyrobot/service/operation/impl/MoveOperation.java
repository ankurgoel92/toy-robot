package app.toyrobot.service.operation.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import app.toyrobot.model.Robot;
import app.toyrobot.service.operation.Operation;

public class MoveOperation implements Operation {
    private static final Logger LOG = LoggerFactory.getLogger(MoveOperation.class);

    @Override
    public Robot execute(Robot robot) {
        LOG.info("Moving Robot {} if it is not on the edge", robot);
        robot.getFacing().moveRobot(robot);
        return robot;
    }

}
