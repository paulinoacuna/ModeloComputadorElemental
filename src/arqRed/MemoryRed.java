package arqRed;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MemoryRed {

     /*
    Esta clase representa la memoría del computador virtual
    */

    //matriz de prioridad

    /*
    *               posicion de las filas de la matriz
    *     ALU         0
    *    MEMORY       1
    *    REGISTERS    2
    *
    * */

    /*
    * cada computador tiene un id, este se almacena en la matriz de forma aleatoria así estableciendo prioridad de computo
    * */

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


    public static void memory(){

    }


    //microservicios almenos 10.






}
