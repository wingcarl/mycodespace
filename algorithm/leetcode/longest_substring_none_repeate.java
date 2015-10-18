/**
 * Given a string, find the length of the longest substring without repeating characters. 
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc", 
 * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 */
public class Solution {
	//方法一 时间复杂度O(n^2) 空间复杂度O(n) 
    public int lengthOfLongestSubstring1(String s) {
       	Set<String> hasChar = null;
       	int longestSubstringlength = 0;
        for(int i=0;i<s.length();i++){
        	int length = 0;
        	hasChar = new HashSet<String>();
        	for(int j=i;j<s.length();j++){
        		String c = s.substring(j,j+1);
        		if(hasChar.contains(c)) {
        			if(length > longestSubstringlength) longestSubstringlength = length;
        			break;
        		}
        		hasChar.add(c);
        		length++;
        	}
        }
        return longestSubstringlength;
    }
    //abcbadac
    //方法二 时间复杂度O(n) 如果出现了重复，则从重复的字母向后在计算
     public int lengthOfLongestSubstring2(String s) {
       	Map<String,Integer> lastShowIndex = new HashMap<String,Integer>();
       	int maxLength = 0;
       	int curLength = 0;
       	int start = 0;
       	for(int i=0;i<s.length();i++){
       		String substring = s.substring(i,i+1);
       		if(lastShowIndex.get(substring) == null || lastShowIndex.get(substring) < start){
       			lastShowIndex.put(substring,i);
       			curLength++;
       		}else{
       			int index = lastShowIndex.get(substring);
       			curLength = i-index;
       			start = index+1;
       			lastShowIndex.put(substring,i);
       		}
       		if(curLength > maxLength)
       			maxLength = curLength;

       	}
    }
}