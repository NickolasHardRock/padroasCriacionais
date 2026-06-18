package facade;

import facade.stubs.EstoqueService;
import facade.stubs.PagamentoService;
import facade.stubs.CarrinhoSercive;
import facade.stubs.EmailService;
import builder.order.Order;

public class CheckoutFacade {
    private EstoqueService estoque;
    private PagamentoService pagamento;
    private CarrinhoSercive carrinho;
    private EmailService email;

    public CheckoutFacade() {
        this.estoque = new EstoqueService();
        this.pagamento = new PagamentoService();
        this.carrinho = new CarrinhoSercive();
        this.email = new EmailService();
    }

    public void finalizar(Order pedido) {
        System.out.println("### Iniciando Checkout via Facade ###");
        estoque.baixarEstoque();
        pagamento.processarPagamento();
        carrinho.limparCarrinho();
        email.enviarEmailConfirmacao();
        System.out.println("### Pedido finalizado com sucesso! ###");
    }
}
