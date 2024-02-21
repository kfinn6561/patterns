package org.example.chain.of.responsibility;

public class ReciprocalHandler extends Handler{
    @Override
    boolean check(double input) {
        return input!=0;
    }

    @Override
    double process(double input) {
        return 1/input;
    }
}
