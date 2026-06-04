package factoryMethod;

public class PixFactory implements PagamentoFactory {

    @Override
    public Pagamento CriarPagamento() {
        // TODO Auto-generated method stub
        return new Pix();
    }

}
