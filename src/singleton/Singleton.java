package singleton;

import java.sql.*;

public class Singleton {

    private static Singleton uniqueInstance;
    private Connection connection;

    private static final String URL = "jdbc:sqlite:C:base.db";

    private Statement statement = null;
    private ResultSet rs = null;

    private Singleton() {

        try {
            // Criando a conexão com a base de dados
            connection = DriverManager.getConnection(URL);
            statement = connection.createStatement();
            statement.setQueryTimeout(30);

            // Comandos SQL para construir a base de dados
            statement.executeUpdate("DROP TABLE IF EXISTS produtc");
            statement.executeUpdate(
                    "CREATE TABLE produtc (id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, name STRING NOT NULL, price DECIMAL NOT NULL, amount INTEGER NOT NULL)");
            statement.executeUpdate("INSERT INTO produtc (name,price,amount) VALUES('XBOX',2399.99,34)");
            statement.executeUpdate("INSERT INTO produtc (name,price,amount) VALUES('PLAYSTATION',2599.99,23)");
            rs = statement.executeQuery("SELECT * FROM produtc");
            statement.executeUpdate("DROP TABLE IF EXISTS payments");
            statement.executeUpdate(
                    "CREATE TABLE payments (id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, types TEXT NOT NULL CHECK('Boleto','Cartao','Pix'), price DECIMAl NOT NULL, datePayment TEXT NOT NULL");

            while (rs.next()) {
                System.out.println("Nome do produto: " + rs.getString("name"));
                System.out.println("Preço do produto: " + rs.getDouble("price"));
                System.out.println("Quantidade do produto: " + rs.getInt("amount"));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null)
                    connection.close();
                if (statement != null)
                    statement.close();
                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
    }
    // synchronized →
    // Garante que apenas uma thread por vez execute esse método.
    // Isso evita que múltiplas instâncias sejam criadas em
    // programas que usam concorrência.

    public static synchronized Singleton getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }

    public Connection getConnection() {
        return connection;
    }

}
