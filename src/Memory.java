public class Memory {

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
        return top - 1;
    }

    //carga datos de la memoria en los registros
    public static void cargar(String x,int dataArrayIndex){
        int registerArrayIndex = Registers.indexMapper(x);

        Registers.registersArray[registerArrayIndex] = dataArray[dataArrayIndex];
    }

    //descarga los datos del registro x en memoria, retorna pocicion de memoria.
    public static int almacenar(String x) {
        int registerArrayIndex = Registers.indexMapper(x);
        dataArray[top] = Registers.registersArray[registerArrayIndex];
        top++;
        return top - 1;
    }

    //descarga los datos del registro x en la posicion de memoria definida
    public static void almacenar(String x, int dataArrayIndex) {
        int registerArrayIndex = Registers.indexMapper(x);

        if(dataArrayIndex >= top || dataArrayIndex < 0){
            System.err.println("Error 003: La posicion de memoria [" + dataArrayIndex +"] no ha sido definida.");
            System.exit(-1);
        }else{
            dataArray[dataArrayIndex] = Registers.registersArray[registerArrayIndex];
        }
    }


    //copia los datos del registro x en el registro y
    public static void copiar(String x,String y){
        int registerArrayIndexX = Registers.indexMapper(x);
        int registerArrayIndexY = Registers.indexMapper(y);

        Registers.registersArray[registerArrayIndexY] = Registers.registersArray[registerArrayIndexX];
    }


    //muestra el contenido de una posicion de memoria
    public static void mostrar(int dataArrayIndex){

        if(dataArrayIndex >= top || dataArrayIndex < 0){
            System.err.println("Error 002: No hay datos almacenados en la posicion de memoria " + dataArrayIndex);
            System.exit(-1);
        }else{
            System.out.println(dataArray[dataArrayIndex]);
        }
    }
















}
