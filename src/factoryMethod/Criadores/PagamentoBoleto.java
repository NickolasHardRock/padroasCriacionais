package factoryMethod.Criadores;

import factoryMethod.Produtos.Pagar;
import factoryMethod.Produtos.Boleto;


public class PagamentoBoleto extends PagamentoFactory{

    @Override
    public Pagar CriarPagamento(){
        return new Boleto();
    }

}
