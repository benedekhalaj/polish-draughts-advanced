package com.codecool.polish_draughts;

import com.codecool.polish_draughts.model.Cell;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {

    @Test
    public void creatingCell_HasRowInteger_WhenCreated() {
        int expected = 2;

        Cell cell = new Cell(expected, 0);

        int actual = cell.getRow();

        assertEquals(expected, actual);
    }

    @Test
    public void creatingCell_HasColumnInteger_WhenCreated() {
        int expected = 2;

        Cell cell = new Cell(0, expected);

        int actual = cell.getColumn();

        assertEquals(expected, actual);
    }

}
