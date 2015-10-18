public class Solution {
      public String longestPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append("$#");
        for(int i=0;i<s.length();i++){
        	sb.append(s.substring(i,i+1));
        	sb.append("#");
        }
        String nstr = sb.toString();
        int mx = 1;
        int id = 0;
        int[] p = new int[nstr.length()];
        p[0] = 1;
        for(int i=1;i<p.length;i++){
        	if(mx > i){
        		p[i] = Math.min(p[2*id-i], mx-i);
        	}else{
        		p[i] = 1;
        	}
        	try{
            	for(;nstr.substring(i+p[i],i+p[i]+1).equals(nstr.substring(i-p[i],i-p[i]+1))&&i+p[i]+1<nstr.length();p[i]++);
        		if(nstr.substring(i+p[i]).equals(nstr.substring(i-p[i],i-p[i]+1))) p[i]++;
        	}catch(Exception e){
        		
        	}
        	if(mx < p[i]+i){
        		mx = p[i]+i;
        		id = i;
        	}
        }
        int maxLength = 0;
    	int maxIndex = 0;
    	for(int i=0;i<nstr.length();i++){
    		if(p[i] > maxLength){
    			maxLength = p[i];
    			maxIndex = i;
    		}
    	}
    	String rstr = nstr.substring(maxIndex-maxLength+1,maxIndex+maxLength);
    	rstr = rstr.replaceAll("#", "");
        System.out.println(rstr);
        return rstr;
    }
}