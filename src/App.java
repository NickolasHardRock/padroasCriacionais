import factoryMethod.Produtos.Pagar;
import factoryMethod.Criadores.PagamentoFactory;
import factoryMethod.Criadores.PagamentoCartao;
import factoryMethod.Criadores.PagamentoPix;
import factoryMethod.Criadores.PagamentoBoleto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import builder.buildersPedidos.pedidoBuilder;
import builder.components.EnderecoEntrega;
import builder.components.Item;
import builder.components.Pagamento;
import builder.order.Order;

import singleton.Singleton;
import adapter.GatewayAdapter;
import decorator.LogDecorator;
import decorator.DescontoDecorator;
import facade.CheckoutFacade;
import strategy.*;
import observer.*;
import command.*;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("### SISTEMA DE E-COMMERCE INTEGRADO ###\n");

        // 1. SINGLETON - Inicializando conexão com o banco
        System.out.println("[Sistema] Inicializando Banco de Dados...");
        Singleton db = Singleton.getInstance();
        System.out.println();

        // 2. BUILDER - Montando o Carrinho/Pedido
        System.out.println("[Sistema] Montando seu pedido...");
        List<Item> itens = new ArrayList<>();
        itens.add(new Item("Notebook Gamer", 4500.0, 1));
        itens.add(new Item("Mouse Wireless", 150.0, 1));

        Order meuPedido = new pedidoBuilder()
            .setItens(itens)
            .setEndereçoDeEntrega(new EnderecoEntrega("Av. Paulista, 1000, SP"))
            .setFormaDePagamento(new Pagamento("Cartão de Crédito"))
            .build();
        
        System.out.println("Pedido criado: " + meuPedido);
        System.out.println();

        // 3. STRATEGY - Calculando o Frete
        System.out.println("[Sistema] Escolha o frete: 1-Correios, 2-Jadlog, 3-Retirada");
        int opcaoFrete = sc.nextInt();
        EstrategiaFrete freteEscolhido;
        switch (opcaoFrete) {
            case 1: freteEscolhido = new FreteCorreios(); break;
            case 2: freteEscolhido = new FreteJadlog(); break;
            default: freteEscolhido = new FreteRetirada(); break;
        }
        double valorFrete = freteEscolhido.calcular(5.0); // Peso fixo para exemplo
        System.out.println("Valor do frete calculado: R$" + valorFrete);
        System.out.println();

        // 4. FACTORY METHOD + DECORATOR + ADAPTER - Processando Pagamento
        System.out.println("[Sistema] Escolha a forma de pagamento: 1-Cartão, 2-Pix, 3-Boleto, 4-Gateway Legado (Adapter)");
        int opcaoPagto = sc.nextInt();
        Pagar pagamentoBase;
        
        switch (opcaoPagto) {
            case 1: pagamentoBase = new PagamentoCartao().CriarPagamento(); break;
            case 2: pagamentoBase = new PagamentoPix().CriarPagamento(); break;
            case 3: pagamentoBase = new PagamentoBoleto().CriarPagamento(); break;
            case 4: pagamentoBase = new GatewayAdapter("TOKEN_LEGADO_123"); break;
            default: pagamentoBase = new PagamentoPix().CriarPagamento(); break;
        }

        // Aplicando DECORATORS (Log e Desconto de 5% se for Pix/Boleto)
        Pagar pagamentoFinal = new LogDecorator(pagamentoBase);
        if (opcaoPagto == 2 || opcaoPagto == 3) {
            pagamentoFinal = new DescontoDecorator(pagamentoFinal, 5.0);
        }
        
        double valorTotal = 4650.0 + valorFrete;
        System.out.println("Processando pagamento total de R$" + valorTotal);
        pagamentoFinal.pagar(valorTotal);
        System.out.println();

        // 5. OBSERVER - Configurando notificações
        meuPedido.adicionarObserver(new EmailObserver());
        meuPedido.adicionarObserver(new EstoqueObserver());
        meuPedido.adicionarObserver(new LogObserver());

        // 6. FACADE - Finalizando o Checkout (Orquestração)
        CheckoutFacade checkout = new CheckoutFacade();
        checkout.finalizar(meuPedido);

        // Disparando notificações via Observer (dentro do fluxo de confirmação)
        meuPedido.confirmarPedido();
        System.out.println();

        // 7. COMMAND - Opção de Cancelamento (Undo)
        System.out.println("[Sistema] Deseja cancelar o pedido? (1-Sim, 0-Não)");
        int cancelarOpcao = sc.nextInt();
        if (cancelarOpcao == 1) {
            GerenciadorComandos gerenciador = new GerenciadorComandos();
            Comando comandoCancelar = new CancelarPedidoComando(meuPedido);
            
            gerenciador.executarComando(comandoCancelar);
            
            System.out.println("\n[Sistema] Ops! Deseja desfazer o cancelamento? (1-Sim, 0-Não)");
            int desfazerOpcao = sc.nextInt();
            if (desfazerOpcao == 1) {
                gerenciador.desfazerUltimo();
            }
        }

        System.out.println("\n### FLUXO FINALIZADO ###");
        sc.close();
    }
}
