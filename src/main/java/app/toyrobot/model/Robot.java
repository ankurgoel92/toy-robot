package app.toyrobot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Robot {

    public static final Integer MAX_POSITION = 4;
    public static final Integer MIN_POSITION = 0;
    public static final String ROBOT_MISSING = "ROBOT MISSING";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Integer x;

    @NotNull
    private Integer y;

    @NotNull
    private Facing facing;

    public Robot() {
    }

    public Robot(final Integer x, final Integer y, final Facing facing) {
        this.x = x;
        this.y = y;
        this.facing = facing;
    }

    public void moveUp() {
        if (getY() < Robot.MAX_POSITION) {
            y++;
        }
    }

    public void moveDown() {
        if (getY() > Robot.MIN_POSITION) {
            y--;
        }
    }

    public void moveRight() {
        if (getX() < Robot.MAX_POSITION) {
            x++;
        }

    }

    public void moveLeft() {
        if (getX() > Robot.MIN_POSITION) {
            x--;
        }
    }

    public String getPlacement() {
        return this.isPlaced() ? String.join(",", x.toString(), y.toString(), facing.toString()) : ROBOT_MISSING;
    }

    public boolean isPlaced() {
        return x != null && y != null && facing != null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Facing getFacing() {
        return facing;
    }

    public void setFacing(Facing facing) {
        this.facing = facing;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((facing == null) ? 0 : facing.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((x == null) ? 0 : x.hashCode());
        result = prime * result + ((y == null) ? 0 : y.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Robot other = (Robot) obj;
        if (facing != other.facing)
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (x == null) {
            if (other.x != null)
                return false;
        } else if (!x.equals(other.x))
            return false;
        if (y == null) {
            if (other.y != null)
                return false;
        } else if (!y.equals(other.y))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Robot [id=");
        builder.append(id);
        builder.append(", x=");
        builder.append(x);
        builder.append(", y=");
        builder.append(y);
        builder.append(", facing=");
        builder.append(facing);
        builder.append("]");
        return builder.toString();
    }

}
