package decorator;

import factoryMethod.Produtos.Pagar;

public abstract class PagamentoDecorator implements Pagar{

    protected Pagar pagamentoDecorado;

    public PagamentoDecorator(Pagar pagamentoDecorado){
        this.pagamentoDecorado = pagamentoDecorado;
    }

    @Override
    public void pagar(double valor){
        pagamentoDecorado.pagar(valor);
    }





}
