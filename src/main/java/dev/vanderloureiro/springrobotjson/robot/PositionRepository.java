package dev.vanderloureiro.springrobotjson.robot;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.vanderloureiro.springrobotjson.robot.io.Position;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;

@Repository
public class PositionRepository {

    private final String POSITION_FILE_PATH = "src/main/resources/position.json";
    private final ObjectMapper objectMapper = new ObjectMapper();

    public Position get() {
        try {
            return objectMapper.readValue(new File(POSITION_FILE_PATH), Position.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void save(Position position) {
        try {
            objectMapper.writeValue(new File(POSITION_FILE_PATH), position);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
