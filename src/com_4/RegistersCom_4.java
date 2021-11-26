package com_4;

public class RegistersCom_4 extends arq_2.Registers2 {

    public static int[] registersArray = new int[4];

    public static int indexMapper(String x){
        switch (x) {
            case "M":
                return 0;
            case "N":
                return 1;
            case "O":
                return 2;
            case "P":
                return 3;
            default:
                System.err.println("Error 001: El registro solicitado [" + x + "] no está definido, por favor revise los registros disponibles.");
                System.exit(-1);
                return -1;
        }
    }


}
