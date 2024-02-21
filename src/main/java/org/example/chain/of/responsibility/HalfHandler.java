package org.example.chain.of.responsibility;

public class HalfHandler extends Handler{
    @Override
    boolean check(double input) {
        return true;
    }

    @Override
    double process(double input) {
        return input/2;
    }
}
