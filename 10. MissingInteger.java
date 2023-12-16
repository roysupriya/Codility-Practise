/*
(Reattempting as part of lessons)
Problem: https://app.codility.com/programmers/lessons/4-counting_elements/missing_integer/
Results: https://app.codility.com/demo/results/training6Q8TNJ-GQA/

Write a function:

class Solution { public int solution(int[] A); }

that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

Given A = [1, 2, 3], the function should return 4.

Given A = [−1, −3], the function should return 1.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−1,000,000..1,000,000].
*/

// Time: O(N), Space: O(N)
// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        // Implement your solution here

        Set<Integer> uniqueIntegers = new HashSet<>();
        for(int i = 0; i<A.length; i++){  // or can do for (int item : A)
            uniqueIntegers.add(A[i]);
        }

        for(int i = 1; i<=A.length+1; i++){
            if(!uniqueIntegers.contains(i))
                return i;
        }

        return -1; // doesn't matter what we return, control never reaches here. Adding to avoid compiler error
    }
}
