class Solution {
    public int largestRectangleArea(int[] heights) {

        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i < n; i++) {

            // While current bar is smaller than stack top
            while (!st.isEmpty() &&  heights[st.peek()]>= heights[i]) {

                int height = heights[st.pop()];

                int width;
                if (st.isEmpty()) {
                    width = i;
                } else {
                    width = i - (st.peek() + 1);
                }

                maxArea = Math.max(maxArea, height * width);
            }

            st.push(i);
        }

        // Process remaining bars
        while (!st.isEmpty()) {
            int height = heights[st.pop()];

            int width;
            if (st.isEmpty()) {
                width = n;
            } else {
                width = n - st.peek() - 1;
            }

            maxArea = Math.max(maxArea, height * width);
        }

        return maxArea;
    }
}