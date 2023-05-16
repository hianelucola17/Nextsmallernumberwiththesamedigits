import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runners.JUnit4;

public class Kata {
    public static long nextSmaller(long n) {
        char[] digits = String.valueOf(n).toCharArray();
        int len = digits.length;

        int i = len - 2;
        while (i >= 0 && digits[i] <= digits[i + 1]) {
            i--;
        }

        if (i < 0) {
            return -1;
        }

        int j = len - 1;
        while (digits[j] >= digits[i]) {
            j--;
        }

        swap(digits, i, j);
        Arrays.sort(digits, i + 1, len);
        reverse(digits, i + 1, len - 1);

        if (digits[0] == '0') {
            return -1;
        }

        return Long.parseLong(String.valueOf(digits));
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void reverse(char[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }
}

// Test, Test, TEST!

public class KataTests {
    @Test
    public void basicTests() {
         assertEquals(12, Kata.nextSmaller(21));
         assertEquals(790, Kata.nextSmaller(907));
         assertEquals(513, Kata.nextSmaller(531));
         assertEquals(-1, Kata.nextSmaller(1027));
         assertEquals(414, Kata.nextSmaller(441));
         assertEquals(123456789, Kata.nextSmaller(123456798));
    }      
}
