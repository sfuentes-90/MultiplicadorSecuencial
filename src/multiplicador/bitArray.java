package multiplicador;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Santiago
 */
public class bitArray {
    /* ***************************** */
    /* Miembros de la clase bitArray */
    /* ***************************** */
    private ArrayList<Boolean> binaryNumber;
    private int t;

    /* ********************************** */
    /* Constructores de la clase bitArray */
    /* ********************************** */
    public bitArray() {
        binaryNumber = new ArrayList();
        t = 0;
    }
    
    public bitArray(int n) {
        binaryNumber = new ArrayList();
        for (int i = 0; i < n; i++) {
            binaryNumber.add(Boolean.FALSE);
        }
        this.t = n;
    }
    
    /* **************************** */
    /* Metodos de la clase bitArray */
    /* **************************** */

    /**
     * Metodo que permite la lectura de un numero binario de n bits desde la 
     * entrada estandar, y lo guarda en el BitArray
     */   
    public void readBinary() {
        String line;
        Boolean d;
        Scanner sc = new Scanner(System.in);
        
        /* Se lee la linea de la entrada estandar que contiene el numero en binario */
        line = sc.nextLine();
        
        /* Se recorre el string para formar el arreglo binario */
        for (int i = line.length() - 1; i >= 0; i--) {
            /* Se compara cada posicion del String para obtener el valor TRUE o FALSE */
            if(line.charAt(i) == '0')
                d = Boolean.FALSE;
            else
                d = Boolean.TRUE;
            
            /* Se agrega un nodo al BitArray con el digito */
            binaryNumber.add(d);
            t++;
        }
    }
    
    /**
     * REVISAR ESTE METODO!
     * Metodo que agrega un bit al BitArray, el bit es agregado 
     * @param bit bit que se agregara al BitArray
     */
    
    public void addBit(Boolean bit){
        binaryNumber.add(bit);
        t++;
    }
    
    /**
     * Regresa el bit en la posicion n del BitArray
     * @param index indice del BitArray del cual se obtendra el bit
     * @return valor del BitArray en la posicion apuntada por index
     */
    public Boolean getBit(int index){
        return binaryNumber.get(index);
    }
    
    /**
     * Cambia el valor de un bit dentro del BitArray en la posicion apuntada por index por un nuevo valor
     * @param bit nuevo valor del bit en el BitArray
     * @param index indice del bit que se cambiara
     */
    public void setBit(Boolean bit, int index){
        binaryNumber.set(index, bit);
    }
    
    /**
     * Imprime en numero binario representado por el BitArray
     */
    public void printBinary(){
        for (int i = binaryNumber.size()-1; i >= 0; i--) {
            Boolean digito = binaryNumber.get(i);
            
            if(digito)
                System.out.print('1');
            else
                System.out.print("0");
        }
        System.out.println("");
    }
    
    /**
     * Realiza un corrimiento de n bits a la derecha
     * @param nShift numero de bits de corrimiento
     */
    public void rShift(int nShift){
        for (int i = 0; i < nShift; i++) {
            binaryNumber.remove(0);
            t--;
        }
    }
    
    /**
     * Realiza un corrimeinto de n bits a la izquierda
     * @param nShift numero de bits de corrimiento
     */
    public void lShift(int nShift){
        for (int i = 0; i < nShift; i++) {
            binaryNumber.add(0, Boolean.FALSE);
            t++;
        }
    } 
    
    /**
     * Entrega el tamano del BitArray
     * @return tamaño del BitArray en bits
     */
    public int getSize(){
        return t;
    }
    
    /**
     * Convierte el BitArray a un String con los datos binarios
     * @return String con la forma binaria del BitArray
     */
    @Override
    public String toString(){
        String n = "";
        
        //Se crea la cadena a partir de la cifra menos 
        for (int i = binaryNumber.size() - 1; i >= 0; i--) {
            if(binaryNumber.get(i))
                n += "1";
            else
                n += "0";
        }
        
        /* Se eliminan los 0 a la izquierda de la cifra mas significativa */
        n = n.replaceFirst ("^0*", "");
        
        return n;
    }
    
    /**
     * Convierte el BitArray a un numero entero decimal
     * @return forma decimal entera del BitArray
     */
    public int toDecimal(){
        int dec = 0;
        
        for (int i = 0; i < t; i++) {
            if(binaryNumber.get(i)){
                dec += (int) 1*(Math.pow(2, i));
            }
        }
        
        return dec;
    }
}
