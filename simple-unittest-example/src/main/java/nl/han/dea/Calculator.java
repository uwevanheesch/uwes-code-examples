package nl.han.dea;


public class Calculator {

    public int add(int summandOne, int summandTwo) throws IntegerOutOfRangeException {
        long result = (long)summandOne + (long) summandTwo;
        if(result > Integer.MAX_VALUE){
            IntegerOutOfRangeException iee = new IntegerOutOfRangeException();
            throw iee;
        }
        return summandOne + summandTwo;
    }

}
