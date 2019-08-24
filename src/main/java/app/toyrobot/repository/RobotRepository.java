package app.toyrobot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import app.toyrobot.model.Robot;

@Repository
public interface RobotRepository extends CrudRepository<Robot, Long>{

}
