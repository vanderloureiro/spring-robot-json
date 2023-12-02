package dev.vanderloureiro.springrobotjson.robot.io;

public enum DirectionEnum {
    N("NORTH"),
    S("SOUTH"),
    E("EAST"),
    W("WEST");

    private final String description;

    DirectionEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
}
