package com_3;

import arqRed.MemoryRed;
import com_2.RegistersCom_2;
import com_3.RegistersCom_3;

import static com_1.MemoryCom_1.com_1_dataArray;
import static com_2.MemoryCom_2.com_2_dataArray;
import static com_4.MemoryCom_4.com_4_dataArray;
import static com_5.MemoryCom_5.com_5_dataArray;


public class MemoryCom_3 extends arq_1.Memory {


    //Datos
    public static int[] com_3_dataArray = new int[255];
    private static int top = 0;

    //ingresa datos a la memoria, retorna la dirección de memoria donde quedó almacenado
    public static int ingresar(int dataIn){
        com_3_dataArray[top] = dataIn;
        top++;
        System.out.println("\u001B[33m" + "LOG_JVN_MACHINE_1:" + "\u001B[0m" +
                " \u001B[36m" + "ingresar()" +  "\u001B[0m " + "\u001B[33m" + "-->" + "\u001B[0m" +
                " Ingresa el dato " + dataIn + " en la memoria de la máquina.");
        return top - 1;

    }


    public static void cargar(String x,int dataArrayIndex){
        int registerArrayIndex = RegistersCom_3.indexMapper(x);
        switch (MemoryRed.memorySelectedCom) {
            case 1:
                RegistersCom_3.registersArray[registerArrayIndex] = com_1_dataArray[dataArrayIndex];
                break;
            case 2:
                RegistersCom_3.registersArray[registerArrayIndex] = com_2_dataArray[dataArrayIndex];
                break;
            case 3:
                RegistersCom_3.registersArray[registerArrayIndex] = com_3_dataArray[dataArrayIndex];
                break;
            case 4:
                RegistersCom_3.registersArray[registerArrayIndex] = com_4_dataArray[dataArrayIndex];
                break;

            case 5:
                RegistersCom_3.registersArray[registerArrayIndex] = com_5_dataArray[dataArrayIndex];
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


    //almacena un dato a en la posicion de memoria definida
    public static void almacenarDato(int a, int dataArrayIndex) {

        if(dataArrayIndex >= top || dataArrayIndex < 0){
            System.err.println("Error 003: La posicion de memoria [" + dataArrayIndex +"] no ha sido definida.");
            System.exit(-1);
        }else{
            com_3_dataArray[dataArrayIndex] = a;
        }
    }


    public static void mostrar(int dataArrayIndex){

        if(dataArrayIndex >= top || dataArrayIndex < 0){
            System.err.println("Error 002: No hay datos almacenados en la posicion de memoria " + dataArrayIndex);
            System.exit(-1);
        }else{
            System.out.println(com_3_dataArray[dataArrayIndex]);
        }

        System.out.println("\u001B[33m" + "LOG_JVN_MACHINE_1:" + "\u001B[0m" +
                " \u001B[36m" + "mostrar()" +  "\u001B[0m " + "\u001B[33m" + "-->" + "\u001B[0m" +
                " Imprime por pantalla virtual (consola) contenido de una posición de memoria específica.");
    }

    //clase privada para funcionamiento,no borrar ni usar como instrucción en Run. por favor copiar esta clase en todos los com.
    public static int enviarValordeRegistro(String x) {
        int registerArrayIndex = RegistersCom_3.indexMapper(x);
        return RegistersCom_3.registersArray[registerArrayIndex];
    }
}
