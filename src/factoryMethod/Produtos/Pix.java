package factoryMethod.Produtos;

// import singleton.Singleton;

public class Pix implements Pagar {
    @Override
    public void pagar(){
        // Singleton db = Singleton.getInstance(); 
        System.out.println("Pagamento via pix");


    }
}
