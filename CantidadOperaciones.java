public class CantidadOperaciones {

    public static void main(String[] args) {
        int n = 6; // Tamaño de la matriz 
        System.out.println("Cálculo de operaciones por anillo y fórmulas:");
        
        for (int k = 0; k <= (n - 1) / 2; k++) {
            int operaciones = calcularOperaciones(n, k);
            String formulaAnillo = obtenerFormulaPorAnillo(n, k);
            System.out.println("Anillo " + k + ": Operaciones = " + operaciones + ", Fórmula = " + formulaAnillo);
        }
    }

    public static int calcularOperaciones(int n, int k) {
        int ladoSuperiorInferior = 2 * (n - 2 * k);
        int ladosIzquierdoDerecho = 2 * (Math.max(0, n - 2 * k - 2));
        return 2 * (ladoSuperiorInferior + ladosIzquierdoDerecho);
    }

    public static String obtenerFormulaPorAnillo(int n, int k) {
        // Fórmula general: 8n - 16k - 8
        int coeficienteN = 8; // Coeficiente de n
        int coeficienteK = -16 * k; // Término que depende de k
        int constante = -8; // Término constante

        return coeficienteN + "n " + (coeficienteK >= 0 ? "+ " : "- ") + Math.abs(coeficienteK) + "k " + (constante >= 0 ? "+ " : "- ") + Math.abs(constante);
    }
}
