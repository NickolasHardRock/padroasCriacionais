package factoryMethod.Produtos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

import singleton.Singleton;

public class Boleto implements Pagar{

 Scanner sc = new Scanner(System.in);

@Override
public void pagar(double valor){
    System.out.println("Pagamento via boleto");
    
    System.out.println("Digite o valor:");
    valor = sc.nextDouble();
    System.out.println("Chegou aqui 1");
    try{
        Connection conn = Singleton.getInstance().getConnection();
        System.out.println("Chegou aqui 2");
        try(PreparedStatement statement = conn.prepareStatement("INSERT INTO payments (types,price,datePayment) VALUES (?,?,?)");
        ){
            System.out.println("Chegou aqui 3");
        statement.setString(1, "Boleto");
        statement.setDouble(2, valor);
        statement.setString(3, LocalDate.now().toString());
        statement.executeUpdate();
        }
        
    }catch(SQLException e){
        e.printStackTrace();
    }

}

}