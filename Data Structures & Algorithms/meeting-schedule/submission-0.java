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
    public boolean canAttendMeetings(List<Interval> inte) {
        Collections.sort(inte,(a,b)->a.end-b.end);

        for(int i=0;i<inte.size()-1;i++){
            if(inte.get(i).end>inte.get(i+1).start) return false;
        }

        return true;
    }
}
