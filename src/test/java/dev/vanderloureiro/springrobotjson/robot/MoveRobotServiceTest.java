package dev.vanderloureiro.springrobotjson.robot;

import dev.vanderloureiro.springrobotjson.robot.io.DirectionEnum;
import dev.vanderloureiro.springrobotjson.robot.io.Moviment;
import dev.vanderloureiro.springrobotjson.robot.io.MovimentEnum;
import dev.vanderloureiro.springrobotjson.robot.io.Position;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class MoveRobotServiceTest {

    @Mock
    private PositionRepository positionRepository;

    @InjectMocks
    private MoveRobotService moveRobotService;

    @Test
    public void when_north_and_turn_left_should_return_west() {
        when(positionRepository.get()).thenReturn(new Position(0, 0, DirectionEnum.N));
        Position current = moveRobotService.execute(new Moviment(MovimentEnum.L));
        assertEquals(DirectionEnum.W, current.getDirection());
    }

    @Test
    public void when_south_and_turn_left_should_return_west() {
        when(positionRepository.get()).thenReturn(new Position(0, 0, DirectionEnum.S));
        Position current = moveRobotService.execute(new Moviment(MovimentEnum.L));
        assertEquals(DirectionEnum.E, current.getDirection());
    }

    @Test
    public void when_north_and_move_should_increase_vertical_axis() {
        when(positionRepository.get()).thenReturn(new Position(0, 0, DirectionEnum.N));
        Position current = moveRobotService.execute(new Moviment(MovimentEnum.M));
        assertEquals(1, current.getVerticalAxis());
    }

    @Test
    public void when_east_and_move_should_increase_horizontal_axis() {
        when(positionRepository.get()).thenReturn(new Position(0, 0, DirectionEnum.E));
        Position current = moveRobotService.execute(new Moviment(MovimentEnum.M));
        assertEquals(1, current.getHorizontalAxis());
    }
}
