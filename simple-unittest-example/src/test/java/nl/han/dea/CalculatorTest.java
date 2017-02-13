package nl.han.dea;

import org.junit.Test;

import static org.junit.Assert.*;


public class CalculatorTest {

    @Test
    public void testAddPositiveNumbers() throws Exception {
        Calculator sut = new Calculator();
        int summandOne = 1;
        int summandTwo = 4;
        int result = sut.add(summandOne,summandTwo);
        assertEquals(5,result);
    }

    @Test
    public void testAddOtherPositiveNumbers() throws Exception {
        Calculator sut = new Calculator();
        int summandOne = 5;
        int summandTwo = 3;
        int result = sut.add(summandOne,summandTwo);
        assertEquals(8,result);
    }

    @Test(expected = IntegerOutOfRangeException.class)
    public void testMaxOverflow() throws Exception {
        Calculator sut = new Calculator();
        int summand1 = 2147483647;
        int summand2 = 1;
        sut.add(summand1,summand2);
    }
}