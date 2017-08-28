package multiplicador;

/**
 *
 * @author Santiago
 */
public class SumadorCompleto {
    private Boolean a, b;       // Entradas del Sumador Completo
    private Boolean s;          // Resultado del Sumador Completo
    private Boolean cIn;        // Carro de entrada del Sumador Completo
    private Boolean cOut;       // Carro de salida del Sumador Completo
    
    
    /**
     * Constructor de la clase Sumador completo
     * @param a Sumando a
     * @param b Sumando b
     * @param cIn Carro de entrada
     */
    public SumadorCompleto(Boolean a, Boolean b, Boolean cIn){
        this.a = a;
        this.b = b;
        this.cIn = cIn;
        
        add(a,b, cIn);
        carry(a,b,cIn); 
    }

    /**
     * Realiza la suma binaria, obtenuiendo el valor de S
     * @param a Sumando a
     * @param b Sumando b
     * @param cIn Carro de entrada
     */
    private void add(Boolean a, Boolean b, Boolean cIn) {
        s = xor(xor(a,b), cIn); // a xor b xor cIn
    }

    /**
     * Realiza la suma binaria obteniendo el valor de cOut
     * @param a Sumando a
     * @param b Sumando b
     * @param cIn Carro de entrada
     */
    private void carry(Boolean a, Boolean b, Boolean cIn) {
        cOut = (a && b) || cIn && (xor(a,b)); // (a * b) + cIn * (a xor b)
    }

    /**
     * Getter del miembro S
     * @return Regresa el resultado de la suma
     */
    public Boolean getS() {
        return s;
    }

    /**
     * Getter del miembro cOut
     * @return Regreesa el carro de salida (reserva)
     */
    public Boolean getcOut() {
        return cOut;
    }
    
    private Boolean xor(Boolean a, Boolean b){
        return ((!a || !b) && (a || b));
    }
}
