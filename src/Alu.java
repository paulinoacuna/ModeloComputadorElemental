public class Alu {

     /*
    Esta clase representa la ALU, contiene flags.
    [
     C := zero
     P := positive
     N := negative
     D := overflow
    ]
      */

    public static int[] flagsArray = {0,0,0,0};


    private static void flagsProcessor(int result) {
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
        int registerArrayIndexX = Registers.indexMapper(x);
        int registerArrayIndexY = Registers.indexMapper(y);

        int result = Registers.registersArray[registerArrayIndexX] + Registers.registersArray[registerArrayIndexY];

        flagsProcessor(result);

        Registers.registersArray[registerArrayIndexX] = result;
    }

    //suma el registro x con el valor a, el resultado lo guarda en x
    public static void suma(String x,int a){
        int registerArrayIndexX = Registers.indexMapper(x);

        int result = Registers.registersArray[registerArrayIndexX] + a;

        flagsProcessor(result);

        Registers.registersArray[registerArrayIndexX] = result;
    }


    //resta el registro x con el registro y, el resultado lo guarda en x
    public static void resta(String x,String y){
        int registerArrayIndexX = Registers.indexMapper(x);
        int registerArrayIndexY = Registers.indexMapper(y);

        int result = Registers.registersArray[registerArrayIndexX] - Registers.registersArray[registerArrayIndexY];

        flagsProcessor(result);

        Registers.registersArray[registerArrayIndexX] = result;
    }

    //resta el registro x con el valor a, el resultado lo guarda en x
    public static void resta(String x,int a){
        int registerArrayIndexX = Registers.indexMapper(x);

        int result = Registers.registersArray[registerArrayIndexX] - a;

        flagsProcessor(result);

        Registers.registersArray[registerArrayIndexX] = result;
    }

    public static void modulo(String x,String y){
        int registerArrayIndexX = Registers.indexMapper(x);
        int registerArrayIndexY = Registers.indexMapper(y);

        int result = Registers.registersArray[registerArrayIndexX] % Registers.registersArray[registerArrayIndexY];

        //System.out.println(result);

        flagsProcessor(result);

        Registers.registersArray[registerArrayIndexX] = result;
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