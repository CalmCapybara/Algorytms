package Dynamic;

import java.util.Arrays;
import java.util.Scanner;

public class BagAlgorithm {
    public static void main(String[] args) {
        new BagAlgorithm().run();
    }

    void run() {
        Scanner scanner = new Scanner(System.in);
        int bagWeight = scanner.nextInt();
        int goldCount = scanner.nextInt();

        int[] goldWeight = new int[goldCount];
        for (int i = 0; i < goldCount; i++) {
            goldWeight[i] = scanner.nextInt();
        }

        int[] counts = new int[bagWeight+1];
        Arrays.fill(counts, 0);
        counts[0] = 1;

        for (int nominal : goldWeight) {
            for (int i = bagWeight; i >= nominal ; i--) {
                if(counts[i - nominal] == 1) counts[i] = 1;

            }
        }
        for (int count : counts) {
            System.out.print(count + " ");
        }
        System.out.println("");

        int i = counts.length - 1;
        while (counts[i] == 0) i--;
        System.out.println(i);
    }
}
