package com_5;

import com_5.RegistersCom_5;

public class MemoryCom_5 extends arq_2.Memory2 {












    //clase privada para funcionamiento,no borrar ni usar como instrucción en Run. por favor copiar esta clase en todos los com.
    public static int enviarValordeRegistro(String x) {
        int registerArrayIndex = RegistersCom_5.indexMapper(x);
        return RegistersCom_5.registersArray[registerArrayIndex];
    }
}
