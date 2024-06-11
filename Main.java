import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> letters = new ArrayList<>();

        // Input
        Scanner input = new Scanner(System.in);
        System.out.println("=====Text Twist Solver=====");
        System.out.println("");
        System.out.print("Masukkan huruf-huruf: ");
        String letters_input = input.nextLine();
        String[] inputs = letters_input.split("[ ,]+");
        for (int i = 0; i < inputs.length; i++) {
            letters.add(inputs[i]);
        }
        System.out.println("Pilih Algoritma : ");
        System.out.println("1. IDS");
        System.out.println("2. Backtrack (Optimalisasi IDS)");
        System.out.print("Masukkan pilihan algoritma: ");
        Scanner algo_input = new Scanner(System.in);
        String algo = algo_input.nextLine();
        System.out.println("");
        System.out.println("===Menggunakan algoritma " + algo + "===");

        // Main handling
        for (int i = 3; i <= inputs.length; i++) {
            System.out.println("Kata-kata dengan length " + i + ":");
            TextTwist t = new TextTwist(i, letters);
            final long startTime = System.currentTimeMillis();
            if (algo.equals("1")) {
                t.recursiveTextTwistDLS(letters, "", i);
            } else {
                t.recursiveTextTwistBT(letters, "", i);
            }
            final long endTime = System.currentTimeMillis();
            System.out.println(t.result);
            System.out.println("took : " + (endTime - startTime) + " ms");
            System.out.println("");
        }
    }
}
