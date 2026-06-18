package strategy;

public class FreteJadlog implements EstrategiaFrete {
    @Override
    public double calcular(double peso) {
        return peso * 15.0;
    }
}
