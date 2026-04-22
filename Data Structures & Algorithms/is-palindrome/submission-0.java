class Solution {
    private boolean check(String s){
        int i=0,j=s.length()-1;
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
    public boolean isPalindrome(String s) {
        StringBuilder sb= new StringBuilder();
        for(char x: s.toCharArray()){
            if((x>='a'&&x<='z')||(x>='A'&&x<='Z')||(x>='0'&&x<='9')){
                sb.append(x);
            }
        }
        s=sb.toString().toLowerCase();
        return check(s);
    }
}