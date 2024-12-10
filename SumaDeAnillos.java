import java.util.Random;
import java.util.Scanner;

public class SumaDeAnillos {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Ingrese la dimensión de la matriz (d): ");
        int d = leer.nextInt();

        if (d <= 0) {
            System.out.println("La dimensión debe ser un número entero positivo.");
            return;
        }

        int[][] matriz = new int[d][d];

        for (int i = 0; i < d; i++) {
            for (int j = 0; j < d; j++) {
                matriz[i][j] = random.nextInt(101); 
            }
        }

        System.out.println("Matriz generada:");
        Imprimir(matriz, d);

        System.out.println("Ingrese el nivel del anillo a sumar (1 para el anillo exterior): ");
        int nivel = leer.nextInt();

        int nivelAjustado = nivel - 1;

        if (nivelAjustado < 0 || nivelAjustado >= (d + 1) / 2) {
            System.out.println("Nivel de anillo inválido.");
            return;
        }

        int sumaAnillo = SumaAnillo(matriz, d, nivelAjustado);
        System.out.println("La suma del anillo " + nivel + " es: " + sumaAnillo);
    }

    public static int SumaAnillo(int[][] matriz, int d, int nivel) {
        int sumaAnillo = 0;
        int limSuperior = nivel;
        int limInferior = d - 1 - nivel;

        for (int i = limSuperior; i <= limInferior; i++) {
            for (int j = limSuperior; j <= limInferior; j++) {
                if (i == limSuperior || i == limInferior || j == limSuperior || j == limInferior) {
                    sumaAnillo += matriz[i][j];
                }
            }
        }
        return sumaAnillo;
    }

    public static void Imprimir(int[][] matriz, int d) {
        for (int i = 0; i < d; i++) {
            for (int j = 0; j < d; j++) {
                System.out.print(matriz[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
