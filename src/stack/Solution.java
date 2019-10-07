package stack;

import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int n = heights.length;
        int max = 0;
        Stack<Integer> stack = new Stack<>(); // Use stack to store the index
        for (int i = 0; i <= n; i++) {
            int currHeight = i == n ? -1 : heights[i];
            // Keep stack monotonous; if not, process && calculate rectangle
            while (!stack.isEmpty() && currHeight <= heights[stack.peek()]) {
                int currPeekHeight = heights[stack.pop()];
                // exclude current position; it'll be calculate in next round.
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, currPeekHeight * width);
            }
            stack.push(i);
        }

        return max;
    }
}

