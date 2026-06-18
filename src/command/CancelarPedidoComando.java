package command;

import builder.order.Order;

public class CancelarPedidoComando implements Comando {
    private Order pedido;

    public CancelarPedidoComando(Order pedido) {
        this.pedido = pedido;
    }

    @Override
    public void executar() {
        System.out.println("Cancelando o pedido...");
    }

    @Override
    public void desfazer() {
        System.out.println("Desfazendo cancelamento do pedido...");
    }
}
