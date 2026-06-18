package decorator;

import factoryMethod.Produtos.Pagar;

public class DescontoDecorator extends PagamentoDecorator{
    private double percentual;

    public DescontoDecorator(Pagar pagamentoDecorado, double percentual){
        super(pagamentoDecorado);
        this.percentual = percentual;
    }

    @Override
    public void pagar(double valor){
        double valorComDesconto = valor - (valor * percentual / 100);
        System.out.println("[Desconto] Aplicado " + percentual + "% -> Novo valor:");
        super.pagar(valorComDesconto);
    }

}
