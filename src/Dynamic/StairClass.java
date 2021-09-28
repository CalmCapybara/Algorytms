package Dynamic;

import java.util.Scanner;

class StairClass {
    public static void main(String[] args) {
        new StairClass().run();
    }

    void run() {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] step = new int[count + 1];
        for (int i = 1; i < step.length; i++) {
            step[i] = scanner.nextInt();
        }
        int[] result = new int[2];
        result[1] = step[1];
        for (int i = 2; i < step.length; i++) {
            int temp  = result[1];
            result[1] = Math.max(result[1], result[0]) + step[i];
            result[0] = temp;
        }
        System.out.println(result[1]);
    }
}
