package builder.components;

public class Item {

    private String nome;
    private Double valor;
    private Integer quantidade;

    public Item(String nome, Double valor, Integer quantidade){
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
    }
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "{Nome="+nome+
                "Quantidade ="+quantidade+
                "Valor="+valor+
                "}";
    }

}
