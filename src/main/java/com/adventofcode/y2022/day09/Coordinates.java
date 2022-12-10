package com.adventofcode.y2022.day09;

public class Coordinates {
    private int x;
    private int y;

    public Coordinates() {
        this.x = 0;
        this.y = 0;
    }

    public Coordinates(Coordinates coordinates) {
        this.x = coordinates.x;
        this.y = coordinates.y;
    }


    public void move(char direction) {
        switch (direction) {
            case 'U' -> y++;
            case 'D' -> y--;
            case 'L' -> x--;
            case 'R' -> x++;
        }
    }

    public void followHead(Coordinates head) {
        if (Math.abs(this.x - head.x) > 1 || Math.abs(this.y - head.y) > 1) {
            if (this.x != head.x) {
                this.x += head.x > this.x ? 1 : -1;
            }
            if (this.y != head.y) {
                this.y += head.y > this.y ? 1 : -1;
            }
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
}