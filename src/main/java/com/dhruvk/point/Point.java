package com.dhruvk.point;

public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    private static int mapToNonNegative(int integer)
    {
        //Maps integer to non-negative integers
        if(integer >= 0)
            return integer*2;
        else
            return -integer*2 - 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x &&
                y == point.y;
    }

    @Override
    public int hashCode()
    {
        //Uses Cantor pairing function
        int mappedX = mapToNonNegative(this.x);
        int mappedY = mapToNonNegative(this.y);
        return mappedY + ((mappedX + mappedY) * (mappedX + mappedY + 1))/2;
    }

}
