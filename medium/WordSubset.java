/*
 * https://leetcode.com/problems/word-subsets/
 */
class Solution {
      public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> list = new ArrayList<>();
        int[] minCount = new int[26];
        for(int i = 0; i < words2.length; i++){
            minCount = constructMinSequence(words2[i], minCount);
        }
        for (int i = 0; i < words1.length; i++) {
            int[] charCount = constructCharSequence(words1[i]);
            boolean flag = true;
            for(int j = 0; j < 26; j++){
                if(minCount[j] > charCount[j]){
                    flag = flag & false;
                }
            }
            if(flag){
                list.add(words1[i]);
            }
        }
        return list;
    }

    public int[] constructMinSequence(String word, int[] minSequence){

        int[] charCount = new int[26];
        for(int i = 0; i < word.length(); i++){
            int index = word.charAt(i)-'a';
            charCount[index]++;
            minSequence[index] = Math.max(charCount[index], minSequence[index]);
        }
        return minSequence;

    }

    public int[] constructCharSequence(String word){

        int[] charCount = new int[26];
        for(int i = 0; i < word.length(); i++){
            charCount[word.charAt(i) - 'a']++;
        }
        return charCount;
    }
}