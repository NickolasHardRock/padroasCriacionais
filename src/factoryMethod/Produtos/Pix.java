package factoryMethod.Produtos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

import singleton.Singleton;

public class Pix implements Pagar {

    Scanner sc = new Scanner(System.in);

    @Override
    public void pagar(){

        System.out.println("Pagamento via Pix");
        System.out.println("Digite o valor:");
        Double valor = sc.nextDouble();

        try{
            Connection conn = Singleton.getInstance().getConnection();
            PreparedStatement statement = conn.prepareStatement("INSERT INTO payments (types,price,datePayment) VALUE (?,?,?)");
            statement.setString(1, "PIX");
            statement.setDouble(2, valor);
            statement.setString(3, LocalDate.now().toString());
            statement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }

    }
}
