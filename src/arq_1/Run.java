package arq_1;

import arq_2.Alu2;
import arq_2.Memory2;

import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean mcd = true;

        // CÁLCULO DE MCD (ARQ_2)

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
        /*
        // CÁLCULO DE MCD (ARQ_2)

        int dataIn;
        System.out.println("Por favor ingrese un numero entero positivo (Capacidad máxima de operación: 16 bits)");
        dataIn = scan.nextInt();

        int a = Memory2.ingresar(dataIn);

        System.out.println("Ingrese otro numero entero positivo (Capacidad máxima de operación: 16 bits)");
        dataIn = scan.nextInt();


        int b = Memory2.ingresar(dataIn);

        while (mcd) {
            //mcd:
            Memory2.cargar("A", a);
            Memory2.cargar("B", b);
            Memory2.copiar("B", "C");
            Alu2.resta("C", 0);

            if (Alu2.saltarSiCero()) {
                break;
            }
            if(Alu2.saltarSiNeg()){
                break;
            }
            Alu2.modulo("A","B");
            Memory2.almacenar("A",b);
            Memory2.almacenar("B",a);
        }
        //Fin:
        int m = Memory2.almacenar("A");
        System.out.println("Máximo común divisor (mcd) calculado: ");
        Memory2.mostrar(m);

        // */
        /*
        // CÁLCULO DEL CUADRADO

        System.out.println("Por favor ingrese un entero positivo (Capacidad máxima de operación: 16 bits)");
        int dataInput;
        dataInput = scan.nextInt();

        int a = Memory2.ingresar(dataInput);

        Memory2.cargar("A", a);
        Alu2.cuadrado("A");

        int m = Memory2.almacenar("A");
        System.out.println("Calculando el cuadrado del número ingresado:");
        Memory2.mostrar(m);
        // */

        /*
         // CÁLCULO DE PRIMALIDAD (SI EL NÚMERO ES PRIMO O NO)

        System.out.println("Por favor ingrese un entero positivo (Capacidad máxima de operación: 16 bits)");
        int dataInput;
        dataInput = scan.nextInt();

        int a = Memory2.ingresar(dataInput);

        Memory2.cargar("A", a);
        Alu2.primo("A");
        int m = Memory2.almacenar("A");
        System.out.println("El número ingresado es primo? (0 => primo, 1 => no primo):");
        Memory2.mostrar(m);


        // */









    }
}
