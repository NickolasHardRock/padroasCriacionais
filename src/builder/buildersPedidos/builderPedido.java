package builder.buildersPedidos;
import java.util.List;

import builder.components.EnderecoEntrega;
import builder.components.Item;
import builder.components.Pagamento;
import builder.order.Order;




public interface builderPedido {
    pedidoBuilder setItens(List<Item> itens);
    pedidoBuilder setEndereçoDeEntrega(EnderecoEntrega Endereco);
    pedidoBuilder setFormaDePagamento(Pagamento pagar);
    Order build();
}
