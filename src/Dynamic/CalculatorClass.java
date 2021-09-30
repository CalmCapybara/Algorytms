package Dynamic;

import java.util.Arrays;
import java.util.Scanner;

class CalculatorClass {
    public static void main(String[] args) {
        new CalculatorClass().run();
    }

    void run() {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        if (i <= 3) {
            if (i == 1) {
                System.out.println("0 \n1");
                return;
            }
            System.out.println("1 \n" + "1 " + i);
            return;

        }
        int[] array = new int[i + 1];
        array[1] = 0;
        array[2] = 1;
        array[3] = 1;
        int[] prev = new int[i + 1];
        prev[1] = 0;
        prev[2] = 1;
        prev[3] = 1;


        for (int j = 4; j <= i; j++) {
            int[] counts = new int[3];
            counts[0] = j % 3 == 0 ? array[j / 3] : Integer.MAX_VALUE;
            counts[1] = j % 2 == 0 ? array[j / 2] : Integer.MAX_VALUE;
            counts[2] = array[j - 1];
            array[j] = Arrays.stream(counts).min().getAsInt();

            if (array[j] == counts[0]) prev[j] = j / 3;
            else if (array[j] == counts[1]) prev[j] = j / 2;
            else prev[j] = j - 1;

            array[j]++;

        }
        int[] answer = new int[array[i] + 1];
        System.out.println(array[i]);
        int j = array[i];
        answer[j] = i;
        j--;
        while (prev[i] != 1) {
            answer[j] = prev[i];
            i = prev[i];
            j--;
        }
        answer[0] = 1;
        for (int i1 : answer) {
            System.out.print(i1 + " ");
        }

    }


}
