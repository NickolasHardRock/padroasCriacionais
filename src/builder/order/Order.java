package builder.order;

import java.util.ArrayList;
import java.util.List;

import builder.components.EnderecoEntrega;
import builder.components.Item;
import builder.components.Pagamento;
import observer.Observer;

public class Order {
    private List<Item> itens;
    private EnderecoEntrega enderecoEntrega;
    private Pagamento pagamento;
    private List<Observer> observers = new ArrayList<>();

    public Order(List<Item> itens, EnderecoEntrega enderecoEntrega, Pagamento pagamento){
        this.itens = itens;
        this.enderecoEntrega = enderecoEntrega;
        this.pagamento = pagamento;
    }

    public void adicionarObserver(Observer observer) {
        observers.add(observer);
    }

    public void confirmarPedido() {
        System.out.println("Pedido confirmado!");
        notificarObservers();
    }

    private void notificarObservers() {
        for (Observer observer : observers) {
            observer.atualizar(this);
        }
    }

    @Override
    public String toString(){
        return "Pedido{"+
                "itens="+ itens +
                ", enderecoEntrega=" + enderecoEntrega +
                ", pagamento="+ pagamento +
                '}';
    }

}
