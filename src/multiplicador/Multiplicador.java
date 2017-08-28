package multiplicador;

/**
 *
 * @author Santiago
 */
public class Multiplicador {
    private bitArray a = new bitArray();
    private bitArray b = new bitArray();
    private bitArray ac;
    private Boolean carry;

    
    /**
     * Constructor de Multiplicador, crea un nuevo multiplicador con factores a y b
     * @param a factor de la multiplicacion
     * @param b factor de la multiplicacion
     */
    public Multiplicador(bitArray a, bitArray b) {
        /* Factores */
        this.a = a;
        this.b = b;
        
        /* Registro acumulador (inicializado en 0), con un tamaño maximo de a+b bits */
        ac = new bitArray(a.getSize()+b.getSize());    
        
        /* Carro del sumador inicializado en 0 */
        carry = Boolean.FALSE;
    }  

    /**
     * Contructor de la clase, crea un Multiplicador vacio
     */
    public Multiplicador() {
        
    }
    
    
    /**
     * Metodo que realiza la multiplicacion binaria entre 2 BitArray (a,b) y el
     * resultado es guardado en el registro ac
     */
    public void multiplicar(){
        int k;
        
        /* Se recorre el BitArray a, desde su cifra menos significativa */
        for (int i = 0; i < a.getSize(); i++) {
            Boolean d = a.getBit(i);                                // Se toma el digito a[i]
            bitArray temp = new bitArray();                         // Se crea un BitArray temporal           
            
            /* Se recorre el BitArray b, desde su cifra menos significativa */
            for (int j = 0; j < b.getSize(); j++) {
                temp.addBit(a.getBit(i) && b.getBit(j));            // Se realiza la multiplicacion binaria (temp[j] = b[j] * d)            
            }
            temp.lShift(i);                                         // Se realiza el corrimiento de i bits de temp            
                        
            /* Una vez realizada la mutiplicacion. se acumula temp al registro AC */
            for (k = 0; k < temp.getSize(); k++) {
                SumadorCompleto sumador = new SumadorCompleto(temp.getBit(k), ac.getBit(k), carry);
                carry = sumador.getcOut();
                ac.setBit(sumador.getS(), k);
            }
            
            /* En caso que el carro quede con valores se agrega este a la cifra mas significativa del acumulador */
            if(carry){
                ac.setBit(carry, k);
                carry = Boolean.FALSE;
            }
        }      
    }

    /**
     * Imprime el resultado de la multiplicacion por la salida estandar
     */
    public void print(){
        System.out.println("Resultado: " + a.toString()+ " x " + b.toString() + " = " + ac.toString());
        System.out.println("Decimal: " + a.toDecimal() + " x " + b.toDecimal() + " = " + ac.toDecimal());
    } 

    /**
     * Resetea el multiplicador con los nuevos factores a y b
     * @param a factor a
     * @param b factor b
     */
    public void reset(bitArray a, bitArray b) {
        this.a = a;
        this.b = b;
        
        carry = Boolean.FALSE;
        ac = new bitArray(a.getSize()+b.getSize()); 
    }    
}
