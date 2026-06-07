package factoryMethod.Criadores;
import factoryMethod.Produtos.Pagar;
import factoryMethod.Produtos.CartaoDeCredito;

public class PagamentoCartao extends PagamentoFactory{
    
    @Override
    public Pagar CriarPagamento(){
        Pagar pagamento = new CartaoDeCredito();
        pagamento.pagar();
        return pagamento;
    }
}
