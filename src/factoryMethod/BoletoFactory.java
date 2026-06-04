package factoryMethod;


public class BoletoFactory implements PagamentoFactory {

    @Override
    public Pagamento CriarPagamento() {

        return new Boleto();
    }

}
