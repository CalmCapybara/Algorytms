package Dynamic;

import java.util.Arrays;
import java.util.Scanner;

public class BagAlgorithm {
    static void main(String[] args) {
        new BagAlgorithm().run();
    }

    void run() {
        Scanner scanner = new Scanner(System.in);
        int bagWeight = scanner.nextInt();
        int goldCount = scanner.nextInt();

        int[] goldWeight = new int[goldCount];
        for (int i = 0; i < goldWeight.length; i++) {
            goldWeight[i] = scanner.nextInt();
        }

        boolean[] counts = new boolean[bagWeight];
        Arrays.fill(counts, false);
        counts[0] = true;

        for (int nominal : goldWeight) {
            for (int j = nominal; j <= bagWeight; j++) {
                counts[j] = j - nominal >= 0 && counts[j - nominal];
            }
        }

        int i = counts.length - 1;
        while (!counts[i]) i++;
        System.out.println(i);
    }
}
