package app.toyrobot.web.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import app.toyrobot.model.Robot;
import app.toyrobot.service.RobotService;
import app.toyrobot.web.controller.RobotController;
import app.toyrobot.web.dto.InputCommand;
import app.toyrobot.web.dto.Report;

@RestController
@RequestMapping(value = "/rest/v1/robot")
public class RobotControllerImpl implements RobotController {

    @Autowired
    private RobotService robotService;

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Robot place(@RequestBody InputCommand command) {
        return robotService.placeRobot(command);
    }
    
    @Override
    @PutMapping(value = "/{id}")
    public Robot moveOrRotate(@PathVariable Long id, @RequestBody InputCommand command) {
        return robotService.moveOrRotateRobot(id, command);
    }

    @Override
    @GetMapping(value = "/{id}")
    public Report report(@PathVariable Long id) {
        return robotService.reportRobot(id);
    }

    @Override
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        robotService.deleteRobot(id);
    }

}
