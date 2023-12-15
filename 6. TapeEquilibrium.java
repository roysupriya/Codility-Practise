/*
Problem: https://app.codility.com/programmers/lessons/3-time_complexity/tape_equilibrium/
Results (Brute force): nested loop: https://app.codility.com/demo/results/trainingXWQBZC-3XU/
Results (Efficient): 2 pass: https://app.codility.com/demo/results/trainingV37AHT-S6Q/

A non-empty array A consisting of N integers is given. Array A represents numbers on a tape.

Any integer P, such that 0 < P < N, splits this tape into two non-empty parts: A[0], A[1], ..., A[P − 1] and A[P], A[P + 1], ..., A[N − 1].

The difference between the two parts is the value of: |(A[0] + A[1] + ... + A[P − 1]) − (A[P] + A[P + 1] + ... + A[N − 1])|

In other words, it is the absolute difference between the sum of the first part and the sum of the second part.

For example, consider array A such that:

  A[0] = 3
  A[1] = 1
  A[2] = 2
  A[3] = 4
  A[4] = 3
We can split this tape in four places:

P = 1, difference = |3 − 10| = 7
P = 2, difference = |4 − 9| = 5
P = 3, difference = |6 − 7| = 1
P = 4, difference = |10 − 3| = 7
Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty array A of N integers, returns the minimal difference that can be achieved.

For example, given:

  A[0] = 3
  A[1] = 1
  A[2] = 2
  A[3] = 4
  A[4] = 3
the function should return 1, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [2..100,000];
each element of array A is an integer within the range [−1,000..1,000].
  */

// you can also use imports, for example:
import java.util.*;
import java.lang.Math;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // Implement your solution here
        
        // Efficient. Time: O(N), Space: O(1)

        // Corner case
        if (A.length == 2){
            return A[1] - A[0];
        }

        // In first pass, get second half sum from 2nd element onwards, and first half sum as first element only
        int sumFirstHalf = A[0];
        int sumSecondHalf = 0;

        for(int p=1; p<=A.length-1; p++){    
            sumSecondHalf += A[p];
        }
        
        // Store current diff
        int minDiff = Math.abs(sumFirstHalf - sumSecondHalf);

        // In second pass, for each element add to first half, subtract from 2nd half, and check diff, and compare with prev calculated diff so far for min
        for(int p=1; p<=A.length-2; p++){            
            sumFirstHalf += A[p];
            sumSecondHalf -= A[p];
            int currentDiff = Math.abs(sumFirstHalf - sumSecondHalf);

            if(minDiff > currentDiff){
                minDiff = currentDiff;
            }
        }

        // Return the min diff
        return minDiff;
    }
}
