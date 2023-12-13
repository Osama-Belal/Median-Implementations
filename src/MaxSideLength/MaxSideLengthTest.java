package MaxSideLength;

import MaxSideLength.MaxSideLength;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class MaxSideLengthTest {

    MaxSideLength m = new MaxSideLength();

    private static void generatePoints(int size) throws IOException {
        FileWriter myWriter = new FileWriter(System.getProperty("user.dir") + "\\src\\in.txt");
        int n = (int) (Math.random() * size);
        myWriter.write(n + "\n");
        for (int i = 0; i < n; i++) {
            myWriter.write((int) (Math.random() * 1e6) + " " + (int) (Math.random() * 1e6) + "\n");
        }
        myWriter.close();
    }

    @Test
    void solve_10() throws IOException {
        generatePoints(10);
        assertEquals(m.solve("\\src\\in.txt"), m.solveBruteForce("\\src\\in.txt"));
    }

    @Test
    void solve_100() throws IOException {
        generatePoints(100);
        assertEquals(m.solve("\\src\\in.txt"), m.solveBruteForce("\\src\\in.txt"));
    }

    @Test
    void solve_1K() throws IOException {
        generatePoints(1000);
        assertEquals(m.solve("\\src\\in.txt"), m.solveBruteForce("\\src\\in.txt"));
    }

    @Test
    void solve_10K() throws IOException {
        generatePoints(10000);
        assertEquals(m.solve("\\src\\in.txt"), m.solveBruteForce("\\src\\in.txt"));
    }

    @Test
    void solve_100K() throws IOException {
        generatePoints(100000);
        assertEquals(m.solve("\\src\\in.txt"), m.solveBruteForce("\\src\\in.txt"));
    }

    @Test
    void solve_in1() {
        assertEquals(m.solve("\\src\\in1- ans = 6026.txt"), 6026);
    }
    @Test
    void solve_in2() {
        assertEquals(m.solve("\\src\\in2- ans = 840.txt"), 840);
    }
    @Test
    void solve_in3() {
        assertEquals(m.solve("\\src\\in3- ans = 217.txt"), 217);
    }
    @Test
    void solve_in4() {
        assertEquals(m.solve("\\src\\in5- ans = 11.txt"), 11);
    }



//    @Test
//    void solve_1M() throws IOException {
//        generatePoints(1000000);
//        assertEquals(m.solve("\\src\\in.txt"), m.solveBruteForce("\\src\\in.txt"));
//    }

//    @Test
//    void solve_10M() throws IOException {
//        generatePoints(10000000);
//        assertEquals(m.solve("\\src\\in.txt"), m.solveBruteForce("\\src\\in.txt"));
//    }

    @Test
    void closestPoints() {

    }

    @Test
    void bruteForce() {
    }

    @Test
    void distance() {
    }
}