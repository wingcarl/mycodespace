public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        generateHelper("",list,n,n);
        return list;
    }
    public void generateHelper(String str,List<String> list,int left,int right){
        if(left > right)
            return;
        if(left > 0)
            generateHelper(str+"(",list,left-1,right);
        if(right > 0)
            generateHelper(str+")",list,left,right-1);
        if(left == 0 && right == 0)
            list.add(str);
        return;
    }
}