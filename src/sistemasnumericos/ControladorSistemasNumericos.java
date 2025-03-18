/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemasnumericos;


public class ControladorSistemasNumericos {
    private VistaSistemaNumericos vista;
    private SistemasNumericos sistema;
    
    public ControladorSistemasNumericos(VistaSistemaNumericos vista){
        this.vista = vista;
        this.sistema = new SistemasNumericos();
    }
    
     public void decimalToOthers(){
        String num = vista.getTxtDecimal().getText();
        if(!num.isEmpty()){
            try{
                int numero = Integer.parseInt(num);
                vista.getTxtBinario().setText(sistema.decimalABinario(numero));
                vista.getTxtOctal().setText(sistema.decimalAOctal(numero));
                vista.getTxtHexadecimal().setText(sistema.decimalAHexadecimal(numero));
            }
            catch(NumberFormatException e){
                vista.getTxtBinario().setText("Error");
                    vista.getTxtOctal().setText("Error");
                    vista.getTxtHexadecimal().setText("Error");
            }
        } else {
            vista.getTxtBinario().setText("");
            vista.getTxtOctal().setText("");
            vista.getTxtHexadecimal().setText("");
        }
    }
     
     public void binarioToOthers(){
        String num = vista.getTxtBinario().getText();
        if(!num.isEmpty()){
            try{
                int numero = Integer.parseInt(num);
                String texto = String.valueOf(numero);
                vista.getTxtDecimal().setText(String.valueOf(sistema.binarioADecimal(texto)));
                vista.getTxtOctal().setText(sistema.binarioAOctal(texto));
                vista.getTxtHexadecimal().setText(sistema.binarioAHexadecimal(texto));
            }
            catch(NumberFormatException e){
                vista.getTxtDecimal().setText("Error");
                    vista.getTxtOctal().setText("Error");
                    vista.getTxtHexadecimal().setText("Error");
            }
        } else {
            vista.getTxtDecimal().setText("");
            vista.getTxtOctal().setText("");
            vista.getTxtHexadecimal().setText("");
        }
    }
     
     public void octalToOthers(){
        String num = vista.getTxtOctal().getText();
        if(!num.isEmpty()){
            try{
                int numero = Integer.parseInt(num);
                String texto = String.valueOf(numero);
                vista.getTxtBinario().setText(sistema.octalABinario(texto));
                vista.getTxtHexadecimal().setText(sistema.octalAHexadecimal(texto));
                vista.getTxtDecimal().setText(String.valueOf(sistema.octalADecimal(texto)));
            }
            catch(NumberFormatException e){
                vista.getTxtBinario().setText("Error");
                    vista.getTxtDecimal().setText("Error");
                    vista.getTxtHexadecimal().setText("Error");
            }
        } else {
            vista.getTxtBinario().setText("");
            vista.getTxtDecimal().setText("");
            vista.getTxtHexadecimal().setText("");
        }
        
    }
     
     public void hexadecimalToOthers(){
        String num = vista.getTxtHexadecimal().getText();
        if(!num.isEmpty()){
            try{
              
                vista.getTxtBinario().setText(sistema.hexadecimalABinario(num));
                vista.getTxtOctal().setText(sistema.hexadecimalAOctal(num));
                vista.getTxtDecimal().setText(String.valueOf(sistema.hexadecimalADecimal(num)));
            }
            catch(NumberFormatException e){
                vista.getTxtBinario().setText("Error");
                    vista.getTxtOctal().setText("Error");
                    vista.getTxtDecimal().setText("Error");
            }
        } else {
            vista.getTxtBinario().setText("");
            vista.getTxtOctal().setText("");
            vista.getTxtDecimal().setText("");
        }
        }
     
      public void calcular() {
        String num1 = vista.getNum1().getText();
        String num2 = vista.getNum2().getText();
        String operacion = (String) vista.getjComboBox1().getSelectedItem();
        String tipoBase = (String) vista.getjComboBox2().getSelectedItem();
        
        int base = obtenerBase(tipoBase);
        if (base == -1) {
            vista.getResult().setText("Error");
            return;
        }

        try {
            String resultado = "";
            switch (operacion) {
                case "+":
                    resultado = sistema.sumar(num1, num2, base);
                    break;
                case "-":
                    resultado = sistema.restar(num1, num2, base);
                    break;
                case "*":
                    resultado = sistema.multiplicar(num1, num2, base);
                    break;
                case "/":
                    resultado = sistema.dividir(num1, num2, base);
                    break;
                default:
                    resultado = "Error";
            }
            vista.getResult().setText(resultado);
        } catch (NumberFormatException e) {
            vista.getResult().setText("Error");
        } catch (ArithmeticException e) {
            vista.getResult().setText("Div 0");
        }
    }

    private int obtenerBase(String tipo) {
        switch (tipo) {
            case "Binario":
                return 2;
            case "Octal":
                return 8;
            case "Hexadecimal":
                return 16;
            default:
                return -1;
        }
    }
    }

    
     

