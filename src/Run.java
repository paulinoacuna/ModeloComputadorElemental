import jdk.nashorn.internal.runtime.regexp.joni.ScanEnvironment;

import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean mcd = true;
        int dataIn;
        System.out.println("Por favor ingrese un numero entero positivo (Capacidad máxima de operación: 16 bits)");
        dataIn = scan.nextInt();

        int a = Memory.ingresar(dataIn);

        System.out.println("Ingrese otro numero entero positivo (Capacidad máxima de operación: 16 bits)");
        dataIn = scan.nextInt();


        int b = Memory.ingresar(dataIn);

        while (mcd) {
            //mcd:
            Memory.cargar("A", a);
            Memory.cargar("B", b);
            Memory.copiar("B", "C");
            Alu.resta("C", 0);

            if (Alu.saltarSiCero()) {
                break;
            }
            if(Alu.saltarSiNeg()){
                break;
            }
            Alu.modulo("A","B");
            Memory.almacenar("A",b);
            Memory.almacenar("B",a);
        }
        //Fin:
        int m = Memory.almacenar("A");
        System.out.println("Máximo común divisor (mcd) calculado: ");
        Memory.mostrar(m);


    }
}
