package com.learn.mircroservice.product.controller;

public class calculator {
    int x, y = 0;

    public calculator() {
    }

    public calculator(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int add(int x, int y) {
        return x + y;
    }

    public int subtract(int i, int j) {
        return i - j;
    }
}
