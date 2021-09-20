package Otrezki;

import java.util.*;

class PoiskOtrezkov {
    public static void main(String[] args) {
        PoiskOtrezkov poiskOtrezkov = new PoiskOtrezkov();
        poiskOtrezkov.run();
    }

    void run() {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        List<Otrezok> otrezki = new ArrayList<>();
        while (count > 0) {
            String[] stroka = scanner.nextLine().split(" ");
            int nachalo = Integer.parseInt(stroka[0]);
            int konec = Integer.parseInt(stroka[1]);
            otrezki.add(new Otrezok(nachalo, konec));
            count--;
        }
        Collections.sort(otrezki);
        String result = "";
        Otrezok temp = otrezki.get(0);
        for (int i = 1; i < otrezki.size(); i++) {
            if (otrezki.get(i).nachalo > temp.konec) {
                result += temp.konec + " ";
                count++;
                temp = otrezki.get(i);
            } else {
                temp.nachalo = Math.max(temp.nachalo, otrezki.get(i).nachalo);
                temp.konec = Math.min(temp.konec, otrezki.get(i).konec);

            }
        }
        count++;
        result += temp.konec + " ";
        System.out.println(count);
        System.out.println(result.strip());
    }

    class Otrezok implements Comparable {
        int nachalo;
        int konec;

        public Otrezok(int nachalo, int konec) {
            this.nachalo = nachalo;
            this.konec = konec;
        }
        @Override
        public int compareTo(Object o) {
            return nachalo - ((Otrezok) o).nachalo;
        }
    }
}
