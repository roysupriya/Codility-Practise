/*
Problem: https://app.codility.com/programmers/lessons/5-prefix_sums/count_div/
Results: https://app.codility.com/demo/results/trainingCUYA35-XB9/
Complexity: O(1) Using maths logic

Write a function:

class Solution { public int solution(int A, int B, int K); }

that, given three integers A, B and K, returns the number of integers within the range [A..B] that are divisible by K, i.e.:

{ i : A ≤ i ≤ B, i mod K = 0 }

For example, for A = 6, B = 11 and K = 2, your function should return 3, because there are three numbers divisible by 2 within the range [6..11], namely 6, 8 and 10.

Write an efficient algorithm for the following assumptions:

A and B are integers within the range [0..2,000,000,000];
K is an integer within the range [1..2,000,000,000];
A ≤ B.
*/

// import java.util.*;

class Solution {
    public int solution(int A, int B, int K) {
        
        /* Brute force: Traverse the elements from A to B while checking divisibility by 2 with mod operator
            Time: O(B-A), Space: O(1)

           Efficient approach: Using Slicing concept and math operations.
                Ans = B/K - A/K + 1 (if A is also dividable)
                Explanation: 
                    B/K = All divisible numbers till B
                    A/K = All divisible numbers till A
                    B/K - A/K gives all divisibles (A..B] 
                    The subtraction gets the A excluded
                    re-check to consider A, check A%K == 0, and if so add 1
        */

        int divCount = 0;
        int numDivisibleTillB = B/K;
        int numDivisibleTillA = A/K;

        divCount = numDivisibleTillB - numDivisibleTillA;

        if(A%K == 0){
            divCount++;
        }

        return divCount;
    }
}
