import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        String string = sc.nextLine();
        int num = sc.nextInt();


        String[] arr = new String[string.length()];

        arr = string.split("");


        int incrementer = 1;
        for (String st : arr) {
            //System.out.println(st);
            //incrementer = (incrementer) % 27;
            int value = 0;

            if (st.charAt(0) >= 97) {
                value = (st.charAt(0) - incrementer);
                if (value < 97) {
                    value = 97 - value;
                    value = 123 - value;
                }
            } else {
                value = (st.charAt(0) - incrementer);
                if (value < 65) {
                    value = 65 - value;
                    value = 91 - value;
                }

            }

            System.out.print((char) (value));
            incrementer++;
            if (incrementer > num) {
                incrementer = 1;
            }
        }


    }
}
