package com_1;

import arqRed.MemoryRed;
import arq_1.Registers;
import com_2.MemoryCom_2;
import com_3.MemoryCom_3;
import com_4.MemoryCom_4;
import com_5.MemoryCom_5;

import static com_2.MemoryCom_2.com_2_dataArray;
import static com_3.MemoryCom_3.com_3_dataArray;
import static com_4.MemoryCom_4.com_4_dataArray;
import static com_5.MemoryCom_5.com_5_dataArray;

public class MemoryCom_1 extends arq_1.Memory {



    //Datos
    public static int[] com_1_dataArray = new int[255];
    private static int top = 0;

    //ingresa datos a la memoria, retorna la dirección de memoria donde quedó almacenado
    public static int ingresar(int dataIn){
        com_1_dataArray[top] = dataIn;
        top++;
        System.out.println("\u001B[33m" + "LOG_JVN_MACHINE_1:" + "\u001B[0m" +
                " \u001B[36m" + "ingresar()" +  "\u001B[0m " + "\u001B[33m" + "-->" + "\u001B[0m" +
                " Ingresa el dato " + dataIn + " en la memoria de la máquina.");
        return top - 1;

    }





    public static void cargar(String x,int dataArrayIndex){
        int registerArrayIndex = RegistersCom_1.indexMapper(x);
        switch (MemoryRed.memorySelectedCom) {
            case 1:
                RegistersCom_1.registersArray[registerArrayIndex] = com_1_dataArray[dataArrayIndex];
                break;
            case 2:
                RegistersCom_1.registersArray[registerArrayIndex] = com_2_dataArray[dataArrayIndex];
                break;
            case 3:
                RegistersCom_1.registersArray[registerArrayIndex] = com_3_dataArray[dataArrayIndex];
                break;
            case 4:
                RegistersCom_1.registersArray[registerArrayIndex] = com_4_dataArray[dataArrayIndex];
                break;

            case 5:
                RegistersCom_1.registersArray[registerArrayIndex] = com_5_dataArray[dataArrayIndex];
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
        int registerArrayIndex = RegistersCom_1.indexMapper(x);
        return RegistersCom_1.registersArray[registerArrayIndex];
    }
}
