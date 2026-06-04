package factoryMethod;

public class CartaoDeCreditoFactory implements PagamentoFactory{
    
    @Override
    public Pagamento CriarPagamento(){
        return new CartaoDeCredito();
    }
}
