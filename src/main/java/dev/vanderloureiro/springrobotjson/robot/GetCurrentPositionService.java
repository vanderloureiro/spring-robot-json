package dev.vanderloureiro.springrobotjson.robot;

import dev.vanderloureiro.springrobotjson.robot.io.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetCurrentPositionService {

    @Autowired
    private PositionRepository positionRepository;

    public Position execute() {
        return positionRepository.get();
    }
}
