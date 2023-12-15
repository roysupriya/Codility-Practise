/* 
https://app.codility.com/demo/results/training97MT3U-45T/
A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is surrounded by ones at both ends in the binary representation of N.
For example, number 9 has binary representation 1001 and contains a binary gap of length 2. The number 529 has binary representation 1000010001 and contains two binary gaps: one of length 4 and one of length 3. The number 20 has binary representation 10100 and contains one binary gap of length 1. The number 15 has binary representation 1111 and has no binary gaps. The number 32 has binary representation 100000 and has no binary gaps.

Write a function:
class Solution { public int solution(int N); }
that, given a positive integer N, returns the length of its longest binary gap. The function should return 0 if N doesn't contain a binary gap.
For example, given N = 1041 the function should return 5, because N has binary representation 10000010001 and so its longest binary gap is of length 5. Given N = 32 the function should return 0, because N has binary representation '100000' and thus no binary gaps.
Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..2,147,483,647].

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int N) {
        // Implement your solution here
        
        boolean prevfound1 = false;
        boolean binaryGap = false;
        int binaryGapSize = 0;
        int maxBinaryGap = 0;

        while(N>0) {
            //Divide by 2 to get next decimal in binary conversion
            N = N/2;

            //Get current binary digit
            int binaryDigit = N%2;

            //If current binary digit is 1 and we had not seen 1 so far, mark the flag true for prevFound1
            if (binaryDigit == 1 && !prevfound1){
                prevfound1 = true;
            } 
            //If current binary digit is 0 and we had already seen 1 before, mark binaryGap flag true and increment the gap size
            else if (binaryDigit == 0 && prevfound1){
                binaryGap = true;
                binaryGapSize++;
            } 
            //If current binary digit is 1 and we had already seen 1 before, set maxBinaryGap as binaryGapSize if its bigger than prev found gaps, and reset the binaryGap flag and binaryGapSize for next iteration
            else if (binaryDigit == 1 && prevfound1){
                if (binaryGap) {
                    binaryGap = false;
                    if (maxBinaryGap < binaryGapSize) {
                        maxBinaryGap = binaryGapSize;
                    }
                    binaryGapSize = 0;
                }
            }
        }
        return maxBinaryGap;
    }
}
