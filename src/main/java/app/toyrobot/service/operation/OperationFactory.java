package app.toyrobot.service.operation;

public class OperationFactory {

    public static Operation getOperation(String operation) {
        return OperationType.valueOf(operation).getOperation();
    }
}
