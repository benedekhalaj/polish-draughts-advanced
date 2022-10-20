package com.codecool.polish_draughts;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoordinatesTest {

    @Test
    public void creatingCoordinates_CreatedCoordinates_HasXInteger() {
        int expected = 2;

        Coordinates coordinates = new Coordinates(expected, 0);

        int actual = coordinates.getX();

        assertEquals(expected, actual);
    }

    @Test
    public void creatingCoordinates_CreatedCoordinates_HasYInteger() {
        int expected = 2;

        Coordinates coordinates = new Coordinates(0, expected);

        int actual = coordinates.getY();

        assertEquals(expected, actual);
    }

}
