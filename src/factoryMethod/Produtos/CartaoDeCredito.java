package factoryMethod.Produtos;

import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;

import singleton.Singleton;

public class CartaoDeCredito implements Pagar {

    Scanner sc = new Scanner(System.in);

    @Override
    public void pagar() {
        System.out.println("Pagamento via Cartao");
        System.out.println("Digite o valor:");
        double valor = sc.nextDouble();
        pagar(valor);
    }

    @Override
    public void pagar(double valor) {
        System.out.println("Processando pagamento de R$" + valor + " via Cartao");
        try {
            Connection conn = Singleton.getInstance().getConnection();
            if (conn != null) {
                try (PreparedStatement statement = conn.prepareStatement("INSERT INTO payments(types,price,datePayment) VALUES(?,?,?)")) {
                    statement.setString(1, "Cartao");
                    statement.setDouble(2, valor);
                    statement.setString(3, LocalDate.now().toString());
                    statement.executeUpdate();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
