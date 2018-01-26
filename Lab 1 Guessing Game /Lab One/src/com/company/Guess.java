package com.company;

public class Guess {

    private int a, b, c;
    private boolean followsRule;

    public Guess(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
        if (a < b && b < c) {
            this.followsRule = true;
        } else {
            this.followsRule = false;
        }
    }

    @Override
    public String toString() {
        return a + " " + b + " " + c + " " + (followsRule ? "Yes" : "No");
    }

}