package com_5;

public class RegistersCom_5 extends arq_2.Registers2 {

    public static int[] registersArray = new int[4];

    public static int indexMapper(String x){
        switch (x) {
            case "Q":
                return 0;
            case "R":
                return 1;
            case "S":
                return 2;
            case "T":
                return 3;
            default:
                System.err.println("Error 001: El registro solicitado [" + x + "] no está definido, por favor revise los registros disponibles.");
                System.exit(-1);
                return -1;
        }
    }


}
