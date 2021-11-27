package arq_2;

public class Alu2 {
    // Flags [C := zero, P := positive, N := negative, D := overflow]

    public static int[] flagsArray = {0,0,0,0};

    public static void flagsProcessor(int result) {
        flagsArray[0] = 0;
        flagsArray[1] = 0;
        flagsArray[2] = 0;
        flagsArray[3] = 0;

        if(result == 0){
            flagsArray[0] = 1;
        }else if(result > 0){
            flagsArray[1] = 1;
        }else if(result < 0){
            flagsArray[2] = 1;
        }
        if(result > 65535) {
            flagsArray[3] = 1; //PC de 16 bits
            System.err.println("Error 003: ha sobrepasado el limite de memoria. \n Si desea trabajar con numeros mas grandes, amplíe la capacidad de cálculo entre registros. actual: (16 bits)");
            System.exit(-1);
        }
    }

    //operaciones matematicas

    //suma los registros x + y, el resultado lo guarda en x
    public static void suma(String x,String y){
        int registerArrayIndexX = Registers2.indexMapper(x);
        int registerArrayIndexY = Registers2.indexMapper(y);

        int result = Registers2.registersArray[registerArrayIndexX] + Registers2.registersArray[registerArrayIndexY];

        flagsProcessor(result);

        Registers2.registersArray[registerArrayIndexX] = result;

        System.out.println("\u001B[34m" + "LOG_JVN_MACHINE_2:" + "\u001B[0m" +
                " \u001B[36m" + "suma()" +  "\u001B[0m " + "\u001B[34m" + "-->" + "\u001B[0m" +
                " Suma de valores en los registros " + x + " y " + y +
                ". Resultado almacenado en el registro " + x + ".");
    }

    //suma el registro x con el valor a, el resultado lo guarda en x
    public static void suma(String x,int a){
        int registerArrayIndexX = Registers2.indexMapper(x);

        int result = Registers2.registersArray[registerArrayIndexX] + a;

        flagsProcessor(result);

        Registers2.registersArray[registerArrayIndexX] = result;

        System.out.println("\u001B[34m" + "LOG_JVN_MACHINE_2:" + "\u001B[0m" +
                " \u001B[36m" + "suma()" +  "\u001B[0m " + "\u001B[34m" + "-->" + "\u001B[0m" +
                " Suma el valor del registro " + x + " más la constante " + a +
                ". Resultado almacenado en el registro " + x + ".");
    }

    //resta el registro x con el registro y, el resultado lo guarda en x
    public static void resta(String x,String y){
        int registerArrayIndexX = Registers2.indexMapper(x);
        int registerArrayIndexY = Registers2.indexMapper(y);

        int result = Registers2.registersArray[registerArrayIndexX] - Registers2.registersArray[registerArrayIndexY];

        flagsProcessor(result);

        Registers2.registersArray[registerArrayIndexX] = result;

        System.out.println("\u001B[34m" + "LOG_JVN_MACHINE_2:" + "\u001B[0m" +
                " \u001B[36m" + "resta()" +  "\u001B[0m " + "\u001B[34m" + "-->" + "\u001B[0m" +
                " Resta de valores en los registros " + x + " y " + y +
                ". Resultado almacenado en el registro " + x + ".");
    }

    //resta el registro x con el valor a, el resultado lo guarda en x
    public static void resta(String x,int a){
        int registerArrayIndexX = Registers2.indexMapper(x);

        int result = Registers2.registersArray[registerArrayIndexX] - a;

        flagsProcessor(result);

        Registers2.registersArray[registerArrayIndexX] = result;

        System.out.println("\u001B[34m" + "LOG_JVN_MACHINE_2:" + "\u001B[0m" +
                " \u001B[36m" + "resta()" +  "\u001B[0m " + "\u001B[34m" + "-->" + "\u001B[0m" +
                " Resta el valor del registro " + x + " menos la constante " + a +
                ". Resultado almacenado en el registro " + x + ".");
    }

    public static void modulo(String x,String y){
        int registerArrayIndexX = Registers2.indexMapper(x);
        int registerArrayIndexY = Registers2.indexMapper(y);

        int result = Registers2.registersArray[registerArrayIndexX] % Registers2.registersArray[registerArrayIndexY];

        //System.out.println(result);

        flagsProcessor(result);

        Registers2.registersArray[registerArrayIndexX] = result;

        System.out.println("\u001B[34m" + "LOG_JVN_MACHINE_2:" + "\u001B[0m" +
                " \u001B[36m" + "modulo()" +  "\u001B[0m " + "\u001B[34m" + "-->" + "\u001B[0m" +
                " Residuo de la división entre los valores de los registros " + x + " y " + y +
                ". Resultado almacenado en el registro " + x + ".");
    }

    public static void modulo(String x, int a){
        int registerArrayIndexX = Registers2.indexMapper(x);

        int result = Registers2.registersArray[registerArrayIndexX] % a;

        flagsProcessor(result);

        Registers2.registersArray[registerArrayIndexX] = result;

        System.out.println("\u001B[34m" + "LOG_JVN_MACHINE_2:" + "\u001B[0m" +
                " \u001B[36m" + "modulo()" +  "\u001B[0m " + "\u001B[34m" + "-->" + "\u001B[0m" +
                " Residuo de la división entre el valor del registro " + x + " y la constante " + a +
                ". Resultado almacenado en el registro " + x + ".");
    }

    // Eleva al cuadrado el valor en el registro X y devuelve el resultado en dicho registro.
    public static void cuadrado(String x) {
        int registerArrayIndexX = Registers2.indexMapper(x);

        int result = Registers2.registersArray[registerArrayIndexX] * Registers2.registersArray[registerArrayIndexX];

        Registers2.registersArray[registerArrayIndexX] = result;

        System.out.println("\u001B[34m" + "LOG_JVN_MACHINE_2:" + "\u001B[0m" +
                " \u001B[36m" + "cuadrado()" +  "\u001B[0m " + "\u001B[34m" + "-->" + "\u001B[0m" +
                " Cálculo del cuadrado del valor en el registro " + x +
                ". Resultado almacenado en el registro " + x + ".");

    }

    // Evalua si el número en el registro X es primo. Si lo es, devuelve 1, si no, devuelve 0.
    public static void primo(String x) {
        int registerArrayIndexX = Registers2.indexMapper(x);


        if (Registers2.registersArray[registerArrayIndexX] == 1 || Registers2.registersArray[registerArrayIndexX] == 0) {
            System.err.println("Error 005: Las opciones 0, 1 y 2 no están permitidas como entrada para la microinstrucción primo().");
            System.exit(-1);
        } else {
            for (int i = 2; i < Registers2.registersArray[registerArrayIndexX]/2; i++) {
                if (Registers2.registersArray[registerArrayIndexX] % i == 0) {
                    Registers2.registersArray[registerArrayIndexX] = 1;
                    break;
                }
            }
            if (Registers2.registersArray[registerArrayIndexX] == 1) {
                Registers2.registersArray[registerArrayIndexX] = 1;

            } else {
                Registers2.registersArray[registerArrayIndexX] = 0;
            }
        }
        System.out.println("\u001B[34m" + "LOG_JVN_MACHINE_2:" + "\u001B[0m" +
                " \u001B[36m" + "primo()" +  "\u001B[0m " + "\u001B[34m" + "-->" + "\u001B[0m" +
                " Cálculo de la primalidad del valor en el registro " + x +
                ". Resultado almacenado en el registro " + x + ".");


    }

    //saltos

    public static boolean saltarSiCero(){
        if (flagsArray[0] == 1) {
            return true;
        }
        return false;
    }

    public static boolean saltarSiPos(){
        if (flagsArray[1] == 1) {
            return true;
        }
        return false;
    }

    public static boolean saltarSiNeg(){
        if (flagsArray[2] == 1) {
            return true;
        }
        return false;
    }

    public static boolean saltarSiDes(){
        if (flagsArray[3] == 1) {
            return true;
        }
        return false;
    }

}
