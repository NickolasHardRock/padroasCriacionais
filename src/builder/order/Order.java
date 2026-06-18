package builder.order;

import java.util.List;

import builder.components.EnderecoEntrega;
import builder.components.Item;
import builder.components.Pagamento;

public class Order {
    private List<Item> itens;
    private EnderecoEntrega enderecoEntrega;
    private Pagamento pagamento;

    public Order(List<Item> itens, EnderecoEntrega enderecoEntrega, Pagamento pagamento){
        this.itens = itens;
        this.enderecoEntrega = enderecoEntrega;
        this.pagamento = pagamento;
    }

    @Override
    public String toString(){
        return "Pedido{"+
                "itens="+ itens +
                ", enderecoEntrega" + enderecoEntrega +
                ", pagamento="+ pagamento +
                '}';
    }

}
