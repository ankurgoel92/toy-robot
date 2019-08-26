package app.toyrobot.web.dto;

import javax.validation.constraints.NotBlank;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonIgnore;

import app.toyrobot.model.Facing;
import app.toyrobot.model.Robot;

public class InputCommand {

    @NotBlank
    private String command;
    
    @JsonIgnore 
    private String operation;
    
    @JsonIgnore
    private int x;

    @JsonIgnore
    private int y;
    
    @JsonIgnore
    private Facing f;

    public InputCommand() {
    }

    public void initialize() {
        final String[] operationAndArgs = StringUtils.split(command);
        this.operation = operationAndArgs[0].trim();

        if (StringUtils.equalsIgnoreCase("PLACE", operation)) {
            final String[] coordinates = StringUtils.split(operationAndArgs[1], ',');
            this.x = validateBounds(Integer.parseInt(coordinates[0].trim()));
            this.y = validateBounds(Integer.parseInt(coordinates[1].trim()));
            this.f = Facing.valueOf(coordinates[2].trim());
        }
    }

    private int validateBounds(int coordinate) {
        if(coordinate < Robot.MIN_POSITION || coordinate > Robot.MAX_POSITION) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, Robot.ROBOT_OUT_OF_BOUNDS);
        }
        return coordinate;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
        initialize();
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Facing getF() {
        return f;
    }

    public void setF(Facing f) {
        this.f = f;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("InputCommand [command=");
        builder.append(command);
        builder.append(", operation=");
        builder.append(operation);
        builder.append(", x=");
        builder.append(x);
        builder.append(", y=");
        builder.append(y);
        builder.append(", f=");
        builder.append(f);
        builder.append("]");
        return builder.toString();
    }
    
}
