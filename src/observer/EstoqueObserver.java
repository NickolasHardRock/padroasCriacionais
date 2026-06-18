package observer;

import builder.order.Order;

public class EstoqueObserver implements Observer {
    @Override
    public void atualizar(Order pedido) {
        System.out.println("[EstoqueObserver] Baixando itens do estoque.");
    }
}
