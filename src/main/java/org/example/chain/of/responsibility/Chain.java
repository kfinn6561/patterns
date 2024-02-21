package org.example.chain.of.responsibility;

public class Chain implements iHandler{
    private final Handler root=new IdentityHandler();
    private Handler end=root;

    public Chain() {
    }

    @Override
    public double handle(double input) {
        return this.root.handle(input);
    }

    public Chain addHandler(Handler handler){
        this.end.setNext(handler);
        this.end=handler;
        return this;
    }
}
