package weightedActivityDP;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class WeightedActivitySelection {
    private static class Activity <T>{
        private final T start;
        private final T end;
        private final T weight;
        Activity(T start, T end, T weight){
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        public T getStart() {return start;}
        public T getEnd() {return end;}
        public T getWeight(){return weight;}
    }
    public Long solve(String filePath) {
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            int n = scanner.nextInt();
            Activity<Long>[] activities = new Activity[n];
            for (int i = 0; i < n; i++)
                activities[i] = new Activity<>(scanner.nextLong(), scanner.nextLong(), scanner.nextLong());

            Arrays.sort(activities, Comparator.comparing(p -> p.end));

            long[] activityEndingTimesSorted = new long[n];
            for(int i = 0;i < n;i++)
                activityEndingTimesSorted[i] = activities[i].getEnd();

            return selectMaxWeight(activities, activityEndingTimesSorted, n);

        } catch (FileNotFoundException e) {
            return null;
        }
    }

    private long selectMaxWeight(Activity<Long>[] activities, long[] endings, int size) {
        long[] dp = new long[size];
        Arrays.fill(dp, -1);

        return recursiveDP(size-1, activities, endings, dp);
    }

    private long recursiveDP(int i, Activity<Long>[] activities, long[] endings, long[] dp) {
        if(i == -1)
            return 0;
        if(dp[i] != -1)
            return dp[i];

        int index = findUpperBound(endings, activities[i].getStart());
        if(activities[index].getEnd() > activities[i].getStart())
            index--;


        long take = recursiveDP(index, activities, endings, dp) + activities[i].getWeight();
        long leave = recursiveDP(i-1, activities, endings, dp);

        return dp[i] = Math.max(take, leave);
    }

    int findUpperBound(long[] array, long value){
        int low = 0;
        int high = array.length-1;

        int ans = -1;
        while(low <= high){
            int mid = low + (high - low) / 2;

            if(array[mid] <= value)
                low = mid+1;

            else{
                ans = mid;
                high = mid-1;
            }
        }

        return ans;
    }
}
