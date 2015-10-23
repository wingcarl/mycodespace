/*The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.*/
public class Solution {
    public String countAndSay(int n) {
	        if(n == 1) return "1";
	        String t = "1";
	        while(n > 1){
	            t = helper(t);
	            n--;
	        }
	        return t;
	     }
	public String helper(String n){
	         StringBuilder tmp = new StringBuilder();
	         Stack<String> stack = new Stack<String>();
	         stack.push(n.substring(n.length()-1));
	         for(int i=n.length()-2;i>=0;i--){
	        	 stack.push(n.substring(i, i+1));
	         }
	         int num = 1;
	         while(!stack.empty()){
	             num = 1;
	             String a = stack.pop();
	             while(!stack.empty() && a.equals(stack.peek())){
	                 stack.pop();
	                 num++;
	             }
	             tmp.append(num);
	             tmp.append(a);
	         }
	         return tmp.toString();
	     }
}