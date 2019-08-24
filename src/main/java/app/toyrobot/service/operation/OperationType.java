package app.toyrobot.service.operation;

import app.toyrobot.service.operation.impl.LeftOperation;
import app.toyrobot.service.operation.impl.MoveOperation;
import app.toyrobot.service.operation.impl.RightOperation;

public enum OperationType {
    LEFT(new LeftOperation()), RIGHT(new RightOperation()), MOVE(new MoveOperation());

    private Operation operation;

    private OperationType(Operation operation) {
        this.operation = operation;
    }

    public Operation getOperation() {
        return operation;
    }

}
