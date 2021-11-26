package com_3;

import com_3.RegistersCom_3;

public class MemoryCom_3 extends arq_1.Memory {












    //clase privada para funcionamiento,no borrar ni usar como instrucción en Run. por favor copiar esta clase en todos los com.
    public static int enviarValordeRegistro(String x) {
        int registerArrayIndex = RegistersCom_3.indexMapper(x);
        return RegistersCom_3.registersArray[registerArrayIndex];
    }
}
