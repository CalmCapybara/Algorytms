package Dynamic;

import java.util.Scanner;

public class BagAlgoritm {
    static void main(String[] args) {
        new BagAlgoritm().run();
    }

    void run(){
        Scanner scanner = new Scanner(System.in);
        int bagWeight = scanner.nextInt();
        int goldCount = scanner.nextInt();

        int[] goldWeight = new int[goldCount];
        for (int i = 0; i < goldWeight.length; i++) {
            goldWeight[i] = scanner.nextInt();
        }

        

    }
}
