class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for(int i=0;i<s.length();i++){
            char c= s.charAt(i);

            if(c=='('||c=='{'||c=='['){
                st.push(c);
            } else{
                if(st.empty()) return false;
                char sc=st.pop();
                if(c==')'&&sc!='('){
                    return false;
                } else if(c=='}'&&sc!='{'){
                    return false;
                } else if(c==']'&&sc!='['){
                    return false;
                }
            }
        }

        return st.size()==0;
    }
}