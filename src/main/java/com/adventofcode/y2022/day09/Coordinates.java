package com.adventofcode.y2022.day09;

public class Coordinates {
    int x;
    int y;

    public Coordinates() {
        this.x = 0;
        this.y = 0;
    }

    public void move(char direction) {
        switch (direction) {
            case 'U' -> y++;
            case 'D' -> y--;
            case 'L' -> x--;
            case 'R' -> x++;
        }
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinates that = (Coordinates) o;

        if (x != that.x) return false;
        return y == that.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
