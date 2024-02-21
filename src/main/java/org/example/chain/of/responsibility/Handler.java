package org.example.chain.of.responsibility;

public abstract class Handler implements iHandler {
    private iHandler next;

    public double handle(double input) {
        if (!check(input)){
            return input;
        }
        double output = process(input);
        if (next==null){
            return output;
        } else {
            return next.handle(output);
        }
    }

    public iHandler setNext(iHandler next) {
        this.next = next;
        return next;
    }

    abstract boolean check(double input);

    abstract double process(double input);
}
