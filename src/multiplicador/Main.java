package multiplicador;

public class Main {
    public static void main(String[] args) {               
        bitArray a = new bitArray();
        bitArray b = new bitArray();
        
        a.readBinary();
        b.readBinary();
        
        /* Se crea un multiplicador */
        Multiplicador m = new Multiplicador(a, b);
        
        /* Se multiplican los BitArray leidos por el multiplicador */
        m.multiplicar();
        
        /* Se imprime el resultado entre a y b */
        m.print();
    }
}
