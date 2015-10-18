public class Solution {
    public int reverse(int x) {
    	int sum = 0;
    	while(x != 0){
    		int tmp = x % 10; //tmp = 3
    		if(sum > Integer.MAX_VALUE/10) return 0;
    		if(sum < Integer.MIN_VALUE/10) return 0;
    		sum = tmp+sum*10;
    		x = x/10;  // x=12;	
    	}
    	return sum;
    }
}