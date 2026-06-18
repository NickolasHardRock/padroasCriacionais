package builder.components;

public class Pagamento {

    private String forma;

    public Pagamento(String forma){
        this.forma = forma;
    }

        public String getForma() {
        return forma;
    }
    
    public void setForma(String forma) {
        this.forma = forma;
    }

    @Override
    public String toString(){
        return forma;
    }

}
