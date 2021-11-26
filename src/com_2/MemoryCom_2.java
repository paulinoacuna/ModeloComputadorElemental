package com_2;

import com_2.RegistersCom_2;

public class MemoryCom_2 extends arq_1.Memory {












    //clase privada para funcionamiento,no borrar ni usar como instrucción en Run. por favor copiar esta clase en todos los com.
    public static int enviarValordeRegistro(String x) {
        int registerArrayIndex = RegistersCom_2.indexMapper(x);
        return RegistersCom_2.registersArray[registerArrayIndex];
    }
}
