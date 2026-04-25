/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> inte) {
        int n=inte.size();
        int[] st= new int[n];
        int[] end= new int[n];

        for(int i=0;i<n;i++){
            st[i]=inte.get(i).start;
            end[i]=inte.get(i).end;
        }

        Arrays.sort(st);
        Arrays.sort(end);

        int i=0,j=0;

        int maxv=0, curr=0;
        // 0 5 15
        // 10 20 40

        while(i<n&&j<n){
            if(end[j]>st[i]){
                curr++;
                i++;
            } else{
                curr--;
                j++;
            }
            maxv=Math.max(maxv,curr);
        }

        return maxv;
    }
}
