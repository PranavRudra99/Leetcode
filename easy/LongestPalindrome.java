/*
url: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
*/

public class LongestPalindrome{

    public static void main(String[] args) {
        LeetCode obj = new LeetCode();
        System.out.println(obj.longestPalindrome("a"));
    }

    public int longestPalindrome(String s) {
        int[] numberOfOccurrences = new int[256];
        boolean oddCountFlag = false;
        int result = 0;
        for(int i = 0; i < s.length(); i++){
            numberOfOccurrences[s.charAt(i)]++;
        }
        for(int i = 0; i < numberOfOccurrences.length; i++){
            if(numberOfOccurrences[i] % 2 == 0){
                result += numberOfOccurrences[i];
            }
            else{
                result += numberOfOccurrences[i] - 1;
                oddCountFlag = true;
            }
        }
        if(oddCountFlag){
            result += 1;
        }
        return result;
    }

}