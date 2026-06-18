package adapter;

import factoryMethod.Produtos.Pagar;
import adapter.legado.GatewayLegado;

public class GatewayAdapter implements Pagar {

    private GatewayLegado gateway;
    private String dados;

    public GatewayAdapter(String dados){
        this.gateway = new GatewayLegado();
        this.dados = dados;
    }

    @Override
    public void pagar(){
        gateway.processarTransacao(dados);
    }

    @Override
    public void pagar(double valor){
        System.out.println("Adaptando pagamento de R$" + valor);
        gateway.processarTransacao(dados);
    }

}
