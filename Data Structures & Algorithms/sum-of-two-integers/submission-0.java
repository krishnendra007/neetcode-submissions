class Solution {
    public int getSum(int a, int b) {
        while (b != 0) {
            int s = a ^ b;          // ^ gives the sum with no cARRY 
            int carry = (a & b) << 1; // gives carry & and << 1  moves the carry by 1 pos
            a = s;
            b = carry;
        }
        return a;
    }
}