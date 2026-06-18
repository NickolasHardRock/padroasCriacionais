package strategy;

public class FreteCorreios implements EstrategiaFrete {
    @Override
    public double calcular(double peso) {
        return peso * 10.0;
    }
}
