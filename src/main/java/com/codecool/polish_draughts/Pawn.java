package com.codecool.polish_draughts;

public class Pawn {

    private final String color;
    private Coordinates position;

    public Pawn(String color, Coordinates position) {
        this.color = color;
        this.position = position;
    }

    public String getColor() {
        return color;
    }

    public Coordinates getPosition() {
        return position;
    }

    public void setPosition(Coordinates position) {
        this.position = position;
    }
}
