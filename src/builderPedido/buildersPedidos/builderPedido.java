package builderPedido.buildersPedidos;

public interface builderPedido {
    void setItens(Item itens);
    void setEndereçoDeEntrega(EnderecoEntrega Endereco);
    void setFormaDePagamento(PagamentoFactory pagar);

}
