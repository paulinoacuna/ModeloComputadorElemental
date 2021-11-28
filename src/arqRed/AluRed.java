package arqRed;

import arq_1.Registers;
import com_1.AluCom_1;
import com_1.MemoryCom_1;
import com_2.AluCom_2;
import com_2.MemoryCom_2;
import com_3.AluCom_3;
import com_3.MemoryCom_3;
import com_4.AluCom_4;
import com_4.MemoryCom_4;
import com_5.AluCom_5;
import com_5.MemoryCom_5;

import static arq_1.Alu.flagsProcessor;

public class AluRed {

    //operaciones matematicas (6)

    //suma los registros x + y, el resultado lo guarda en x
    public static void suma(String x, String y) {
        System.out.println("Suma");
        //sumando x
        int temp1 = 0;

        if (x.equals("A") || x.equals("B") || x.equals("C") || x.equals("D")) {
            temp1 = MemoryCom_1.enviarValordeRegistro(x);
        } else if (x.equals("E") || x.equals("F") || x.equals("G") || x.equals("H")) {
            temp1 = MemoryCom_2.enviarValordeRegistro(x);
        } else if (x.equals("I") || x.equals("J") || x.equals("K") || x.equals("L")) {
            temp1 = MemoryCom_3.enviarValordeRegistro(x);
        } else if (x.equals("M") || x.equals("N") || x.equals("O") || x.equals("P")) {
            temp1 = MemoryCom_4.enviarValordeRegistro(x);
        } else if (x.equals("Q") || x.equals("R") || x.equals("S") || x.equals("T")) {
            temp1 = MemoryCom_5.enviarValordeRegistro(x);
        } else {
            System.err.println("Error 001: El registro solicitado [" + x + "] no está definido, por favor revise los registros disponibles.");
            System.exit(-1);
        }

        //sumando y
        int temp2 = 0;

        if (y.equals("A") || y.equals("B") || y.equals("C") || y.equals("D")) {
            temp2 = MemoryCom_1.enviarValordeRegistro(y);
        } else if (y.equals("E") || y.equals("F") || y.equals("G") || y.equals("H")) {
            temp2 = MemoryCom_2.enviarValordeRegistro(y);
        } else if (y.equals("I") || y.equals("J") || y.equals("K") || y.equals("L")) {
            temp2 = MemoryCom_3.enviarValordeRegistro(y);
        } else if (y.equals("M") || y.equals("N") || y.equals("O") || y.equals("P")) {
            temp2 = MemoryCom_4.enviarValordeRegistro(y);
        } else if (y.equals("Q") || y.equals("R") || y.equals("S") || y.equals("T")) {
            temp2 = MemoryCom_5.enviarValordeRegistro(y);
        } else {
            System.err.println("Error 001: El registro solicitado [" + x + "] no está definido, por favor revise los registros disponibles.");
            System.exit(-1);
        }

        //opera x + y;
        int result = temp1 + temp2;


        //procesa las banderas
        switch (MemoryRed.aluSelectedCom) {
            case 1:
                 AluCom_1.flagsProcessor(result);
            break;
            case 2:
                AluCom_2.flagsProcessor(result);
            break;
            case 3:
                AluCom_3.flagsProcessor(result);
            break;
            case 4:
                AluCom_4.flagsProcessor(result);
            break;
            case 5:
                AluCom_5.flagsProcessor(result);
            break;
            default:
                System.err.println("Error en la selección del Computador");
                System.exit(-1);
                break;

        }

        //ingresa el resultado en memoria y luego sobrescribe en el registro x
        int dataArrayIndex = MemoryRed.ingresar(result);
        MemoryRed.cargar(x,dataArrayIndex);

    }

    public static void resta(String x, int a) {
        System.out.println("Resta");
        int temp1 = 0;

        if (x.equals("A") || x.equals("B") || x.equals("C") || x.equals("D")) {
            temp1 = MemoryCom_1.enviarValordeRegistro(x);
        } else if (x.equals("E") || x.equals("F") || x.equals("G") || x.equals("H")) {
            temp1 = MemoryCom_2.enviarValordeRegistro(x);
        } else if (x.equals("I") || x.equals("J") || x.equals("K") || x.equals("L")) {
            temp1 = MemoryCom_3.enviarValordeRegistro(x);
        } else if (x.equals("M") || x.equals("N") || x.equals("O") || x.equals("P")) {
            temp1 = MemoryCom_4.enviarValordeRegistro(x);
        } else if (x.equals("Q") || x.equals("R") || x.equals("S") || x.equals("T")) {
            temp1 = MemoryCom_5.enviarValordeRegistro(x);
        } else {
            System.err.println("Error 001: El registro solicitado [" + x + "] no está definido, por favor revise los registros disponibles.");
            System.exit(-1);
        }

        //opera x - a;
        int result = temp1 - a;

        //procesa las banderas
        switch (MemoryRed.aluSelectedCom) {
            case 1:
                AluCom_1.flagsProcessor(result);
                break;
            case 2:
                AluCom_2.flagsProcessor(result);
                break;
            case 3:
                AluCom_3.flagsProcessor(result);
                break;
            case 4:
                AluCom_4.flagsProcessor(result);
                break;
            case 5:
                AluCom_5.flagsProcessor(result);
                break;
            default:
                System.err.println("Error en la selección del Computador");
                System.exit(-1);
                break;

        }

        //ingresa el resultado en memoria y luego sobrescribe en el registro x
        int dataArrayIndex = MemoryRed.ingresar(result);
        MemoryRed.cargar(x,dataArrayIndex);

    }

    public static void modulo(String x, String y) {
        System.out.println("Módulo");
        int temp1 = 0;

        if (x.equals("A") || x.equals("B") || x.equals("C") || x.equals("D")) {
            temp1 = MemoryCom_1.enviarValordeRegistro(x);
        } else if (x.equals("E") || x.equals("F") || x.equals("G") || x.equals("H")) {
            temp1 = MemoryCom_2.enviarValordeRegistro(x);
        } else if (x.equals("I") || x.equals("J") || x.equals("K") || x.equals("L")) {
            temp1 = MemoryCom_3.enviarValordeRegistro(x);
        } else if (x.equals("M") || x.equals("N") || x.equals("O") || x.equals("P")) {
            temp1 = MemoryCom_4.enviarValordeRegistro(x);
        } else if (x.equals("Q") || x.equals("R") || x.equals("S") || x.equals("T")) {
            temp1 = MemoryCom_5.enviarValordeRegistro(x);
        } else {
            System.err.println("Error 001: El registro solicitado [" + x + "] no está definido, por favor revise los registros disponibles.");
            System.exit(-1);
        }

        int temp2 = 0;

        if (y.equals("A") || y.equals("B") || y.equals("C") || y.equals("D")) {
            temp2 = MemoryCom_1.enviarValordeRegistro(y);
        } else if (y.equals("E") || y.equals("F") || y.equals("G") || y.equals("H")) {
            temp2 = MemoryCom_2.enviarValordeRegistro(y);
        } else if (y.equals("I") || y.equals("J") || y.equals("K") || y.equals("L")) {
            temp2 = MemoryCom_3.enviarValordeRegistro(y);
        } else if (y.equals("M") || y.equals("N") || y.equals("O") || y.equals("P")) {
            temp2 = MemoryCom_4.enviarValordeRegistro(y);
        } else if (y.equals("Q") || y.equals("R") || y.equals("S") || y.equals("T")) {
            temp2 = MemoryCom_5.enviarValordeRegistro(y);
        } else {
            System.err.println("Error 001: El registro solicitado [" + x + "] no está definido, por favor revise los registros disponibles.");
            System.exit(-1);
        }

        //opera x % y;
        int result = temp1 % temp2;


        //procesa las banderas
        switch (MemoryRed.aluSelectedCom) {
            case 1:
                AluCom_1.flagsProcessor(result);
                break;
            case 2:
                AluCom_2.flagsProcessor(result);
                break;
            case 3:
                AluCom_3.flagsProcessor(result);
                break;
            case 4:
                AluCom_4.flagsProcessor(result);
                break;
            case 5:
                AluCom_5.flagsProcessor(result);
                break;
            default:
                System.err.println("Error en la selección del Computador");
                System.exit(-1);
                break;
        }

        //ingresa el resultado en memoria y luego sobrescribe en el registro x
        int dataArrayIndex = MemoryRed.ingresar(result);
        MemoryRed.cargar(x, dataArrayIndex);
    }



    //saltos

    public static boolean saltarSiCero(){

        switch (MemoryRed.aluSelectedCom) {
            case 1:
                return AluCom_1.saltarSiCero();

            case 2:
                return AluCom_2.saltarSiCero();

            case 3:
                return AluCom_3.saltarSiCero();

            case 4:
                return AluCom_4.saltarSiCero();

            case 5:
                return AluCom_5.saltarSiCero();

            default:
                System.err.println("Error en la selección del Computador");
                System.exit(-1);
                return false;

        }
    }

    public static boolean saltarSiPos(){


        switch (MemoryRed.aluSelectedCom) {
            case 1:
                return AluCom_1.saltarSiPos();

            case 2:
                return AluCom_2.saltarSiPos();

            case 3:
                return AluCom_3.saltarSiPos();

            case 4:
                return AluCom_4.saltarSiPos();

            case 5:
                return AluCom_5.saltarSiPos();

            default:
                System.err.println("Error en la selección del Computador");
                System.exit(-1);
                return false;

        }
    }

    public static boolean saltarSiNeg(){

        switch (MemoryRed.aluSelectedCom) {
            case 1:
                return AluCom_1.saltarSiNeg();

            case 2:
                return AluCom_2.saltarSiNeg();

            case 3:
                return AluCom_3.saltarSiNeg();

            case 4:
                return AluCom_4.saltarSiNeg();

            case 5:
                return AluCom_5.saltarSiNeg();

            default:
                System.err.println("Error en la selección del Computador");
                System.exit(-1);
                return false;

        }
    }

    public static boolean saltarSiDes(){

        switch (MemoryRed.aluSelectedCom) {
            case 1:
                return AluCom_1.saltarSiDes();

            case 2:
                return AluCom_2.saltarSiDes();

            case 3:
                return AluCom_3.saltarSiDes();

            case 4:
                return AluCom_4.saltarSiDes();

            case 5:
                return AluCom_5.saltarSiDes();

            default:
                System.err.println("Error en la selección del Computador");
                System.exit(-1);
                return false;
        }
    }

}
