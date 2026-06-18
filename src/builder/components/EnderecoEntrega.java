package builder.components;

public class EnderecoEntrega {
    private String endereco;

    public EnderecoEntrega(String endereco){
        this.endereco = endereco;
    }
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString(){
        return "{endereço="+endereco+
                "}";
    }

}
