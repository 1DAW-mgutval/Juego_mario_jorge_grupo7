package juego;
import java.util.Scanner;
import java.util.Arrays;

public class juego {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);


        System.out.println("JUGADOR 1: la palabra que deseas adivinar");
        String palabra = sc.nextLine();


        char[] descubiertas = new char[palabra.length()];
        for (int i = 0; i < descubiertas.length; i++) {
            descubiertas[i] = '_';
        }


        //repeat repite el guion segun la longitud de la palabra
        
        int intentos = 6;

        while (intentos > 0) {
            System.out.println("\nPalabra: " + String.valueOf(descubiertas));

            System.out.print("JUGADOR 2: Ingresa una letra: ");
            char letra = sc.next().toLowerCase().charAt(0);

            // Si no está en la palabra → pierdo intento
            if (!comprobarLetra(letra, palabra)) {
                System.out.println("Fallaste! La letra no está.");
                intentos--;
            } else {
                formarPalabra(letra, descubiertas, palabra);
            }

            if (palabraCompleta(descubiertas)) {
                System.out.println("\n¡FELICIDADES! Has adivinado la palabra: " + palabra);
                return;
            }
        }

        System.out.println("\nTe quedaste sin intentos. La palabra era: " + palabra);
    }

    public static boolean comprobarLetra (char letra, String palabra) {
        for (int i = 0; i < palabra.length(); i++) {
            if (palabra.charAt(i) == letra) {
                return true;
            }
        }
        return false;
    }

    public static int[] posicionesLetra (char letra, String palabra) {
        int posiciones[] = new int[1];
        int contadorPosiciones = 0;
        boolean primero = true;
        for (int i = 0; i < palabra.length(); i++) {
            if (palabra.charAt(i) == letra && !primero) {
                Arrays.copyOf(posiciones, contadorPosiciones+1);
                posiciones[contadorPosiciones] = i;
            } else if (primero && palabra.charAt(i) == letra) {
                posiciones[contadorPosiciones] = i;
                contadorPosiciones++;
            }
        }
        return posiciones;
    }

    public static void formarPalabra (char letra, String palabra, char[] palabraGuiones, int[] posiciones) {
        int contadorPosiciones = 0;
        for (int i = 0; i < palabraGuiones.length; i++) {
            if (i == posiciones[contadorPosiciones]) {
                palabraGuiones[i] = letra;
            }
        }
    }

    public static void pintarPalabraGuiones (char[] palabraGuiones) {
        for (int i = 0; i < palabraGuiones.length; i++) {
            System.out.print(palabraGuiones[i]);
        }
        System.out.println();
    }

    public static boolean palabraCompleta (String palabra, char[] palabraGuiones) {
        int coincidencias = 0;
        for (int i = 0; i < palabra.length(); i++) {
            if (palabra.charAt(i) == palabraGuiones[i]) {
                coincidencias++;
            }
        }
        if (coincidencias == palabra.length()) {
            return true;
        }
        return false;
    }
}
