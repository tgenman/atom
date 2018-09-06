package ru.atom.geometry;

import java.util.Objects;

/**
 * Template class for Point
 */
public class Point implements Collider {

    private final int x;

    private final int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean isColliding(Collider other) {
        if (other instanceof Point)
            return this.equals(other);
        if (other instanceof Bar)
            return other.isColliding(this);
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x
                && y == point.y;
    }
}
