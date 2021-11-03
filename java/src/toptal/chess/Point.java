package toptal.chess;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Point {

    private final int x;
    private final int y;

    private final Point parent;

    public Point(int x, int y, Point parent) {
        this.x = x;
        this.y = y;
        this.parent = parent;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        this.parent = null;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Point getParent() {
        return parent;
    }

    public Set<Point> getNext() {
        List<Point> list = new ArrayList<>();
        list.add(new Point(x + 2, y + 3, this));
        list.add(new Point(x + 3, y + 2, this));
        list.add(new Point(x - 2, y + 3, this));
        list.add(new Point(x - 3, y + 2, this));
        list.add(new Point(x + 2, y - 3, this));
        list.add(new Point(x + 3, y - 2, this));
        list.add(new Point(x - 2, y - 3, this));
        list.add(new Point(x - 3, y - 2, this));
        return list.stream().filter(p -> p.x >= 0 && p.y >= 0).collect(Collectors.toSet());
    }

    public int getLength() {
        int i = 0;
        Point currentParent = this;
        while ((currentParent = currentParent.parent) != null) {
            i++;
        }
        return i;
    }

    @Override
    public String toString() {
        if (parent == null) {
            return "Point{x=" + x + ", y=" + y + '}';
        }

        return "Point{x=" + x + ", y=" + y + "}, " + parent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
