package org.example.chain.of.responsibility;

public class DoubleHandler extends Handler{
    @Override
    boolean check(double input) {
        return true;
    }

    @Override
    double process(double input) {
        return 2*input;
    }
}
