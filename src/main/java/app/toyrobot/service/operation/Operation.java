package app.toyrobot.service.operation;

import app.toyrobot.model.Robot;

public interface Operation {
    Robot execute(Robot robot);
}
