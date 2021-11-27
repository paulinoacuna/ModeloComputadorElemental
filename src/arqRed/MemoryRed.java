package arqRed;

import arq_1.Registers;
import com_1.AluCom_1;
import com_1.MemoryCom_1;
import com_2.MemoryCom_2;
import com_3.MemoryCom_3;
import com_4.MemoryCom_4;
import com_5.MemoryCom_5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MemoryRed {

    //Esta clase representa la memoría del computador virtual
    //matriz de prioridad
    /*
    *               posicion de las filas de la matriz
    *     ALU         0
    *    MEMORY       1
    *    REGISTERS    2
    * */

    /*
    * cada computador tiene un id, este se almacena en la matriz de forma aleatoria así
    * estableciendo prioridad de computo
    * */

    public static int aluSelectedCom;
    public static int memorySelectedCom;
    public static int registersSelectedCom;

    static int priorityMatrixIndexCounter = 0;

    public static int[][] priorityMatrix = new int[3][5];

    public static void randomizePriorityMatrix(){


        ArrayList<Integer> priorityAlu = new ArrayList<>();
        ArrayList<Integer> priorityMemory = new ArrayList<>();
        ArrayList<Integer> priorityRegisters = new ArrayList<>();


        //carga la matriz con prioridad aleatoria.
        for (int i = 1; i <= 5; i++) {
            priorityAlu.add(i);
            priorityMemory.add(i);
            priorityRegisters.add(i);
        }
        Collections.shuffle(priorityAlu);
        Collections.shuffle(priorityMemory);
        Collections.shuffle(priorityRegisters);

        for (int i = 0; i < priorityMatrix.length; i++) {

            for (int j = 0; j < priorityMatrix[i].length; j++) {

                if (i==0){
                    priorityMatrix[i][j] = priorityAlu.get(j);
                }else if(i==1){
                    priorityMatrix[i][j] = priorityMemory.get(j);
                }else if(i==2){
                    priorityMatrix[i][j] = priorityRegisters.get(j);
                }

            }
        }

    //imprime el contenido de la matriz
        for (int i = 0; i < priorityMatrix.length; i++) {
            for (int j = 0; j < priorityMatrix[i].length; j++) {
                System.out.print(priorityMatrix[i][j] + " ");
            }
            System.out.print("\n");
        }

    }


    public static void selectPriorityComps(){
        aluSelectedCom = priorityMatrix[0][0];
        memorySelectedCom = priorityMatrix[1][0];
        registersSelectedCom = priorityMatrix[2][0];

        System.out.println("Alu del computador " + aluSelectedCom + " seleccionada.");
        System.out.println("Memoria del computador " + memorySelectedCom + " seleccionada.");
        System.out.println("Registos del computador " + registersSelectedCom + " seleccionada.");
    }

    //microservicios (6.)

    //1. ingresa datos a la memoria, retorna la dirección de memoria donde quedó almacenado
    public static int ingresar(int dataIn){

        switch (memorySelectedCom) {
            case 1:
                return MemoryCom_1.ingresar(dataIn);

            case 2:
                return MemoryCom_2.ingresar(dataIn);

            case 3:
                return MemoryCom_3.ingresar(dataIn);

            case 4:
                return MemoryCom_4.ingresar(dataIn);

            case 5:
                return MemoryCom_5.ingresar(dataIn);

            default:
                System.err.println("Error en la selección del Computador");
                System.exit(-1);
                return -1;

        }
    }

    //2. carga datos de la memoria en los registros
    public static void cargar(String x,int dataArrayIndex){

        if (x.equals("A") || x.equals("B") || x.equals("C") || x.equals("D")) {
            MemoryCom_1.cargar(x,dataArrayIndex);
        } else if (x.equals("E") || x.equals("F") || x.equals("G") || x.equals("H")) {
            MemoryCom_2.cargar(x,dataArrayIndex);
        } else if (x.equals("I") || x.equals("J") || x.equals("K") || x.equals("L")) {
            MemoryCom_3.cargar(x,dataArrayIndex);
        } else if (x.equals("M") || x.equals("N") || x.equals("O") || x.equals("P")) {
            MemoryCom_4.cargar(x,dataArrayIndex);
        } else if (x.equals("Q") || x.equals("R") || x.equals("S") || x.equals("T")) {
            MemoryCom_5.cargar(x,dataArrayIndex);
        }else {
            System.err.println("Error 001: El registro solicitado [" + x + "] no está definido, por favor revise los registros disponibles.");
            System.exit(-1);

        }
    }


    //3. descarga los datos del registro x en memoria, retorna posicion de memoria.
    public static int almacenar(String x) {

        if (x.equals("A") || x.equals("B") || x.equals("C") || x.equals("D")) {
            int temp = MemoryCom_1.enviarValordeRegistro(x);
            return MemoryRed.ingresar(temp);
        } else if (x.equals("E") || x.equals("F") || x.equals("G") || x.equals("H")) {
            int temp = MemoryCom_2.enviarValordeRegistro(x);
            return MemoryRed.ingresar(temp);
        } else if (x.equals("I") || x.equals("J") || x.equals("K") || x.equals("L")) {
            int temp = MemoryCom_3.enviarValordeRegistro(x);
            return MemoryRed.ingresar(temp);
        } else if (x.equals("M") || x.equals("N") || x.equals("O") || x.equals("P")) {
            int temp = MemoryCom_4.enviarValordeRegistro(x);
            return MemoryRed.ingresar(temp);
        } else if (x.equals("Q") || x.equals("R") || x.equals("S") || x.equals("T")) {
            int temp = MemoryCom_5.enviarValordeRegistro(x);
            return MemoryRed.ingresar(temp);
        }else {
            System.err.println("Error 001: El registro solicitado [" + x + "] no está definido, por favor revise los registros disponibles.");
            System.exit(-1);
            return -1;
        }

    }

    //4. muestra el contenido de una posicion de memoria
    public static void mostrar(int dataArrayIndex) {

        switch (memorySelectedCom) {
            case 1:
                MemoryCom_1.mostrar(dataArrayIndex);
            break;
            case 2:
                MemoryCom_2.mostrar(dataArrayIndex);
            break;
            case 3:
                MemoryCom_3.mostrar(dataArrayIndex);
            break;
            case 4:
                MemoryCom_4.mostrar(dataArrayIndex);
            break;
            case 5:
                MemoryCom_5.mostrar(dataArrayIndex);
            break;
            default:
                System.err.println("Error en la selección del Computador");
                System.exit(-1);
        }

    }

    //5. copia los datos del registro x en el registro y
    public static void copiar(String x,String y){

        int temp = 0;

        if (x.equals("A") || x.equals("B") || x.equals("C") || x.equals("D")) {
            temp = MemoryCom_1.enviarValordeRegistro(x);

        } else if (x.equals("E") || x.equals("F") || x.equals("G") || x.equals("H")) {
            temp = MemoryCom_2.enviarValordeRegistro(x);

        } else if (x.equals("I") || x.equals("J") || x.equals("K") || x.equals("L")) {
            temp = MemoryCom_3.enviarValordeRegistro(x);

        } else if (x.equals("M") || x.equals("N") || x.equals("O") || x.equals("P")) {
            temp = MemoryCom_4.enviarValordeRegistro(x);

        } else if (x.equals("Q") || x.equals("R") || x.equals("S") || x.equals("T")) {
            temp = MemoryCom_5.enviarValordeRegistro(x);
        }else {
            System.err.println("Error 001: El registro solicitado [" + x + "] no está definido, por favor revise los registros disponibles.");
            System.exit(-1);

        }

        //ingresa el resultado en memoria y luego lo guarda en y
        int dataArrayIndex = MemoryRed.ingresar(temp);
        MemoryRed.cargar(y,dataArrayIndex);
    }

    //6. descarga los datos del registro x en la posicion de memoria definida
    public static void almacenar(String x, int dataArrayIndex) {

        int temp = 0;

        if (x.equals("A") || x.equals("B") || x.equals("C") || x.equals("D")) {
            temp = MemoryCom_1.enviarValordeRegistro(x);
        } else if (x.equals("E") || x.equals("F") || x.equals("G") || x.equals("H")) {
            temp = MemoryCom_2.enviarValordeRegistro(x);

        } else if (x.equals("I") || x.equals("J") || x.equals("K") || x.equals("L")) {
            temp = MemoryCom_3.enviarValordeRegistro(x);

        } else if (x.equals("M") || x.equals("N") || x.equals("O") || x.equals("P")) {
            temp = MemoryCom_4.enviarValordeRegistro(x);

        } else if (x.equals("Q") || x.equals("R") || x.equals("S") || x.equals("T")) {
            temp = MemoryCom_5.enviarValordeRegistro(x);

        }else {
            System.err.println("Error 001: El registro solicitado [" + x + "] no está definido, por favor revise los registros disponibles.");
            System.exit(-1);

        }

        switch (memorySelectedCom) {
            case 1:
                MemoryCom_1.almacenarDato(temp,dataArrayIndex);
                break;
            case 2:
                MemoryCom_2.almacenarDato(temp,dataArrayIndex);
                break;
            case 3:
                MemoryCom_3.almacenarDato(temp,dataArrayIndex);
                break;
            case 4:
                MemoryCom_4.almacenarDato(temp,dataArrayIndex);
                break;
            case 5:
                MemoryCom_5.almacenarDato(temp,dataArrayIndex);
                break;
            default:
                System.err.println("Error en la selección del Computador");
                System.exit(-1);
        }
    }






}
