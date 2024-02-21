package org.example.chain.of.responsibility;

public class SquareHandler extends Handler{
    @Override
    boolean check(double input) {
        return true;
    }

    @Override
    double process(double input) {
        return input*input;
    }
}
