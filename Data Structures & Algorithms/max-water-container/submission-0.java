class Solution {
    public int maxArea(int[] h) {
        int i=0,j=h.length-1;

        int maxa=0;

        while(i<=j){
            int val= Math.min(h[i],h[j]);
            int area=val*(j-i);
            maxa=Math.max(area,maxa);

            if(val==h[i]) i++;
            else j--;
        }

        return maxa;
    }
}