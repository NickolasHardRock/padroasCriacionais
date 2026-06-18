package observer;

import builder.order.Order;

public interface Observer {
    void atualizar(Order pedido);
}
