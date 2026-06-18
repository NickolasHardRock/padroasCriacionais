package factoryMethod.Criadores;
import factoryMethod.Produtos.Pagar;
import factoryMethod.Produtos.CartaoDeCredito;

public class PagamentoCartao extends PagamentoFactory{
    
    @Override
    public Pagar CriarPagamento(){
        return new CartaoDeCredito();
    }
}
