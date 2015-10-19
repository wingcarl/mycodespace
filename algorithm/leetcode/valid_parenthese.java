public class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>();
        Map<Character,Character> map = new HashMap<Character,Character>();
        map.put('{','}');
        map.put('[',']');
        map.put('(',')');
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(isPushCharacters(c))
                st.push(c);
            else{
                if(!st.empty()){
                    char out = st.pop();
                    if(map.get(out) != c) return false;
                }else{
                    return false;
                }
            }
        }
        if(!st.empty()) return false;
        return true;
    }
    private boolean isPushCharacters(char c){
        if(c == '(' || c== '{' || c=='[')
            return true;
        else return false;
    }
}