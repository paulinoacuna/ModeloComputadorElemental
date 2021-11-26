package arq_2;

public class Memory2 {

    /*
    Esta clase representa la memoría, los datos se encuentran en el dataArray y
    todas las instrucciónes ISA son las funciones definidas (arquitectura von-Neumann)
    */


    //Datos
    public static int[] dataArray = new int[255];
    private static int top = 0;


   //Instrucciones (5)

    //ingresa datos a la memoria, retorna la dirección de memoria donde quedó almacenado
    public static int ingresar(int dataIn){
        dataArray[top] = dataIn;
        top++;
        System.out.println("\u001B[34m" + "LOG_JVN_MACHINE_2:" + "\u001B[0m" +
                " \u001B[36m" + "ingresar()" +  "\u001B[0m " + "\u001B[34m" + "-->" + "\u001B[0m" +
                " Ingresa el dato " + dataIn + " en la memoria de la máquina.");
        return top - 1;
    }

    //carga datos de la memoria en los registros
    public static void cargar(String x,int dataArrayIndex){
        int registerArrayIndex = Registers2.indexMapper(x);

        Registers2.registersArray[registerArrayIndex] = dataArray[dataArrayIndex];

        System.out.println("\u001B[34m" + "LOG_JVN_MACHINE_2:" + "\u001B[0m" +
                " \u001B[36m" + "cargar()" +  "\u001B[0m " + "\u001B[34m" + "-->" + "\u001B[0m" +
                " Carga un valor de memoria al registro " + x + ".");
    }

    //descarga los datos del registro x en memoria, retorna pocicion de memoria.
    public static int almacenar(String x) {
        int registerArrayIndex = Registers2.indexMapper(x);
        dataArray[top] = Registers2.registersArray[registerArrayIndex];
        top++;
        System.out.println("\u001B[34m" + "LOG_JVN_MACHINE_2:" + "\u001B[0m" +
                " \u001B[36m" + "almacenar()" +  "\u001B[0m " + "\u001B[34m" + "-->" + "\u001B[0m" +
                " Almacena los datos del registro " + x + " en memoria, retornando dicha posición de memoria.");
        return top - 1;
    }

    //descarga los datos del registro x en la posicion de memoria definida
    public static void almacenar(String x, int dataArrayIndex) {
        int registerArrayIndex = Registers2.indexMapper(x);

        if(dataArrayIndex >= top || dataArrayIndex < 0){
            System.err.println("Error 003: La posicion de memoria [" + dataArrayIndex +"] no ha sido definida.");
            System.exit(-1);
        }else{
            dataArray[dataArrayIndex] = Registers2.registersArray[registerArrayIndex];
        }

        System.out.println("\u001B[34m" + "LOG_JVN_MACHINE_2:" + "\u001B[0m" +
                " \u001B[36m" + "almacenar()" +  "\u001B[0m " + "\u001B[34m" + "-->" + "\u001B[0m" +
                " Almacena los datos del registro " + x + " en memoria.");
    }

    //almacena un dato a en la posicion de memoria definida
    public static void almacenarDato(int a, int dataArrayIndex) {

        if(dataArrayIndex >= top || dataArrayIndex < 0){
            System.err.println("Error 003: La posicion de memoria [" + dataArrayIndex +"] no ha sido definida.");
            System.exit(-1);
        }else{
            dataArray[dataArrayIndex] = a;
        }
    }


    //copia los datos del registro x en el registro y
    public static void copiar(String x,String y){
        int registerArrayIndexX = Registers2.indexMapper(x);
        int registerArrayIndexY = Registers2.indexMapper(y);

        Registers2.registersArray[registerArrayIndexY] = Registers2.registersArray[registerArrayIndexX];

        System.out.println("\u001B[34m" + "LOG_JVN_MACHINE_2:" + "\u001B[0m" +
                " \u001B[36m" + "copiar()" +  "\u001B[0m " + "\u001B[34m" + "-->" + "\u001B[0m" +
                " Copia datos del registro " + x + " en el registro " + y + ".");
    }


    //muestra el contenido de una posicion de memoria
    public static void mostrar(int dataArrayIndex){

        if(dataArrayIndex >= top || dataArrayIndex < 0){
            System.err.println("Error 002: No hay datos almacenados en la posicion de memoria " + dataArrayIndex);
            System.exit(-1);
        }else{
            System.out.println(dataArray[dataArrayIndex]);
        }
        System.out.println("\u001B[34m" + "LOG_JVN_MACHINE_2:" + "\u001B[0m" +
                " \u001B[36m" + "mostrar()" +  "\u001B[0m " + "\u001B[34m" + "-->" + "\u001B[0m" +
                " Imprime por pantalla virtual (consola) contenido de una posición de memoria específica.");
    }
















}
