package decorator;

import factoryMethod.Produtos.Pagar;

public class LogDecorator extends pagamentoDecorado{
    public LogDecorator(Pagar pagamentoDecorado){
        super(pagamentoDecorado);
    }

    @Override
    public void pagar(double valor){
        System.out.println("[LOG] valor cobrado: R$" + valor);
        super.pagar(valor);
    }


}
