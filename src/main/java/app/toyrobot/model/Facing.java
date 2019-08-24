package app.toyrobot.model;

public enum Facing {
    NORTH("WEST", "EAST") {
        @Override
        public Robot moveRobot(Robot robot) {
            robot.moveUp();
            return robot;
        }
    },
    EAST("NORTH", "SOUTH") {
        @Override
        public Robot moveRobot(Robot robot) {
            robot.moveRight();
            return robot;
        }
    },
    WEST("SOUTH", "NORTH") {
        @Override
        public Robot moveRobot(Robot robot) {
            robot.moveLeft();
            return robot;
        }
    },
    SOUTH("EAST", "WEST") {
        @Override
        public Robot moveRobot(Robot robot) {
            robot.moveDown();
            return robot;
        }
    };

    private String leftFacing;
    private String rightFacing;

    private Facing(String leftFacing, String rightFacing) {
        this.leftFacing = leftFacing;
        this.rightFacing = rightFacing;
    }

    public abstract Robot moveRobot(Robot robot);

    public Facing getLeftFacing() {
        return Facing.valueOf(leftFacing);
    }

    public Facing getRightFacing() {
        return Facing.valueOf(rightFacing);
    }

}
