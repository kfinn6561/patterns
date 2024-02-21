package org.example.chain.of.responsibility;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HandlerTest {

    @Test
    void doubleThenHalfReturnsSame(){
        //given
        iHandler doubleHalfHandler = new Chain().addHandler(new DoubleHandler()).addHandler(new HalfHandler());
        double input=1234.5;

        //when
        double actual = doubleHalfHandler.handle(input);

        //then
        assertEquals(input,actual);
    }

    @Test
    void squareThenSqrtReturnsSame(){
        //given
        iHandler squareSqrtHandler = new Chain().addHandler(new SqrtHandler()).addHandler(new SquareHandler());
        double input=1234.5;

        //when
        double actual = squareSqrtHandler.handle(input);

        //then
        assertEquals(input,actual);
    }

    @Test
    void reciprocalTwiceReturnsSame(){
        //given
        iHandler doubleRecipricalHandler = new Chain().addHandler(new ReciprocalHandler()).addHandler(new ReciprocalHandler());
        double input=1234.5;

        //when
        double actual = doubleRecipricalHandler.handle(input);

        //then
        assertEquals(input,actual);
    }

    @Test
    void reciprocalZeroReturnsZero(){
        //given
        iHandler multiHandler = new Chain().addHandler(new ReciprocalHandler()).addHandler(new SquareHandler()).addHandler(new DoubleHandler());
        double input=0;

        //when
        double actual = multiHandler.handle(input);

        //then
        assertEquals(input,actual);
    }
}