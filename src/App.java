import factoryMethod.Produtos.*;
import factoryMethod.Criadores.*;
// import singleton.Singleton;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    
        // Singleton db = Singleton.getInstance();

        // System.out.println(db);

        PagamentoFactory pagar1 = new PagamentoBoleto();
        Pagar p1 = pagar1.CriarPagamento();
        p1.pagar();
        
        PagamentoFactory pagar2 = new PagamentoCartao();
        pagar2.CriarPagamento();


    }
}
