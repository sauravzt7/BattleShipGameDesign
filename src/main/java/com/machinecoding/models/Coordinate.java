package com.machinecoding.models;

import java.util.Objects;

public class Coordinate {

    private final int x;
    private final int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o)return true;
        if(!(o instanceof Coordinate))return false;
        Coordinate that = (Coordinate)o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode(){
        return Objects.hash(x, y);
    }

    public String toString(){
        return "(" + x + ", " + y + ")";
    }
}
