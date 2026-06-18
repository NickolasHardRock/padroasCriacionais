package singleton;

import java.sql.*;

public class Singleton {

    private static Singleton uniqueInstance;

    private static final String URL = "jdbc:sqlite:C:base.db";

    private Connection connection;

    private Singleton() {
        try{
            connection = DriverManager.getConnection(URL);
        try (
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("Select 1")){

            
                
            // Criando a conexão com a base de dados
            statement.setQueryTimeout(30);

            // Comandos SQL para construir a base de dados
            statement.executeUpdate("DROP TABLE IF EXISTS produtc");
            statement.executeUpdate(
                    "CREATE TABLE produtcs (id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, name STRING NOT NULL, price DECIMAL NOT NULL, amount INTEGER NOT NULL)");
            statement.executeUpdate("INSERT INTO produtc (name,price,amount) VALUES('XBOX',2399.99,34)");
            statement.executeUpdate("INSERT INTO produtc (name,price,amount) VALUES('PLAYSTATION',2599.99,23)");
            
            statement.executeUpdate("CREATE TABLE IF EXISTS payments (id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, types TEXT NOT NULL, price DECIMAl NOT NULL, datePayment TEXT NOT NULL)");
            statement.executeUpdate("CREATE TABLE IF EXISTS Orders (id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, address TEXT NOT NULL, payment TEXT NOT NULL )");

            try{ 
            while (rs.next()) {
                System.out.println("Nome do produto: " + rs.getString("name"));
                System.out.println("Preço do produto: " + rs.getDouble("price"));
                System.out.println("Quantidade do produto: " + rs.getInt("amount"));
            }
        } finally{
            
        }
        }
    }catch (SQLException e) {
            System.err.println(e.getMessage());
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
