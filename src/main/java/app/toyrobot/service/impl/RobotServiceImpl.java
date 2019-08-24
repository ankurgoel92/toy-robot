package app.toyrobot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import app.toyrobot.model.Robot;
import app.toyrobot.repository.RobotRepository;
import app.toyrobot.service.RobotService;
import app.toyrobot.service.operation.Operation;
import app.toyrobot.service.operation.OperationFactory;
import app.toyrobot.web.dto.InputCommand;
import app.toyrobot.web.dto.Report;

@Service
public class RobotServiceImpl implements RobotService {

    @Autowired
    private RobotRepository robotRepository;

    @Override
    public Report reportRobot(long id) {
        return convertToReportDto(getRobot(id));
    }

    @Override
    public Robot placeRobot(InputCommand command) {
        return robotRepository.save(convertToEntity(command));
    }

    @Override
    public Robot moveOrRotateRobot(Long id, InputCommand command) {
        return robotRepository.save(executeOperation(command, getRobot(id)));
    }

    @Override
    public void deleteRobot(Long id) {
        robotRepository.deleteById(id);
    }

    private Robot convertToEntity(final InputCommand command) {
        Robot robot = new Robot(command.getX(), command.getY(), command.getF());
        return robot;
    }
    
    private Report convertToReportDto(Robot robot) {
        return new Report(robot.getPlacement());
    }

    private Robot executeOperation(InputCommand command, final Robot robot) {
        final Operation operation = OperationFactory.getOperation(command.getOperation());
        return operation.execute(robot);
    }

    private Robot getRobot(long id) {
        final Robot robot = robotRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
        return robot;
    }

    public void setRobotRepository(RobotRepository robotRepository) {
        this.robotRepository = robotRepository;
    }

}
