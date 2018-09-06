package ru.atom.geometry;

import java.util.Objects;

public class Bar implements Collider {

    private final int firstCornerX;

    private final int firstCornerY;

    private final int secondCornerX;

    private final int secondCornerY;

    public Bar(int firstCornerX, int firstCornerY, int secondCornerX, int secondCornerY) {

        this.firstCornerX = firstCornerX <= secondCornerX ? firstCornerX : secondCornerX;
        this.firstCornerY = firstCornerY <= secondCornerY ? firstCornerY : secondCornerY;
        this.secondCornerX = firstCornerX >= secondCornerX ? firstCornerX : secondCornerX;
        this.secondCornerY = firstCornerY >= secondCornerY ? firstCornerY : secondCornerY;
    }

    public int getFirstCornerX() {
        return firstCornerX;
    }

    public int getFirstCornerY() {
        return firstCornerY;
    }

    public int getSecondCornerX() {
        return secondCornerX;
    }

    public int getSecondCornerY() {
        return secondCornerY;
    }

    @Override
    public boolean isColliding(Collider other) {
        if (other instanceof Point) {
            int pointX = ((Point) other).getX();
            int pointY = ((Point) other).getY();
            if (pointX >= firstCornerX && pointX <= secondCornerX
                    && pointY >= firstCornerY && pointY <= secondCornerY) {
                return true;
            }
        }

        if (other instanceof Bar) {
            int x1 = ((Bar) other).getFirstCornerX();
            int y1 = ((Bar) other).getFirstCornerY();
            int x2 = ((Bar) other).getSecondCornerX();
            int y2 = ((Bar) other).getSecondCornerY();

            if (x2 < firstCornerX
                    || x1 > secondCornerX
                    || y2 < firstCornerY
                    || y1 > secondCornerY)
                return false;

            return true;
        }

        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bar bar = (Bar) o;
        return firstCornerX == bar.firstCornerX
                && firstCornerY == bar.firstCornerY
                && secondCornerX == bar.secondCornerX
                && secondCornerY == bar.secondCornerY;
    }
}
