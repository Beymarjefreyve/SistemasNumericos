/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemasnumericos;

public class SistemasNumericos {
    
    public SistemasNumericos(){
        
    }

    // Conversión de decimal a otras bases
    public static String decimalABinario(int numero) {
        return Integer.toBinaryString(numero);
    }

    public static String decimalAOctal(int numero) {
        return Integer.toOctalString(numero);
    }

    public static String decimalAHexadecimal(int numero) {
        return Integer.toHexString(numero).toUpperCase();
    }

    // Conversión de binario a otras bases
    public static int binarioADecimal(String binario) {
        return Integer.parseInt(binario, 2);
    }

    public static String binarioAOctal(String binario) {
        int decimal = binarioADecimal(binario);
        return decimalAOctal(decimal);
    }

    public static String binarioAHexadecimal(String binario) {
        int decimal = binarioADecimal(binario);
        return decimalAHexadecimal(decimal);
    }

    // Conversión de octal a otras bases
    public static int octalADecimal(String octal) {
        return Integer.parseInt(octal, 8);
    }

    public static String octalABinario(String octal) {
        int decimal = octalADecimal(octal);
        return decimalABinario(decimal);
    }

    public static String octalAHexadecimal(String octal) {
        int decimal = octalADecimal(octal);
        return decimalAHexadecimal(decimal);
    }

    // Conversión de hexadecimal a otras bases
    public static int hexadecimalADecimal(String hexadecimal) {
        return Integer.parseInt(hexadecimal, 16);
    }

    public static String hexadecimalABinario(String hexadecimal) {
        int decimal = hexadecimalADecimal(hexadecimal);
        return decimalABinario(decimal);
    }

    public static String hexadecimalAOctal(String hexadecimal) {
        int decimal = hexadecimalADecimal(hexadecimal);
        return decimalAOctal(decimal);
    }

    // Operaciones en bases numéricas
    public static String sumar(String numero1, String numero2, int base) {
        int resultado = Integer.parseInt(numero1, base) + Integer.parseInt(numero2, base);
        return Integer.toString(resultado, base).toUpperCase();
    }

    public static String restar(String numero1, String numero2, int base) {
        int resultado = Integer.parseInt(numero1, base) - Integer.parseInt(numero2, base);
        return Integer.toString(resultado, base).toUpperCase();
    }

    public static String multiplicar(String numero1, String numero2, int base) {
        int resultado = Integer.parseInt(numero1, base) * Integer.parseInt(numero2, base);
        return Integer.toString(resultado, base).toUpperCase();
    }

    public static String dividir(String numero1, String numero2, int base) {
        int divisor = Integer.parseInt(numero2, base);
        if (divisor == 0) {
            throw new ArithmeticException("No se puede dividir por cero");
        }
        int resultado = Integer.parseInt(numero1, base) / divisor;
        return Integer.toString(resultado, base).toUpperCase();
    }
}

