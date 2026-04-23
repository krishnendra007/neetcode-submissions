class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> tails = new ArrayList<>();

        for (int num : nums) {
            //Element FOUND returns index of that element
            // else -(insertion_point + 1)
            int i = Collections.binarySearch(tails, num);
            if (i < 0) i = -(i + 1);      // insertion point
            if (i == tails.size()) tails.add(num);
            else tails.set(i, num);
        }
        return tails.size();
    }
}