package Median;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class MedianTest {
    private static long[] generateArray(int size) {
        long[] arr = new long[size];
        for (int i = 0; i < size; i++) {
            arr[i] = ((long) (Math.random() * 100000000));
        }
        return arr;
    }

    Median m = new Median();

    private final long[] arr_10 = generateArray(10);
    private final long[] arr_100 = generateArray(100);
    private final long[] arr_1k = generateArray(1000);
    private final long[] arr_1M = generateArray(1000000);
    private final long[] arr_10M = generateArray(10000000);

    @Test
    void solve() {
        int n = 15;
        double avg_d = 0;
        double avg_m = 0;
        double avg_s = 0;
        for (int i = 0; i < n; i++) {
            long[] time = time_1M();
            avg_d += (double) time[0] / n;
            avg_m += (double) time[1] / n;
            avg_s += (double) time[2] / n;
        }
        System.out.println("Average time of divide and conquer 10 elements: " + avg_d + " ms");
        System.out.println("Average time of median of medians 10 elements: " + avg_m + " ms");
        System.out.println("Average time of sorting 10 elements: " + avg_s + " ms");
    }

    @Test
    void divideAndConquer_10() {
        Long median = m.solveDivideAndConquer(arr_10);

        long[] arr_10_sorted = new long[arr_10.length];
        System.arraycopy(arr_10, 0, arr_10_sorted, 0, arr_10.length);
        Arrays.sort(arr_10_sorted);
        Assertions.assertEquals(arr_10_sorted[(arr_10.length - 1) / 2], median);
    }


    @Test
    void divideAndConquer_100() {
        Long median = m.solveDivideAndConquer(arr_100);

        long[] arr_100_sorted = new long[arr_100.length];
        System.arraycopy(arr_100, 0, arr_100_sorted, 0, arr_100.length);
        Arrays.sort(arr_100_sorted);
        Assertions.assertEquals(arr_100_sorted[(arr_100.length - 1) / 2], median);
    }


    @Test
    void divideAndConquer_1k() {
        Long median = m.solveDivideAndConquer(arr_1k);

        long[] arr_1k_sorted = new long[arr_1k.length];
        System.arraycopy(arr_1k, 0, arr_1k_sorted, 0, arr_1k.length);
        Arrays.sort(arr_1k_sorted);
        Assertions.assertEquals(arr_1k_sorted[(arr_1k.length - 1) / 2], median);
    }


    @Test
    void divideAndConquer_1M() {
        Long median = m.solveDivideAndConquer(arr_1M);

        long[] arr_1M_sorted = new long[arr_1M.length];
        System.arraycopy(arr_1M, 0, arr_1M_sorted, 0, arr_1M.length);
        Arrays.sort(arr_1M_sorted);
        Assertions.assertEquals(arr_1M_sorted[(arr_1M.length - 1) / 2], median);
    }


    @Test
    void divideAndConquer_10M() {
        Long median = m.solveDivideAndConquer(arr_10M);

        long[] arr_10M_sorted = new long[arr_10M.length];
        System.arraycopy(arr_10M, 0, arr_10M_sorted, 0, arr_10M.length);
        Arrays.sort(arr_10M_sorted);
        Assertions.assertEquals(arr_10M_sorted[(arr_10M.length - 1) / 2], median);
    }

    @Test
    void medianOfMedians_10() {
        Long median = m.solveMedianOfMedians(arr_10);

        long[] arr_10_sorted = new long[arr_10.length];
        System.arraycopy(arr_10, 0, arr_10_sorted, 0, arr_10.length);
        Arrays.sort(arr_10_sorted);
        Assertions.assertEquals(arr_10_sorted[(arr_10.length - 1) / 2], median);
    }


    @Test
    void medianOfMedians_100() {
        Long median = m.solveMedianOfMedians(arr_100);

        long[] arr_100_sorted = new long[arr_100.length];
        System.arraycopy(arr_100, 0, arr_100_sorted, 0, arr_100.length);
        Arrays.sort(arr_100_sorted);
        Assertions.assertEquals(arr_100_sorted[(arr_100.length - 1) / 2], median);
    }


    @Test
    void medianOfMedians_1k() {
        Long median = m.solveMedianOfMedians(arr_1k);

        long[] arr_1k_sorted = new long[arr_1k.length];
        System.arraycopy(arr_1k, 0, arr_1k_sorted, 0, arr_1k.length);
        Arrays.sort(arr_1k_sorted);
        Assertions.assertEquals(arr_1k_sorted[(arr_1k.length - 1) / 2], median);
    }


    @Test
    void medianOfMedians_1M() {
        Long median = m.solveMedianOfMedians(arr_1M);

        long[] arr_1M_sorted = new long[arr_1M.length];
        System.arraycopy(arr_1M, 0, arr_1M_sorted, 0, arr_1M.length);
        Arrays.sort(arr_1M_sorted);
        Assertions.assertEquals(arr_1M_sorted[(arr_1M.length - 1) / 2], median);
    }


    @Test
    void medianOfMedians_10M() {
        Long median = m.solveMedianOfMedians(arr_10M);

        long[] arr_10M_sorted = new long[arr_10M.length];
        System.arraycopy(arr_10M, 0, arr_10M_sorted, 0, arr_10M.length);
        Arrays.sort(arr_10M_sorted);
        Assertions.assertEquals(arr_10M_sorted[(arr_10M.length - 1) / 2], median);
    }


    @Test
    long[] time_10() {
        long start, end;
        long[] time = new long[3];

        long[] arr = generateArray(10);
        long[] arr_1 = new long[arr.length];
        long[] arr_2 = new long[arr.length];

        System.arraycopy(arr, 0, arr_1, 0, arr.length);
        System.arraycopy(arr, 0, arr_2, 0, arr.length);

        start = System.nanoTime();
        long median_d = m.solveDivideAndConquer(arr_1);
        end = System.nanoTime();
        time[0] = end - start;
        System.out.println("Time of divide and conquer 10 elements: " + (end - start) + " ns");

        start = System.nanoTime();
        long median_m = m.solveMedianOfMedians(arr_2);
        end = System.nanoTime();
        time[1] = end - start;
        System.out.println("Time of median of medians 10 elements: " + (end - start) + " ns");

        start = System.nanoTime();
        Arrays.sort(arr);
        long median_s = arr[(arr.length - 1) / 2];
        end = System.nanoTime();
        time[2] = end - start;
        System.out.println("Time of sorting 10 elements: " + (end - start) + " ns");

        Assertions.assertEquals(median_s, median_d);
        Assertions.assertEquals(median_s, median_m);
        return time;
    }

    @Test
    long[] time_100() {
        long start, end;

        long[] time = new long[3];

        long[] arr = generateArray(100);
        long[] arr_1 = new long[arr.length];
        long[] arr_2 = new long[arr.length];

        System.arraycopy(arr, 0, arr_1, 0, arr.length);
        System.arraycopy(arr, 0, arr_2, 0, arr.length);

        start = System.nanoTime();
        long median_d = m.solveDivideAndConquer(arr_1);
        end = System.nanoTime();
        time[0] = end - start;
        System.out.println("Time of divide and conquer 100 elements: " + (end - start) + " ns");

        start = System.nanoTime();
        long median_m = m.solveMedianOfMedians(arr_2);
        end = System.nanoTime();
        time[1] = end - start;
        System.out.println("Time of median of medians 100 elements: " + (end - start) + " ns");

        start = System.nanoTime();
        Arrays.sort(arr);
        long median_s = arr[(arr.length - 1) / 2];
        end = System.nanoTime();
        time[2] = end - start;
        System.out.println("Time of sorting 100 elements: " + (end - start) + " ns");

        Assertions.assertEquals(median_s, median_d);
        Assertions.assertEquals(median_s, median_m);
        return time;
    }

    @Test
    long[] time_1k() {
        long start, end;

        long[] time = new long[3];

        long[] arr = generateArray(1000);
        long[] arr_1 = new long[arr.length];
        long[] arr_2 = new long[arr.length];

        System.arraycopy(arr, 0, arr_1, 0, arr.length);
        System.arraycopy(arr, 0, arr_2, 0, arr.length);

        start = System.nanoTime();
        long median_d = m.solveDivideAndConquer(arr_1);
        end = System.nanoTime();
        time[0] = end - start;
        System.out.println("Time of divide and conquer 1k elements: " + (end - start) + " ns");

        start = System.nanoTime();
        long median_m = m.solveMedianOfMedians(arr_2);
        end = System.nanoTime();
        time[1] = end - start;
        System.out.println("Time of median of medians 1k elements: " + (end - start) + " ns");

        start = System.nanoTime();
        Arrays.sort(arr);
        long median_s = arr[(arr.length - 1) / 2];
        end = System.nanoTime();
        time[2] = end - start;
        System.out.println("Time of sorting 1k elements: " + (end - start) + " ns");

        Assertions.assertEquals(median_s, median_d);
        Assertions.assertEquals(median_s, median_m);
        return time;
    }

    @Test
    long[] time_10k() {
        long start, end;

        long[] time = new long[3];

        long[] arr = generateArray(10000);
        long[] arr_1 = new long[arr.length];
        long[] arr_2 = new long[arr.length];

        System.arraycopy(arr, 0, arr_1, 0, arr.length);
        System.arraycopy(arr, 0, arr_2, 0, arr.length);

        start = System.nanoTime();
        long median_d = m.solveDivideAndConquer(arr_1);
        end = System.nanoTime();
        time[0] = end - start;
        System.out.println("Time of divide and conquer 1k elements: " + (end - start) + " ns");

        start = System.nanoTime();
        long median_m = m.solveMedianOfMedians(arr_2);
        end = System.nanoTime();
        time[1] = end - start;
        System.out.println("Time of median of medians 1k elements: " + (end - start) + " ns");

        start = System.nanoTime();
        Arrays.sort(arr);
        long median_s = arr[(arr.length - 1) / 2];
        end = System.nanoTime();
        time[2] = end - start;
        System.out.println("Time of sorting 1k elements: " + (end - start) + " ns");

        Assertions.assertEquals(median_s, median_d);
        Assertions.assertEquals(median_s, median_m);

        return time;
    }

    @Test
    long[] time_100k() {
        long start, end;

        long[] time = new long[3];

        long[] arr = generateArray(100000);
        long[] arr_1 = new long[arr.length];
        long[] arr_2 = new long[arr.length];

        System.arraycopy(arr, 0, arr_1, 0, arr.length);
        System.arraycopy(arr, 0, arr_2, 0, arr.length);

        start = System.currentTimeMillis();
        long median_d = m.solveDivideAndConquer(arr_1);
        end = System.currentTimeMillis();
        time[0] = end - start;
        System.out.println("Time of divide and conquer 1k elements: " + (end - start) + " ms");

        start = System.currentTimeMillis();
        long median_m = m.solveMedianOfMedians(arr_2);
        end = System.currentTimeMillis();
        time[1] = end - start;
        System.out.println("Time of median of medians 1k elements: " + (end - start) + " ms");

        start = System.currentTimeMillis();
        Arrays.sort(arr);
        long median_s = arr[(arr.length - 1) / 2];
        end = System.currentTimeMillis();
        time[2] = end - start;
        System.out.println("Time of sorting 1k elements: " + (end - start) + " ms");

        Assertions.assertEquals(median_s, median_d);
        Assertions.assertEquals(median_s, median_m);
        return time;
    }

    @Test
    long[] time_1M() {
        long start, end;

        long[] time = new long[3];

        long[] arr = generateArray(1000000);
        long[] arr_1 = new long[arr.length];
        long[] arr_2 = new long[arr.length];

        System.arraycopy(arr, 0, arr_1, 0, arr.length);
        System.arraycopy(arr, 0, arr_2, 0, arr.length);

        start = System.currentTimeMillis();
        long median_d = m.solveDivideAndConquer(arr_1);
        end = System.currentTimeMillis();
        time[0] = end - start;
        System.out.println("Time of divide and conquer 1M elements: " + (end - start) + " ms");

        start = System.currentTimeMillis();
        long median_m = m.solveMedianOfMedians(arr_2);
        end = System.currentTimeMillis();
        time[1] = end - start;
        System.out.println("Time of median of medians 1M elements: " + (end - start) + " ms");

        start = System.currentTimeMillis();
        Arrays.sort(arr);
        long median_s = arr[(arr.length - 1) / 2];
        end = System.currentTimeMillis();
        time[2] = end - start;
        System.out.println("Time of sorting 1M elements: " + (end - start) + " ms");

        Assertions.assertEquals(median_s, median_d);
        Assertions.assertEquals(median_s, median_m);

        return time;
    }

    @Test
    long[] time_10M() {
        long start, end;

        long[] time = new long[3];

        long[] arr = generateArray(10000000);
        long[] arr_1 = new long[arr.length];
        long[] arr_2 = new long[arr.length];

        System.arraycopy(arr, 0, arr_1, 0, arr.length);
        System.arraycopy(arr, 0, arr_2, 0, arr.length);

        start = System.currentTimeMillis();
        long median_d = m.solveDivideAndConquer(arr_1);
        end = System.currentTimeMillis();
        time[0] = end - start;
        System.out.println("Time of divide and conquer 10M elements: " + (end - start) + " ms");

        start = System.currentTimeMillis();
        long median_m = m.solveMedianOfMedians(arr_2);
        end = System.currentTimeMillis();
        time[1] = end - start;
        System.out.println("Time of median of medians 10M elements: " + (end - start) + " ms");

        start = System.currentTimeMillis();
        Arrays.sort(arr);
        long median_s = arr[(arr.length - 1) / 2];
        end = System.currentTimeMillis();
        time[2] = end - start;
        System.out.println("Time of sorting 10M elements: " + (end - start) + " ms");

        Assertions.assertEquals(median_s, median_d);
        Assertions.assertEquals(median_s, median_m);

        return time;
    }
}