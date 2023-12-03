package dev.vanderloureiro.springrobotjson.robot;

import dev.vanderloureiro.springrobotjson.robot.io.DirectionEnum;
import dev.vanderloureiro.springrobotjson.robot.io.Moviment;
import dev.vanderloureiro.springrobotjson.robot.io.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoveRobotService {

    @Autowired
    private PositionRepository positionRepository;

    public Position execute(Moviment input) {
        Position currentPosition = this.positionRepository.get();
        switch (input.moviment()) {
            case L -> this.turnLeft(currentPosition);
            case R -> this.turnRight(currentPosition);
            case M -> this.goAhead(currentPosition);
        }
        this.positionRepository.save(currentPosition);
        return currentPosition;
    }

    private void turnLeft(Position currentPosition) {
        switch (currentPosition.getDirection()) {
            case N -> currentPosition.setDirection(DirectionEnum.W);
            case W -> currentPosition.setDirection(DirectionEnum.S);
            case S -> currentPosition.setDirection(DirectionEnum.E);
            case E -> currentPosition.setDirection(DirectionEnum.N);
        }
    }

    private void turnRight(Position currentPosition) {
        switch (currentPosition.getDirection()) {
            case N -> currentPosition.setDirection(DirectionEnum.E);
            case E -> currentPosition.setDirection(DirectionEnum.S);
            case S -> currentPosition.setDirection(DirectionEnum.W);
            case W -> currentPosition.setDirection(DirectionEnum.N);
        }
    }

    private void goAhead(Position currentPosition) {
        switch (currentPosition.getDirection()) {
            case N -> currentPosition.setVerticalAxis(currentPosition.getVerticalAxis() + 1);
            case E -> currentPosition.setHorizontalAxis(currentPosition.getHorizontalAxis() + 1);
            case S -> currentPosition.setVerticalAxis(currentPosition.getVerticalAxis() - 1);
            case W -> currentPosition.setHorizontalAxis(currentPosition.getHorizontalAxis() - 1);
        }
    }


}
