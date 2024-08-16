package org.example.greedy;

import java.util.Arrays;
import java.util.Comparator;

/*
Assume there exist n activities with each of them being represented by a start time
 si and finish time fi. Two activities i and j are said to be non-conflicting
  if si ≥ fj or sj ≥ fi. The activity selection problem consists in finding
   the maximal solution set (S) of non-conflicting activities,
    or more precisely there must exist no solution
     set S' such that |S'| > |S| in the case that multiple maximal solutions
      have equal sizes.
Time Complexity: O(n log n) due to sorting
Space Complexity: O(n)
 */
class ActivitySelection {
    public static void selectActivities(int[] start, int[] finish) {
        int n = start.length;
        int[][] activities = new int[n][2];

        for (int i = 0; i < n; i++) {
            activities[i][0] = start[i];
            activities[i][1] = finish[i];
        }

        Arrays.sort(activities, Comparator.comparingInt(a -> a[1]));

        int lastFinish = activities[0][1];
        System.out.println("Selected Activity: " + Arrays.toString(activities[0]));

        for (int i = 1; i < n; i++) {
            if (activities[i][0] >= lastFinish) {
                System.out.println("Selected Activity: " + Arrays.toString(activities[i]));
                lastFinish = activities[i][1];
            }
        }
    }

    public static void main(String[] args) {
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] finish = {2, 4, 6, 7, 9, 9};
        selectActivities(start, finish);
    }
}

