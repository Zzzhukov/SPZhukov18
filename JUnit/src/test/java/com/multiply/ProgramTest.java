package com.multiply;

import static org.junit.jupiter.api.Assertions.*;

class ProgramTest {

    @org.junit.jupiter.api.Test
    void multiply() {
        programm program = new programm();
        int actual = program.multiply(-15, 4);
        int expected = 60;
        assertEquals(expected, actual);
    }
}