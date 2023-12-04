package dev.vanderloureiro.springrobotjson.robot;

import dev.vanderloureiro.springrobotjson.robot.io.Moviment;
import dev.vanderloureiro.springrobotjson.robot.io.Position;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PositionController {

    @Autowired
    private MoveRobotService moveRobotService;
    @Autowired
    private GetCurrentPositionService getCurrentPositionService;

    @GetMapping
    @Operation(summary = "Busca posição", description = "Busca posição atual do robô")
    public ResponseEntity<Position> get() {
        return ResponseEntity.ok(this.getCurrentPositionService.execute());
    }

    @PostMapping
    @Operation(summary = "Realiza movimento", description = "Realiza movimentos do robô de rotação ou seguir em frente")
    public ResponseEntity<Position> post(@RequestBody Moviment input) {
        return ResponseEntity.ok(this.moveRobotService.execute(input));
    }
}
