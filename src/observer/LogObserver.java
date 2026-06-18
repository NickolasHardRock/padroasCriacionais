package observer;

import builder.order.Order;

public class LogObserver implements Observer {
    @Override
    public void atualizar(Order pedido) {
        System.out.println("[LogObserver] Registrando log do pedido confirmado.");
    }
}
