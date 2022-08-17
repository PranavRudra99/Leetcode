//https://leetcode.com/problems/unique-morse-code-words/

class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        int count = 0;
        String[] patterns = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> set = new HashSet<>();
        for(String word: words){
            String tmp = new String("");
            for(int i = 0; i < word.length(); i++){
                tmp += patterns[word.charAt(i) - 'a'];
            }
            if(!set.contains(tmp)){
                set.add(tmp);
            }
        }
        return set.size();
    }
}