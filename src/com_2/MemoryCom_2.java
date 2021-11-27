package com_2;

import arqRed.MemoryRed;
import arq_1.Registers;
import com_1.RegistersCom_1;
import com_2.RegistersCom_2;

import static com_1.MemoryCom_1.com_1_dataArray;
import static com_3.MemoryCom_3.com_3_dataArray;
import static com_4.MemoryCom_4.com_4_dataArray;
import static com_5.MemoryCom_5.com_5_dataArray;

public class MemoryCom_2 extends arq_1.Memory {



    //Datos
    public static int[] com_2_dataArray = new int[255];
    private static int top = 0;

    //ingresa datos a la memoria, retorna la dirección de memoria donde quedó almacenado
    public static int ingresar(int dataIn){
        com_2_dataArray[top] = dataIn;
        top++;
        System.out.println("\u001B[33m" + "LOG_JVN_MACHINE_1:" + "\u001B[0m" +
                " \u001B[36m" + "ingresar()" +  "\u001B[0m " + "\u001B[33m" + "-->" + "\u001B[0m" +
                " Ingresa el dato " + dataIn + " en la memoria de la máquina.");
        return top - 1;

    }





    public static void cargar(String x,int dataArrayIndex){
        int registerArrayIndex = RegistersCom_2.indexMapper(x);
        switch (MemoryRed.memorySelectedCom) {
            case 1:
                RegistersCom_2.registersArray[registerArrayIndex] = com_1_dataArray[dataArrayIndex];
                break;
            case 2:
                RegistersCom_2.registersArray[registerArrayIndex] = com_2_dataArray[dataArrayIndex];
                break;
            case 3:
                RegistersCom_2.registersArray[registerArrayIndex] = com_3_dataArray[dataArrayIndex];
                break;
            case 4:
                RegistersCom_2.registersArray[registerArrayIndex] = com_4_dataArray[dataArrayIndex];
                break;

            case 5:
                RegistersCom_2.registersArray[registerArrayIndex] = com_5_dataArray[dataArrayIndex];
                break;
            default:
                System.err.println("Error en la selección del Computador");
                System.exit(-1);
                break;
        }

        System.out.println("\u001B[33m" + "LOG_JVN_MACHINE_1:" + "\u001B[0m" +
                " \u001B[36m" + "cargar()" +  "\u001B[0m " + "\u001B[33m" + "-->" + "\u001B[0m" +
                " Carga un valor de memoria al registro " + x + ".");
    }





    //clase privada para funcionamiento,no borrar ni usar como instrucción en Run. por favor copiar esta clase en todos los com.
    public static int enviarValordeRegistro(String x) {
        int registerArrayIndex = RegistersCom_2.indexMapper(x);
        return RegistersCom_2.registersArray[registerArrayIndex];
    }
}
