import java.util.Scanner;

/**
 * Created by Thiloshon on 25-Nov-16.
 */
public class Solution4 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        str = str.replaceAll("\\s+","");
       // System.out.println(str);
        Integer num1 = (Integer.parseInt(str.split(",")[0]));

        int num2 = (Integer.parseInt(str.split(",")[1]));

        String[][] array = new String[num1][num2];


        for (int x = 0; x < num1; x++) {
            String st = sc.nextLine();
            array[x] = st.split("");
        }

       /* for (int c = 0; c < num1; c++) {
            for (int g = 0; g < num2; g++) {
                System.out.print(array[c][g] + " ");
            }
            System.out.println("");
        }*/

        AnswerTriplet[][] ans = new AnswerTriplet[num1][num2];

        for (int h = 0; h < num2; h++) {
            for (int n = 0; n < num1; n++) {
                ans[n][h] = new AnswerTriplet();
            }
        }


        int startNum = 0;
        for (int g = 0; g < num2; g++) {
            if (array[0][g].equalsIgnoreCase("S")) {
                break;
            }
            startNum++;
        }

        //Integer.parseInt(array[0][startNum+1]);

        for (int g = startNum + 1; g < num2; g++) {
            if (array[0][g].equals("#")) {
                continue;
            }
            if (g == startNum + 1) {
                ans[0][g].fromLeft = Integer.parseInt(array[0][g]);
            } else {
                ans[0][g].fromLeft = (Integer.parseInt(array[0][g]) + ans[0][g - 1].fromLeft);
            }
            ans[0][g].fromRight = -1;
        }

        for (int g = startNum - 1; g >= 0; g--) {
            if (array[0][g].equals("#")) {
                continue;
            }
            if (g == startNum - 1) {
                ans[0][g].fromRight = Integer.parseInt(array[0][g]);
            } else {
                ans[0][g].fromRight = (Integer.parseInt(array[0][g]) + ans[0][g + 1].fromRight);
            }
            ans[0][g].fromLeft = -1;
        }

        for (int h = 1; h < num1 - 1; h++) {

            for (int j = 0; j < num2; j++) {
                if (array[h - 1][j].equals("#") || array[h][j].equals("#")) {
                    continue;
                } else {
                    ans[h][j].fromTop = Math.max(Math.max(ans[h - 1][j].fromLeft, ans[h - 1][j].fromRight), ans[h - 1][j].fromTop) + Integer.parseInt(array[h][j]);
                }
            }


            //===================================================

            for (int j = 0; j < num2; j++) {
                if (j>0) {

                    if (array[h][j - 1].equals("#") || array[h][j].equals("#")) {
                        continue;
                    }
                    {

                        ans[h][j].fromLeft = Math.max(ans[h][j - 1].fromTop, ans[h][j - 1].fromLeft) + Integer.parseInt(array[h][j]);

                    }
                }

            }

            for (int j = num2 - 2; j >= 0; j--) {
                if (array[h][j + 1].equals("#") || array[h][j].equals("#")) {
                    continue;
                }


                ans[h][j].fromRight = Math.max(ans[h][j + 1].fromTop, ans[h][j + 1].fromRight) + Integer.parseInt(array[h][j]);

            }


        }

        for (int h = 1; h < num1 - 1; h++) {

            /*for (int j = 0; j < num2; j++) {
                if (j>0) {

                    if (array[h][j - 1].equals("#") || array[h][j].equals("#")) {
                        continue;
                    }
                    {

                        ans[h][j].fromLeft = Math.max(ans[h][j - 1].fromTop, ans[h][j - 1].fromLeft) + Integer.parseInt(array[h][j]);

                    }
                }

            }*/
        }

        for (int h = 1; h < num1 - 1; h++) {

            /*for (int j = num2 - 2; j >= 0; j--) {
                if (array[h][j + 1].equals("#") || array[h][j].equals("#")) {
                    continue;
                }


                ans[h][j].fromRight = Math.max(ans[h][j + 1].fromTop, ans[h][j + 1].fromRight) + Integer.parseInt(array[h][j]);

            }*/
        }


        for (int j = 0; j < num2; j++) {
            if (array[num1 - 2][j].equals("#") || array[num1 - 1][j].equals("#") || array[num1 - 1][j].equals("E")) {
                continue;
            }
            ans[num1 - 1][j].fromTop = Math.max(Math.max(ans[num1 - 2][j].fromLeft, ans[num1 - 2][j].fromRight), ans[num1 - 2][j].fromTop) + Integer.parseInt(array[num1 - 1][j]);

        }

        startNum = 0;
        for (int g = 0; g < num2; g++) {
            if (array[num1 - 1][g].equalsIgnoreCase("E")) {
                break;
            }
            startNum++;
        }

        for (int f = 1; f < startNum; f++) {
            if (array[num1 - 1][f].equals("#") || array[num1 - 1][f - 1].equals("#")) {
                continue;
            }
            ans[num1 - 1][f].fromLeft = Math.max(ans[num1 - 1][f - 1].fromTop, ans[num1 - 1][f - 1].fromLeft) + Integer.parseInt(array[num1 - 1][f]);
        }


        for (int f = num2 - 2; f > startNum; f--) {
            if (array[num1 - 1][f].equals("#") || array[num1 - 1][f + 1].equals("#")) {
                continue;
            }
            ans[num1 - 1][f].fromRight = Math.max(ans[num1 - 1][f + 1].fromTop, ans[num1 - 1][f + 1].fromRight) + Integer.parseInt(array[num1 - 1][f]);
        }


       /* for (AnswerTriplet[] asd : ans) {
            for (AnswerTriplet asdf : asd) {
                System.out.print(asdf.fromLeft + " " + asdf.fromRight + " " + asdf.fromTop + "       ");
            }
            System.out.println("");
        }*/

        int val1 = 0;
        int val2 = 0;
        int val3 = 0;


        try{
            val1 = Math.max(ans[num1-1][startNum-1].fromLeft, Math.max(ans[num1-1][startNum-1].fromTop, ans[num1-1][startNum-1].fromRight));
        }catch (ArrayIndexOutOfBoundsException e){

        }
        try{
            val2 = Math.max(ans[num1-1][startNum+1].fromLeft, Math.max(ans[num1-1][startNum+1].fromTop, ans[num1-1][startNum+1].fromRight));
        }catch (ArrayIndexOutOfBoundsException i){

        }
        try{
            val3 = Math.max(ans[num1-2][startNum].fromLeft, Math.max(ans[num1-2][startNum].fromTop, ans[num1-2][startNum].fromRight));
        }catch(ArrayIndexOutOfBoundsException g){

        }

        System.out.println(Math.max(val1,Math.max(val2,val3)));
    }

    static class AnswerTriplet {
        int fromLeft = 0;
        int fromRight = 0;
        int fromTop = 0;
    }


}
