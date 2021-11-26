package com_2;

public class RegistersCom_2 extends arq_1.Registers{



    public static int[] registersArray = new int[4];

    public static int indexMapper(String x){
        switch (x) {
            case "E":
                return 0;
            case "F":
                return 1;
            case "G":
                return 2;
            case "H":
                return 3;
            default:
                System.err.println("Error 001: El registro solicitado [" + x + "] no está definido, por favor revise los registros disponibles.");
                System.exit(-1);
                return -1;
        }
    }


}
