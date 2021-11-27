package arqRed;

import arq_1.Alu;
import arq_1.Memory;
import com_1.AluCom_1;
import com_1.MemoryCom_1;
import com_2.AluCom_2;
import com_2.MemoryCom_2;
import com_3.AluCom_3;
import com_3.MemoryCom_3;
import com_4.AluCom_4;
import com_4.MemoryCom_4;
import com_5.AluCom_5;
import com_5.MemoryCom_5;

import java.util.Scanner;

import static arqRed.MemoryRed.aluSelectedCom;

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
            AluRed.resta("C", 0);

            boolean jumpZ = false;
            boolean jumpN = false;

            switch (aluSelectedCom) {
                case 1:
                    jumpZ = AluCom_1.saltarSiCero();
                    break;
                case 2:
                    jumpZ = AluCom_2.saltarSiCero();
                    break;
                case 3:
                    jumpZ =  AluCom_3.saltarSiCero();
                    break;
                case 4:
                    jumpZ =  AluCom_4.saltarSiCero();
                    break;
                case 5:
                    jumpZ = AluCom_5.saltarSiCero();
                    break;
                default:
                    System.err.println("Error en la selección del Computador");
                    System.exit(-1);

            }


            if (jumpZ) {
                break;
            }


            switch (aluSelectedCom) {
                case 1:
                    jumpN = AluCom_1.saltarSiNeg();
                    break;
                case 2:
                    jumpN = AluCom_2.saltarSiNeg();
                    break;
                case 3:
                    jumpN =  AluCom_3.saltarSiNeg();
                    break;
                case 4:
                    jumpN =  AluCom_4.saltarSiNeg();
                    break;
                case 5:
                    jumpN = AluCom_5.saltarSiNeg();
                    break;
                default:
                    System.err.println("Error en la selección del Computador");
                    System.exit(-1);

            }

            if(jumpN){
                break;
            }

            //IMPORTANTE COMPLETAR ESTA FUNCION MODULO
            AluRed.modulo("A","B");


            MemoryRed.almacenar("A",b);
            MemoryRed.almacenar("B",a);


        }
        //Fin:
        int m = MemoryRed.almacenar("A");
        System.out.println("Máximo común divisor (mcd) calculado: ");
        MemoryRed.mostrar(m);








    }
}
