class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> count=new HashMap<>();
        int left=0, maxFreq=0, maxLen=0;
        for(int right=0;right<s.length();right++){
            char c=s.charAt(right);
            count.put(c,count.getOrDefault(c,0)+1);
            maxFreq=Math.max(maxFreq,count.get(c));

            while((right-left+1)- maxFreq>k){
                char leftChar=s.charAt(left);
                count.put(leftChar, count.get(leftChar)-1);
                left++;
            }
            maxLen=Math.max(maxLen, right-left+1);
        }
        return maxLen;
    }
}
