package arqRed;

import arq_1.Alu;
import arq_1.Memory;

import java.util.Scanner;

public class RunRed {

    public static void main(String[] args) {

        System.out.println("Inicializa Matriz de prioridad");
        MemoryRed.randomizePriorityMatrix();

        System.out.println("seleccion de los recursos de los computadores con prioridad");
        MemoryRed.selectPriorityComps();


        Scanner scan = new Scanner(System.in);
        boolean mcd = true;

        // CÁLCULO DE MCD

        int dataIn;
        System.out.println("Por favor ingrese un numero entero positivo (Capacidad máxima de operación: 16 bits)");
        dataIn = scan.nextInt();

        int a = MemoryRed.ingresar(dataIn);

        System.out.println("Ingrese otro numero entero positivo (Capacidad máxima de operación: 16 bits)");
        dataIn = scan.nextInt();

        int b = MemoryRed.ingresar(dataIn);

        while (mcd) {
            //mcd:
            MemoryRed.cargar("A", a);
            MemoryRed.cargar("B", b);
            MemoryRed.copiar("B", "C");
            //AluRed.resta("C", 0);


            //AluRed.modulo("A","B");
            MemoryRed.almacenar("A",b);
            MemoryRed.almacenar("B",a);

            mcd = false;
        }
        //Fin:
        int m = MemoryRed.almacenar("A");
        System.out.println("Máximo común divisor (mcd) calculado: ");
        MemoryRed.mostrar(m);








    }
}
