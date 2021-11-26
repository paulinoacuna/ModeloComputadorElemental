package com_3;

public class RegistersCom_3 extends arq_1.Registers {

    public static int[] registersArray = new int[4];

    public static int indexMapper(String x){
        switch (x) {
            case "I":
                return 0;
            case "J":
                return 1;
            case "K":
                return 2;
            case "L":
                return 3;
            default:
                System.err.println("Error 001: El registro solicitado [" + x + "] no está definido, por favor revise los registros disponibles.");
                System.exit(-1);
                return -1;
        }
    }


}
