# Trabalho de Padrões de Projeto - E-commerce

Este projeto implementa diversos padrões de projeto (Criacionais, Estruturais e Comportamentais) em um sistema de e-commerce simplificado, seguindo os requisitos das Atividades 03 e 04.

## Alunos
- Nickolas

## Padrões Implementados

### 1. Singleton (Criacional)
- **Classe:** `singleton.Singleton`
- **Justificativa:** Garante que haja apenas uma conexão com o banco de dados aberta durante a execução, economizando recursos e evitando conflitos de acesso aos dados. Resolve o problema de múltiplas conexões desnecessárias.

### 2. Factory Method (Criacional)
- **Classe:** `factoryMethod.Criadores.PagamentoFactory`
- **Justificativa:** Permite criar diferentes formas de pagamento sem que o cliente precise conhecer as classes concretas. Facilita a adição de novos métodos de pagamento (como Criptomoedas) apenas criando uma nova fábrica e produto, respeitando o desacoplamento.

### 3. Builder (Criacional)
- **Classe:** `builder.buildersPedidos.pedidoBuilder`
- **Justificativa:** Ideal para objetos complexos como um `Pedido`, que possui muitos atributos (itens, endereço, pagamento). Evita construtores com muitos parâmetros e permite validar o pedido (ex: mínimo de 1 item) antes de criá-lo.

### 4. Adapter (Estrutural)
- **Classe:** `adapter.GatewayAdapter`
- **Justificativa:** Permite que o sistema utilize um gateway de pagamento legado (com interface incompatível) sem alterar o código original do gateway ou do sistema, respeitando o princípio Open/Closed.

### 5. Decorator (Estrutural)
- **Classes:** `decorator.LogDecorator`, `decorator.DescontoDecorator`
- **Justificativa:** Adiciona funcionalidades como log e desconto de forma dinâmica e combinável. É superior à herança simples pois permite misturar comportamentos (ex: um pagamento com desconto E com log) sem criar inúmeras subclasses.

### 6. Facade (Estrutural)
- **Classe:** `facade.CheckoutFacade`
- **Justificativa:** Oferece uma interface simplificada para um processo complexo que envolve múltiplos serviços (Estoque, Pagamento, Carrinho, E-mail). Se um subsistema mudar, apenas a Facade precisa ser ajustada, protegendo o código cliente.

### 7. Strategy (Comportamental)
- **Interface:** `strategy.EstrategiaFrete`
- **Justificativa:** Permite trocar o algoritmo de cálculo de frete em tempo de execução. Facilita a conformidade com o princípio de Responsabilidade Única e permite adicionar novas transportadoras sem mexer na classe Carrinho/Pedido.

### 8. Observer (Comportamental)
- **Interface:** `observer.Observer`
- **Justificativa:** Desacopla o objeto `Pedido` das ações pós-confirmação. Quando o status muda, todos os interessados (E-mail, Estoque, Log) são notificados automaticamente sem que o Pedido precise conhecê-los diretamente.

### 9. Command (Comportamental)
- **Interface:** `command.Comando`
- **Justificativa:** Encapsula o cancelamento do pedido como um objeto. Isso permite não só executar a ação, mas também suportar o "desfazer" (undo), mantendo um histórico de comandos executados.