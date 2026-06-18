package observer;

import builder.order.Order;

public class EmailObserver implements Observer {
    @Override
    public void atualizar(Order pedido) {
        System.out.println("[EmailObserver] Enviando e-mail para o cliente sobre o pedido.");
    }
}
