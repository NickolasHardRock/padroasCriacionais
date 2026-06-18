package builder.buildersPedidos;

import java.util.ArrayList;
import java.util.List;

import builder.components.EnderecoEntrega;
import builder.components.Item;
import builder.components.Pagamento;
import builder.order.Order;;

public class pedidoBuilder implements builderPedido{
    private List<Item> itens = new ArrayList<>();
    private EnderecoEntrega endereco;
    private Pagamento pagamento;
    
    @Override
    public pedidoBuilder setItens(List<Item> itens) {
        this.itens = itens;
        return this;
    }

    public pedidoBuilder adicionarItem(Item item){
        this.itens.add(item);
        return this;
    }

    @Override
    public pedidoBuilder setEndereçoDeEntrega(EnderecoEntrega Endereco) {
        this.endereco = Endereco;
        return this;
    }
    @Override
    public pedidoBuilder setFormaDePagamento(Pagamento pagar) {
        this.pagamento = pagar;
        return this;
    }

    public Order build(){
        if(itens.isEmpty()){
            System.out.println("O pedido deve conter pelo menos um item");
        }
        return new Order(itens,endereco,pagamento);
    }










    
}
