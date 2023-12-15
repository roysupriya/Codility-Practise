/* 
Problem: https://app.codility.com/programmers/lessons/4-counting_elements/frog_river_one/
Results: 
 - 18% https://app.codility.com/demo/results/trainingW84R5P-KBM/
 - 27% https://app.codility.com/demo/results/training8UKYYV-2P6/
 - 100% Double pass: https://app.codility.com/demo/results/trainingNR67NS-G8B/
 - 100% - Single pass: https://app.codility.com/demo/results/trainingDCDRPU-PEH/

A small frog wants to get to the other side of a river. The frog is initially located on one bank of the river (position 0) and wants to get to the opposite bank (position X+1). Leaves fall from a tree onto the surface of the river.

You are given an array A consisting of N integers representing the falling leaves. A[K] represents the position where one leaf falls at time K, measured in seconds.

The goal is to find the earliest time when the frog can jump to the other side of the river. The frog can cross only when leaves appear at every position across the river from 1 to X (that is, we want to find the earliest moment when all the positions from 1 to X are covered by leaves). You may assume that the speed of the current in the river is negligibly small, i.e. the leaves do not change their positions once they fall in the river.

For example, you are given integer X = 5 and array A such that:

  A[0] = 1
  A[1] = 3
  A[2] = 1
  A[3] = 4
  A[4] = 2
  A[5] = 3
  A[6] = 5
  A[7] = 4
In second 6, a leaf falls into position 5. This is the earliest time when leaves appear in every position across the river.

Write a function:

class Solution { public int solution(int X, int[] A); }

that, given a non-empty array A consisting of N integers and integer X, returns the earliest time when the frog can jump to the other side of the river.

If the frog is never able to jump to the other side of the river, the function should return −1.

For example, given X = 5 and array A such that:

  A[0] = 1
  A[1] = 3
  A[2] = 1
  A[3] = 4
  A[4] = 2
  A[5] = 3
  A[6] = 5
  A[7] = 4
the function should return 6, as explained above.

Write an efficient algorithm for the following assumptions:

N and X are integers within the range [1..100,000];
each element of array A is an integer within the range [1..X].
*/

// Time: O(N), Space: O(N) - Double Pass
// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int X, int[] A) {
        // Implement your solution here

        HashSet<Integer> set = new HashSet<>();

        // Add all the sequential positions in set
        for(int i=1; i<=X; i++){
            set.add(i);
        }

        // For every position encountered in the array, remove from set if exists
        // When set is empty after removal, the index is our ans
        for(int i=0; i<A.length; i++){
            // Remove the position in set if exists
            if(set.size() != 0 && set.contains(A[i])){
                set.remove(A[i]);
            }
            
            // Return index is set is empty
            if (set.size() == 0){
                return i;
            }
        }

        // If set was not emptied, some seconds were never found when leaf fell on the position
        return -1;
    }
}


// Single Pass
// Time: O(N), Space: O(N)
// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int X, int[] A) {
        // Implement your solution here

        // Single pass
        HashSet<Integer> set = new HashSet<>();

        // Add to set, and after each addition check whether we have completed all positions addition, if so return index;
        for(int i=0; i<A.length; i++){
            set.add(A[i]);

            if(set.size() == X){
                return i;
            }
        }

        // If set was not emptied, some seconds were never found when leaf fell on the position
        return -1;
    }
}
