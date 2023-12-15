/*
Problem: https://app.codility.com/programmers/lessons/3-time_complexity/perm_missing_elem/
Result: https://app.codility.com/demo/results/trainingXD3T4W-TWT/

An array A consisting of N different integers is given. The array contains integers in the range [1..(N + 1)], which means that exactly one element is missing.

Your goal is to find that missing element.

Write a function:

class Solution { public int solution(int[] A); }

that, given an array A, returns the value of the missing element.

For example, given array A such that:

  A[0] = 2
  A[1] = 3
  A[2] = 1
  A[3] = 5
the function should return 4, as it is the missing element.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [0..100,000];
the elements of A are all distinct;
each element of array A is an integer within the range [1..(N + 1)].
 */
// Time: O(N)
// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int [] A) {
        // Implement your solution here

        // Corner case
        if(A.length == 0) {
            return 1;
        }

        // Find current sum and subtract with project sum of N+1 integers to get result
        
        double currentSum = 0;
        for(int i=0; i<A.length; i++) {
            currentSum += A[i];
        }

        double projectedSum = ((A.length + 1)/2.0) * ((A.length + 1) + 1);
        
        return  (int) (projectedSum - currentSum);
    }    
}
