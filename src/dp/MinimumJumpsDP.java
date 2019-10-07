package dp;

import java.util.HashMap;

public class MinimumJumpsDP {

    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

    private int findJumps(int[] arr, int startIndex) {

        //if reached to the end...we are done
        if (startIndex == arr.length - 1) {
            return 0;
        }

        if (map.containsKey(startIndex)) {
            return map.get(startIndex);
        }
        int size = arr.length;

        int remainingLength = size - startIndex;

        if (remainingLength <= arr[startIndex]) {
            //means no further recursion is required
            return 1;
        }
        if (arr[startIndex] == 0) {
//            System.out.println("Cannot move further");
            return Integer.MAX_VALUE;
        }

        int jumps = Integer.MAX_VALUE;
        for (int i = 1; i <= arr[startIndex]; i++) {
            int temp = findJumps(arr, startIndex + i);
            if (temp != Integer.MAX_VALUE) {// check if path from jumps[j] is not blocked, means arr[startIndex]!=0
                jumps = Math.min(jumps, 1 + findJumps(arr, startIndex + i));
            } else {
                //ignore...cannot pass through 0
            }
        }
        map.put(startIndex, jumps);
        return jumps;
    }

    public static void main(String[] args) {
        MinimumJumpsDP m = new MinimumJumpsDP();
        long startTime = System.currentTimeMillis();
        int arr[] = {1, 3, 5, 3, 3, 1, 1, 1, 1, 1, 1, 1, 1, 4};
        System.out.println("Minimum Jumps required: " + m.findJumps(arr, 0));
        long end = System.currentTimeMillis();
        System.out.println("Dynamic Programming - Time taken: " + (end - startTime) + " miliseconds");

    }
}