
# Toy Robot Simulation [![Build Status](https://travis-ci.org/ankurgoel92/toy-robot.svg?branch=master)](https://travis-ci.org/ankurgoel92/toy-robot) [![Live Demo](https://img.shields.io/badge/demo-online-green.svg)](https://my-toy-robot.herokuapp.com/swagger-ui.html)


## Description
- The application is a simulation of a toy robot moving on a square tabletop, of dimensions 5 x 5 units.
- Any movement that would result in the robot falling from the table must
be prevented,
- Application that can read in commands of the following form:

Command | Description
-------- | -----
PLACE X,Y,F| PLACE will put the toy robot on the table in position X,Y and facing NORTH,SOUTH, EAST or WEST
MOVE|will move the toy robot one unit forward in the direction it is currently facing.
LEFT|Will rotate the robot 90 degrees
RIGHT|Will rotate the robot 90 degrees
REPORT|Will announce the X,Y and F of the robot.

### Test Cases
1.
	PLACE 0,0,NORTH
	MOVE
	REPORT

	Output: 0,1,NORTH

2.
	MOVE

	Output: ROBOT MISSING

## App Details

> Heroku Endpoint | https://my-toy-robot.herokuapp.com/

> Swagger UI |  https://my-toy-robot.herokuapp.com/swagger-ui.html

> It's a spring boot rest application built using **Controller - Service - Repository** architecture.
Example requests are attached as postman json collections.
