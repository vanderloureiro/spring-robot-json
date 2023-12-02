package dev.vanderloureiro.springrobotjson.robot.io;

public class Position{

        Integer horizontalAxis;
        Integer verticalAxis;
        DirectionEnum direction;

        public Integer getHorizontalAxis() {
                return horizontalAxis;
        }

        public void setHorizontalAxis(Integer horizontalAxis) {
                this.horizontalAxis = horizontalAxis;
        }

        public Integer getVerticalAxis() {
                return verticalAxis;
        }

        public void setVerticalAxis(Integer verticalAxis) {
                this.verticalAxis = verticalAxis;
        }

        public DirectionEnum getDirection() {
                return direction;
        }

        public void setDirection(DirectionEnum direction) {
                this.direction = direction;
        }
}
