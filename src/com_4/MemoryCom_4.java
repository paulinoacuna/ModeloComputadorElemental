package com_4;

import com_4.RegistersCom_4;

public class MemoryCom_4 extends arq_2.Memory2 {












    //clase privada para funcionamiento,no borrar ni usar como instrucción en Run. por favor copiar esta clase en todos los com.
    public static int enviarValordeRegistro(String x) {
        int registerArrayIndex = RegistersCom_4.indexMapper(x);
        return RegistersCom_4.registersArray[registerArrayIndex];
    }
}
