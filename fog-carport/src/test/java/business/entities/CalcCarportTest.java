package business.entities;


import business.exceptions.UserException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalcCarportTest {

    @Test
    void calcPosts() throws UserException {
        CalcCarport calcCarport = new CalcCarport();
        int actual = calcCarport.calcPosts(780).getQuantity();
        int expected = 8;
        assertEquals(expected, actual);

    }

    @Test
    void calcBeams() throws UserException {
        CalcCarport calcCarport = new CalcCarport();
        int actual = calcCarport.calcBeams(780).getQuantity();
        int expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    void calcRafter() throws UserException {
        CalcCarport calcCarport = new CalcCarport();
        int actual = calcCarport.calcRafter(780,600).getQuantity();
        int expected = 14;
        assertEquals(expected, actual);
    }

    @Test
    void calcPlastmo() throws UserException {
        CalcCarport calcCarport = new CalcCarport();
        int actual = calcCarport.calcPlastmo(780, 600).getQuantity();
        int expected = 9;
        assertEquals(expected, actual);
    }

    @Test
    void calcPostbolts() throws UserException {
        CalcCarport calcCarport = new CalcCarport();
        int actual = calcCarport.calcPostbolts(780).getQuantity();
        int expected = 16;
        assertEquals(expected, actual);
    }

    @Test
    void calcSquareDiscs() throws UserException {
        CalcCarport calcCarport = new CalcCarport();
        int actual = calcCarport.calcSquareDiscs(780).getQuantity();
        int expected = 16;
        assertEquals(expected, actual);
    }

    @Test
    void calcUniRight() throws UserException {
        CalcCarport calcCarport = new CalcCarport();
        int actual = calcCarport.calcUniRight(780, 600).getQuantity();
        int expected = 14;
        assertEquals(expected, actual);
    }

    @Test
    void calcUniLeft() throws UserException {
        CalcCarport calcCarport = new CalcCarport();
        int actual = calcCarport.calcUniLeft(780, 600).getQuantity();
        int expected = 14;
        assertEquals(expected, actual);
    }

    @Test
    void calcPlastmoBolt() throws UserException {
        CalcCarport calcCarport = new CalcCarport();
        int actual = calcCarport.calcPlastmoBolt(780, 600).getQuantity();
        int expected = 3;
        assertEquals(expected, actual);
    }
}