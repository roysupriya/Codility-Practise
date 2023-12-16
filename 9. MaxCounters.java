/*
Problem: https://app.codility.com/programmers/lessons/4-counting_elements/max_counters/
Result: Brute force - 77% https://app.codility.com/demo/results/trainingF26ED9-9AW/
Resule: Efficient (2 pass) -100% https://app.codility.com/demo/results/trainingN7RC8P-AAT/

Time: O(M), Space: O(N)

You are given N counters, initially set to 0, and you have two possible operations on them:

increase(X) − counter X is increased by 1,
max counter − all counters are set to the maximum value of any counter.
A non-empty array A of M integers is given. This array represents consecutive operations:

if A[K] = X, such that 1 ≤ X ≤ N, then operation K is increase(X),
if A[K] = N + 1 then operation K is max counter.
For example, given integer N = 5 and array A such that:

    A[0] = 3
    A[1] = 4
    A[2] = 4
    A[3] = 6
    A[4] = 1
    A[5] = 4
    A[6] = 4
the values of the counters after each consecutive operation will be:

    (0, 0, 1, 0, 0)
    (0, 0, 1, 1, 0)
    (0, 0, 1, 2, 0)
    (2, 2, 2, 2, 2)
    (3, 2, 2, 2, 2)
    (3, 2, 2, 3, 2)
    (3, 2, 2, 4, 2)
The goal is to calculate the value of every counter after all operations.

Write a function:

class Solution { public int[] solution(int N, int[] A); }

that, given an integer N and a non-empty array A consisting of M integers, returns a sequence of integers representing the values of the counters.

Result array should be returned as an array of integers.

For example, given:

    A[0] = 3
    A[1] = 4
    A[2] = 4
    A[3] = 6
    A[4] = 1
    A[5] = 4
    A[6] = 4
the function should return [3, 2, 2, 4, 2], as explained above.

Write an efficient algorithm for the following assumptions:

N and M are integers within the range [1..100,000];
each element of array A is an integer within the range [1..N + 1].
*/

// Time: O(M), Space: O(N)
// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int[] solution(int N, int[] A) {
        // Create a new array counter of N length
        int[] counter = new int[N];

        // Maintain the current max to apply whenever N + 1 is encountered
        int max = 0;

        // Maintain the min value updated with the last max each element should be updated to if value is less than it 
        int min = 0;

        // Traverse the input array A and increment counters
        for(int i=0; i<A.length; i++){
            if(A[i] >= 1 && A[i] <= N){  // Normal case
                // First incremenent it to the last found min (which is last max when N+1 was encountered)
                if(counter[A[i]-1] < min) {
                    counter[A[i]-1] = min;
                }

                counter[A[i]-1]++; // Increment by 1

                if(counter[A[i]-1] > max) { // Update max
                    max = counter[A[i]-1];
                }
            } 
            else if (A[i] == N+1) { // Special case
                // Avoid 2nd loop to update all of B's element to max counter. It's too slow

                // Maintain min instead to be updated outside in 2nd pass for loop
                min = max;                
            }            
        }

        // Outer 2nd loop, check for values less than min (the last max) which each element should be at the least if lesser than this
        for(int i=0; i<counter.length; i++){
            if(counter[i] < min){
                counter[i] = min;
            }
        }

        return counter;
    }
}

