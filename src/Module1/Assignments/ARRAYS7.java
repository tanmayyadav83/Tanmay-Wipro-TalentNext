package Module1.Assignments;
import java.util.*;

public class ARRAYS7 {
        public static void main(String[] args) {
            int[] arr = {12, 34, 12, 45, 67, 89};

            Set<Integer> unique = new LinkedHashSet<>();
            for (int num : arr) {
                unique.add(num);
            }

            System.out.println(unique);
        }
    }


