package com.codingquestions.app.StringII.ThreeSlidingWIndowQuestions;

/**
 * Given an array of integers that contains only 0s and 1s and a positive
 * integer k, you can flip at most k 0s to 1s, return the longest subarray that
 * contains only integer 1 after flipping.
 * 
 * Assumptions:
 * 
 * 1. Length of given array is between [1, 20000].
 * 
 * 2. The given array only contains 1s and 0s.
 * 
 * 3. 0 <= k <= length of given array.
 * 
 * Example 1:
 * 
 * Input: array = [1,1,0,0,1,1,1,0,0,0], k = 2
 * 
 * Output: 7
 * 
 * Explanation: flip 0s at index 2 and 3, then the array becomes
 * [1,1,1,1,1,1,1,0,0,0], so that the length of longest subarray that contains
 * only integer 1 is 7.
 * 
 * Example 2:
 * 
 * Input: array = [1,1,0,0,1,1,1,0,0,0], k = 0
 * 
 * Output: 3
 * 
 * Explanation: k is 0 so you can not flip any 0 to 1, then the length of
 * longest subarray that contains only integer 1 is 3.
 */

// TIME: O(n)
// SPACE: O(1)
public class LongestSubarrayContainsOnly1s {
    // This question is the variant of LongestSubstringWithoutRepeatingCharacters

    // in other words, this question is asking to find the longest
    // substring that contains at most k 0s
    // high-level: iterativly scan through the array and update the
    // variables accordingly

    public int longestConsecutiveOnes(int[] nums, int k) {
        int i = 0; // left boundary
        int remainingZeros = k;
        int longestLength = 0;

        // j is right boundary [i, j)
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == 1) {
                int curLength = j - i + 1;
                longestLength = curLength > longestLength ? curLength : longestLength;
            } else if (remainingZeros == 0) {
                while (i < nums.length && nums[i] != 0) {
                    i++;
                }
                i++;
            } else {
                remainingZeros--;
                int curLength = j - i + 1;
                longestLength = curLength > longestLength ? curLength : longestLength;
            }
        }
        return longestLength;
    }

    // this is a cleaner way to write it
    public int longestConsecutiveOnesMethod2(int[] nums, int k) {
        int slow = 0; // [slow, fast]
        int fast = 0;
        int count = 0; // how many zeros that we have used
        int longest = 0;
        while (fast < nums.length) {
            if (nums[fast] == 1) {
                longest = Math.max(longest, ++fast - slow);
            } else if (count < k) {
                count++;
                longest = Math.max(longest, ++fast - slow);
            } else if (nums[slow++] == 0) {
                count--;
            }
        }
        return longest;
    }

}