class Solution {
    public double myPow(double x, int n) {
        
        double ans=1.0;
        long tempN=n;
        if(n<0) tempN*=-1;

        while(tempN>0){
            if(tempN%2==1){
                ans=ans*x;
                tempN=tempN-1;
            }else{
                x=x*x;
                tempN=tempN/2;
            }
        }

        if(n<0) ans = (double)(1.0)/(double)(ans);

        return ans;
    }
}