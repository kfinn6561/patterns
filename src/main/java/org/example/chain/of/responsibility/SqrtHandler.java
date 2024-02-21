package org.example.chain.of.responsibility;

public class SqrtHandler extends Handler{
    @Override
    boolean check(double input) {
        return input>=0;
    }

    @Override
    double process(double input) {
        return Math.sqrt(input);
    }
}
