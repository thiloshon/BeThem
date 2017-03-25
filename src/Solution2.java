import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Thiloshon on 25-Nov-16.
 */
public class Solution2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] num = new int[5];

        for (int x = 0; x < 5; x++) {

            num[x] = sc.nextInt();
        }

        Arrays.sort(num);

        System.out.println(num[4] +num[3] - num[0] - num[1] );
    }


}
