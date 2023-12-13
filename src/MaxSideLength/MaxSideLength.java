package MaxSideLength;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class MaxSideLength {
    private static class Point <T>{
        private final T x;
        private final T y;
        Point(T x, T y){
            this.x = x;
            this.y = y;
        }

        public T getX() {return x;}
        public T getY() {return y;}
    }

    public Long solve(String inputFile) {

        try {
            File input_file = new File(inputFile);
            Scanner scanner = new Scanner(input_file);

            int n = scanner.nextInt();

            Point<Long>[] points = new Point[n];
            for (int i = 0; i < n; i++) {
                points[i] = new Point<>(scanner.nextLong(), scanner.nextLong());
            }
            Arrays.sort(points, Comparator.comparing(p -> p.x));

            // sortedY is an array where each Y has its pair to be its corresponding index in points
            Point<Long>[] sortedY = new Point[n];
            for (int i = 0; i < n; i++) {
                sortedY[i] = new Point<>(points[i].getY(), (long) i);
            }
            Arrays.sort(sortedY, Comparator.comparing(Point::getX));

            Point<Point<Long>> closestPoints;
            closestPoints = closestPoints(points, sortedY, 0, n - 1);

            System.out.println((Math.max(Math.abs(closestPoints.getX().getX() - closestPoints.getY().getX()),
                    Math.abs(closestPoints.getX().getY() - closestPoints.getY().getY()))));
            return Math.max(Math.abs(closestPoints.getX().getX() - closestPoints.getY().getX()),
                            Math.abs(closestPoints.getX().getY() - closestPoints.getY().getY()));

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    public Long solveBruteForce(String inputFile) throws FileNotFoundException {
        File input_file = new File(System.getProperty("user.dir") + inputFile);
        Scanner scanner = new Scanner(input_file);
        int n = scanner.nextInt();
        System.out.println(n);

        Point<Long>[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            points[i] = new Point<>(scanner.nextLong(), scanner.nextLong());
        }

        Point<Point<Long>> closestPoints;
        closestPoints = bruteForce(points, 0, n - 1);

        return Math.max(Math.abs(closestPoints.getX().getX() - closestPoints.getY().getX()),
                        Math.abs(closestPoints.getX().getY() - closestPoints.getY().getY()));
    }

    private Point<Point<Long>> closestPoints(Point<Long>[] points, Point<Long>[] sortedY, int start, int end) {

        if (end - start <= 3) {
            return bruteForce(points, start, end);
        }

        // split the sorted_y coordinates into two arrays
        // each for each subproblem
        int n = sortedY.length;
        int emptyIndexLeft = 0, emptyIndexRight = 0;
        int midIndex = (start + end) / 2;
        Point<Long>[] yCoordinatesLeft = new Point[midIndex - start + 1];
        Point<Long>[] yCoordinatesRight = new Point[end - midIndex];

        for (int i = 0; i < n; i++) {
            if (sortedY[i].getY() >= start && sortedY[i].getY() <= midIndex)
                yCoordinatesLeft[emptyIndexLeft++] = sortedY[i];
            else yCoordinatesRight[emptyIndexRight++] = sortedY[i];
        }

        Point<Point<Long>> left;
        left = closestPoints(points, yCoordinatesLeft, start, midIndex);
        double leftDistance = distance(left.getX(), left.getY());

        Point<Point<Long>> right;
        right = closestPoints(points, yCoordinatesRight, midIndex+1, end);
        double rightDistance = distance(right.getX(), right.getY());

        Point<Point<Long>> closest;
        closest = (leftDistance < rightDistance) ? left : right;
        double minDistance = Math.min(leftDistance, rightDistance);


        // check for each point its closest 7 points
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= Math.min(end - start, i + 7); j++) {
                Point<Long> p1 = points[Math.toIntExact(sortedY[i].getY())];
                Point<Long> p2 = points[Math.toIntExact(sortedY[j].getY())];
                double d = distance(p1, p2);
                if (d < minDistance) {
                    minDistance = d;
                    closest = new Point<>(p1, p2);
                }
            }
        }

        return closest;
    }

    private Point<Point<Long>> bruteForce(Point<Long>[] points, int start, int end) {
        double min = Double.MAX_VALUE;
        Point<Long> p1 = new Point<>(Long.MAX_VALUE, Long.MAX_VALUE),
                p2 = new Point<>(Long.MIN_VALUE, Long.MIN_VALUE);
        for (int i = start; i <= end; i++) {
            for (int j = i + 1; j <= end; j++) {
                if (distance(points[i], points[j]) < min) {
                    min = distance(points[i], points[j]);
                    p1 = points[i];
                    p2 = points[j];
                }
            }
        }
        return new Point<>(p1, p2);
    }

    private double distance(Point<Long> p1, Point<Long> p2) {
        double diffX = p1.getX() - p2.getX();
        double diffY = p1.getY() - p2.getY();
//        Math.sqrt(diffX * diffX) + (diffY * diffY);
        return Math.max(Math.abs(diffX), Math.abs(diffY));
    }

}
