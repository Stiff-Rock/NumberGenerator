package numberGenerator;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public int numberGenerator(int numDigits, boolean hasRepeats) {
        Random randomNumber = new Random();
        StringBuilder numberText = new StringBuilder();
        int number;

        for (int i = 0; i < numDigits; i++) {
            boolean isLoopOver = false;
            String aux;
            do {
                aux = String.valueOf(randomNumber.nextInt(10));
                if (!hasRepeats) {
                    if (!numberText.toString().contains(aux)) {
                        numberText.append(aux);
                        isLoopOver = true;
                    }
                } else {
                    numberText.append(aux);
                    isLoopOver = true;
                }
            } while (!isLoopOver);
        }
        number = Integer.parseInt(numberText.toString());
        return number;
    }

    public static void main(String[] args) {
        Main generator = new Main();
        Scanner in = new Scanner(System.in);
        boolean exit = false;

        System.out.println("Bienvenido al generador de números\n¿Quieres que hayan dígitos repetidos? (y/n)");
        String repetidos;
        repetidos = in.next();

        boolean hasRepeats;
        hasRepeats = repetidos.equals("y");

        do {
            System.out.print("Introduce el número de dígitos: ");
            int numDigits = in.nextInt();
            if (numDigits == 0) {
                exit = true;
            } else {
                System.out.println("El número es: " + generator.numberGenerator(numDigits, hasRepeats));
            }
        } while (!exit);
        System.out.println("¡Adiós!");
        in.close();
    }
}