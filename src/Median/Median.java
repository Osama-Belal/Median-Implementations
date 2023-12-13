package Median;

import java.util.Arrays;
import java.util.HashMap;

public class Median <T extends Comparable<T>>{

    static final int MedianOfMedians = 1;
    static final int DivideAndConquer = 2;

    HashMap<Long, Integer> indexMap = new HashMap<>();

    public long solveDivideAndConquer(long[] arr) {
        for (int i = 0; i < arr.length; i++) indexMap.put(arr[i], i);
        return findMedian(arr, 0, arr.length, DivideAndConquer);
    }

    public long solveMedianOfMedians(long[] arr) {
        for (int i = 0; i < arr.length; i++) indexMap.put(arr[i], i);
        return findMedian(arr, 0, arr.length, MedianOfMedians);
    }

    private long findMedian(long[] arr, int start, int end, int method) {
        int k = (arr.length - 1) / 2;
        if(start == end){
            return arr[start];
        }

        int pivot = (method == DivideAndConquer ? getPivotRandom(start, end) :
                getIndexOf(arr, getPivotDeterministic(arr, start, end), start, end));
        int rank = partitionAroundPivot(arr, start, end, pivot);

        if(rank == k){
            return arr[rank];
        }
        else if(rank < k){
            return findMedian(arr, rank + 1, end, method);
        }
        else {
            return findMedian(arr, start, rank, method);
        }
    }

    private int getIndexOf(long[] arr, long val, int start, int end) {
        for(int i = start; i < end; i++){
            if(arr[i] == val){
                return i;
            }
        }
        return -1;
    }

    private int getPivotRandom(int start, int end){
        return (int) (Math.random() * (end - start - 1) + start);
    }

    private long getPivotDeterministic(long[] arr, int start, int end){
        long[] medians = new long[(end - start + 4) / 5];
        long[] temp = new long[5];

        for(int i = start; i < end; i += 5) {
            for(int j = i;j < Math.min(i+5, end);j++){
                temp[j-i] = arr[j];
            }
            Long median = findMedianSorted(temp, Math.min(i+5, end) - i);
            medians[(i - start)/5] = median;
        }

        if(medians.length <= 5){
            return findMedianSorted(medians, medians.length);
        }
        else {
            return getPivotDeterministic(medians, 0, medians.length);
        }
    }

    private Long findMedianSorted(long[] arr, int limit) {
        Arrays.sort(arr, 0, limit);
        return arr[(limit - 1) / 2];
    }


    private int partitionAroundPivot(long[] arr, int start, int end, int pivotIndex) {
        long pivot = arr[pivotIndex];
        int pivotLocation = pivotIndex;

        for(int i = start; i < pivotLocation; i++) {
            while(i < pivotLocation && arr[i] > pivot){
                // swap two values
                long temp = arr[i];
                arr[i] = arr[pivotLocation-1];
                arr[pivotLocation-1] = temp;

                // swap two values
                temp = arr[pivotLocation-1];
                arr[pivotLocation-1] = arr[pivotLocation];
                arr[pivotLocation] = temp;

                pivotLocation--;
            }
        }

        for(int i = pivotIndex+1; i < end; i++) {
            while(i > pivotLocation && arr[i] < pivot){
                // swap two values
                long temp = arr[i];
                arr[i] = arr[pivotLocation+1];
                arr[pivotLocation+1] = temp;

                // swap two values
                temp = arr[pivotLocation+1];
                arr[pivotLocation+1] = arr[pivotLocation];
                arr[pivotLocation] = temp;

                pivotLocation++;
            }
        }

        return pivotLocation;
    }

}
