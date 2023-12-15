/*
Problem: https://app.codility.com/programmers/lessons/4-counting_elements/perm_check/
Results: Single pass - https://app.codility.com/demo/results/trainingSTNJW9-GCW/

A non-empty array A consisting of N integers is given.
A permutation is a sequence containing each element from 1 to N once, and only once.

For example, array A such that:

    A[0] = 4
    A[1] = 1
    A[2] = 3
    A[3] = 2
is a permutation, but array A such that:

    A[0] = 4
    A[1] = 1
    A[2] = 3
is not a permutation, because value 2 is missing.

The goal is to check whether array A is a permutation.

Write a function:

class Solution { public int solution(int[] A); }

that, given an array A, returns 1 if array A is a permutation and 0 if it is not.

For example, given array A such that:

    A[0] = 4
    A[1] = 1
    A[2] = 3
    A[3] = 2
the function should return 1.

Given array A such that:

    A[0] = 4
    A[1] = 1
    A[2] = 3
the function should return 0.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [1..1,000,000,000].
*/

// Time: O(N), Space: O(N)
import java.util.*;

class Solution {
    public int solution(int[] A) { 

        /* To check permutation in single pass
            1. Traverse the array while checking
                1.a. If set already has the element, return 0 from there
                1.b. If set doesn't have the element yet, add it to set
                1.c. Also calculate the max element in the array
            2. After the array traversal the perm check is false if either of below:
                2.a. If size of set is not the max element found, or
                2.b. If size of set is not same as size of Array length
            3. After the above check if control is still in the code, it means we have met success criteria
        */

        Set<Integer> set = new HashSet<>();

        int max = -1;

        // Traverse array, add in set if not already existing, else return 0 if duplicate encountered
        for(int i=0; i<A.length; i++){
            if(set.contains(A[i])){
                return 0;
            } else {
                set.add(A[i]);
            }

            // Calculate max value in array to check later
            if(max < A[i])
                max = A[i];
        }

        // Set size not same as max value or not same as array length indicates its not perm
        if(set.size() != max || set.size() != A.length){
            return 0;
        }

        return 1;
    }
}
