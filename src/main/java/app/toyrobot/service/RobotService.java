package app.toyrobot.service;

import app.toyrobot.model.Robot;
import app.toyrobot.web.dto.InputCommand;
import app.toyrobot.web.dto.Report;

public interface RobotService {

    Robot placeRobot(InputCommand command);

    Robot moveOrRotateRobot(Long id, InputCommand command);

    Report reportRobot(long id);

    void deleteRobot(Long id);

}
