public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0)
            return "";
        if(strs.length==1)
            return strs[0];
        String curPrefix = strs[0];
        for(int i=1;i<strs.length;i++){
            String curWord = strs[i];
            int j = 0;
            while(j < curPrefix.length() && j < curWord.length() && curWord.charAt(j)==curPrefix.charAt(j))
                j++;
            curPrefix = curPrefix.substring(0,j);
        }
        return curPrefix;
    }
}