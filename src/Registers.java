public class Registers {

    /*
    Esta clase representa los registros, escenciales para
    hacer operaciones con la ALU
    [A,B,C,D]
    */

    public static int[] registersArray = new int[4];

    public static int indexMapper(String x){
        switch (x) {
            case "A":
                return 0;
            case "B":
                return 1;
            case "C":
                return 2;
            case "D":
                return 3;
            default:
                System.err.println("Error 001: El registro solicitado [" + x + "] no está definido, por favor revise los registros disponibles.");
                System.exit(-1);
                return -1;
        }
    }
}
