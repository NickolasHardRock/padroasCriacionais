package factoryMethod.Criadores;

import factoryMethod.Produtos.Pagar;
import factoryMethod.Produtos.Pix;

public class PagamentoPix extends PagamentoFactory {

    @Override
    public Pagar CriarPagamento() {
        return new Pix();
    }
    
}
