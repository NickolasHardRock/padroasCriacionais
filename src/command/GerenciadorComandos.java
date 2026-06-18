package command;

import java.util.Stack;

public class GerenciadorComandos {
    private Stack<Comando> historico = new Stack<>();

    public void executarComando(Comando comando) {
        comando.executar();
        historico.push(comando);
    }

    public void desfazerUltimo() {
        if (!historico.isEmpty()) {
            Comando comando = historico.pop();
            comando.desfazer();
        } else {
            System.out.println("Nada para desfazer.");
        }
    }
}
