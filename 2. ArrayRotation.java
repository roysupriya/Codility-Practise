/* Results: https://app.codility.com/demo/results/training3U822J-4X3/
An array A consisting of N integers is given. Rotation of the array means that each element is shifted right by one index, and the last element of the array is moved to the first place. For example, the rotation of array A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7] (elements are shifted right by one index and 6 is moved to the first place).

The goal is to rotate array A K times; that is, each element of A will be shifted to the right K times.

Write a function:

class Solution { public int[] solution(int[] A, int K); }

that, given an array A consisting of N integers and an integer K, returns the array A rotated K times.

For example, given

    A = [3, 8, 9, 7, 6]
    K = 3
the function should return [9, 7, 6, 3, 8]. Three rotations were made:

    [3, 8, 9, 7, 6] -> [6, 3, 8, 9, 7]
    [6, 3, 8, 9, 7] -> [7, 6, 3, 8, 9]
    [7, 6, 3, 8, 9] -> [9, 7, 6, 3, 8]
For another example, given

    A = [0, 0, 0]
    K = 1
the function should return [0, 0, 0]

Given

    A = [1, 2, 3, 4]
    K = 4
the function should return [1, 2, 3, 4]

Assume that:

N and K are integers within the range [0..100];
each element of array A is an integer within the range [−1,000..1,000].
In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.
*/

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int[] solution(int[] A, int K) {
        // Implement your solution here        

         // Corner cases when  A has 1 element
        if(A.length <= 1) {
            return A;
        }

        K = K % A.length;

         // Corner cases when number of rotations will result in same array
        if(K == 0){
            return A;
        }    
        
        int[] B = new int[A.length];

        for(int i = 0; i<A.length; i++) {

            // Get the rotated indexes;
            int rotatedIndex = i+K;  

            // Check for case when element needs to be rotated to the front of the array     
            if(rotatedIndex >= A.length)
            {
                rotatedIndex = rotatedIndex - A.length;
            }

            //Store in the new array based on rotated index found
            B[rotatedIndex] = A[i];
        }

        //Return the new array
        return B;        
    }
}
