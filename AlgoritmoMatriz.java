public class AlgoritmoMatriz {
    public static void main(String[] args) {
        int[][] matriz = {
            {1, -8, 0, -1, 1, 2},
            {2, 0, 7, 9, -6, 3},
            {0, 1, 2, 3, 5, -1},
            {4, 8, 7, -3, 0, 6},
            {4, 5, 9, 2, -2, 0},
            {7, -3, -1, 0, 1, 4}
        };

        // Mejor caso: nivel 2
        int[] mejorCaso = SumaAnillo(matriz, 6, 2);
        System.out.println("Mejor de los casos: ");
        System.out.println("Suma del anillo: " + mejorCaso[0]);
        System.out.println("Cantidad de operaciones: " + mejorCaso[1]);

        // Peor caso: nivel 0
        int[] peorCaso = SumaAnillo(matriz, 6, 0);
        System.out.println("\nPeor de los casos: ");
        System.out.println("Suma del anillo: " + peorCaso[0]);
        System.out.println("Cantidad de operaciones: " + peorCaso[1]);
    }

    public static int[] SumaAnillo(int[][] matriz, int d, int k) {
        int sumaAnillo = 0;
        int operaciones = 0;
        int limSuperior = k;
        int limInferior = d - 1 - k;

        for (int j = limSuperior; j <= limInferior; j++) {
            sumaAnillo += matriz[limSuperior][j]; 
            operaciones += 2; 
            if (limSuperior != limInferior) { 
                sumaAnillo += matriz[limInferior][j]; 
                operaciones += 2; 
            }
        }

        for (int i = limSuperior + 1; i < limInferior; i++) { 
            sumaAnillo += matriz[i][limSuperior]; 
            operaciones += 2; 
            sumaAnillo += matriz[i][limInferior]; 
            operaciones += 2;
        }
        return new int[]{sumaAnillo, operaciones}; 
    }
}
