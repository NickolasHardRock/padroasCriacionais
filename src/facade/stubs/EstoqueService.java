package facade.stubs;

public class EstoqueService {

    public boolean verificarDisponibilidade(Pedido pedido){
        System.out.println( "Verificando estoque...");
        return true;
    }

}
