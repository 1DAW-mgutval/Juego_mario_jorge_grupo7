package juego;

import java.util.Arrays;

public class juego {
    public static void main(String[] args) {

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
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

    public static String formarPalabra (char letra, String palabraGuiones, String palabra, int[] posiciones) {
        int contadorPosiciones = 0;
        for (int i = 0; i < palabraGuiones.length(); i++) {
            if (i == posiciones[contadorPosiciones]) {
                
            }
        }
    }
}
