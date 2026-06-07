package factoryMethod.Produtos;

public class CartaoDeCredito implements Pagar {
    @Override
    public void pagar() {
    System.out.println("Pagamento via Cartao");    
    }
}
