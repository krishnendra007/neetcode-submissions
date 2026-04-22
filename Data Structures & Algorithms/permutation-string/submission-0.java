class Solution {
    private boolean check(int[]arr,int[]brr){
        for(int i=0;i<26;i++){
            if(arr[i]!=brr[i]){
                return false;
            }
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        int arr[]= new int[26];
        int brr[]= new int[26];

        for(char c: s1.toCharArray()){
            arr[c-'a']++;
        }

        int i=0,j=0,n=s2.length();

        while(j<n){
            

            if(j-i>=s1.length()){
                char d=s2.charAt(i);
                brr[d-'a']--;
                i++;
            }

            char c=s2.charAt(j);   
            brr[c-'a']++;
            j++;
            if(check(arr,brr)) return true;
            
        }

        return false;
    }
}
