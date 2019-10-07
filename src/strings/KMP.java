package strings;

import java.util.Arrays;

public class KMP {

    public int search(String str, String pattern) {

        char[] textArray = str.toCharArray();

        char[] patternArray = pattern.toCharArray();

        int textLength = textArray.length;

        int patternLength = patternArray.length;

        int i = 0; //text pointer

        int j = 0; // pattern pointer

        if (patternLength < 1) {
            return 0;
        }

        if (textLength < patternLength) {
            return -1;
        }


        int[] longestPrefixSuffix = getFiniteAutomata(pattern); // DFA

        System.out.println(Arrays.toString(longestPrefixSuffix));

        while (i < textLength) {
            if (textArray[i] == patternArray[j]) { // same value found, move both str and pattern pointers to their right
                i++;
                j++;
                if (j == patternLength) {
                    // whole match found
                    return i - patternLength;
                }


            } else if (j > 0) {
                // move pattern pointer to a previous safe location
                j = longestPrefixSuffix[j - 1];
            } else {
                // restart searching at next str pointer
                i++;
            }
        }
        return -1;
    }

    private int[] getFiniteAutomata(String pattern) {
        int j = 0, i = 1, L = pattern.length();
        int[] res = new int[L];
        char[] chars = pattern.toCharArray();
        while (i < L) {
            if (chars[i] == chars[j]) {
                j++;
                res[i] = j;
                i++;
            } else {
                int temp = i - 1;
                while (temp > 0) {
                    int prevLPS = res[temp];
                    if (chars[i] == chars[prevLPS]) {
                        res[i++] = prevLPS + 1;
                        j = prevLPS;
                        break;
                    } else temp = prevLPS - 1;
                }
                if (temp <= 0) {
                    res[i++] = 0;
                    j = 0;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        KMP kmp = new KMP();


        String str = "abxabcabcaby";


        String pattern = "abcaby";

        System.out.println(kmp.search(str, pattern));
    }
}