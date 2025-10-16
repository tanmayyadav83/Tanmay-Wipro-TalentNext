package Module1.Assignments;
import java.util.Arrays;

public class ARRAYS10 {
        public static void main(String[] args) {
            int[] arr = {1, 0, 1, 0, 0, 1, 1};
            int[] result = new int[arr.length];
            int index = 0;

            for (int num : arr) {
                if (num % 2 == 0) {
                    result[index++] = num;
                }
            }

            for (int num : arr) {
                if (num % 2 != 0) {
                    result[index++] = num;
                }
            }

            System.out.println(Arrays.toString(result));
        }
    }


