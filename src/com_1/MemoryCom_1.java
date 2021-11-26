package com_1;

import arq_1.Registers;

public class MemoryCom_1 extends arq_1.Memory {












    //clase privada para funcionamiento,no borrar ni usar como instrucción en Run. por favor copiar esta clase en todos los com.
    public static int enviarValordeRegistro(String x){
        int registerArrayIndex = RegistersCom_1.indexMapper(x);
        return RegistersCom_1.registersArray[registerArrayIndex];
    }
}
