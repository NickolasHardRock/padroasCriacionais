package factoryMethod.Criadores;

import factoryMethod.Produtos.Pagar;

public abstract class PagamentoFactory {
    
    public abstract Pagar CriarPagamento();

    public void escolherPagamento(){
        Pagar pagarObjeto = CriarPagamento();
        pagarObjeto.pagar();
    }
}