import factoryMethod.Produtos.*;
import factoryMethod.Criadores.*;
import builder.*;
import builder.builders.CarBuilder;
import builder.builders.CarManualBuilder;
import builder.cars.Car;
import builder.cars.CarType;
import builder.cars.Manual;
import builder.components.Engine;
import builder.components.GPSNavigator;
import builder.components.Transmission;
import builder.components.TripComputer;
// import singleton.Singleton;
import builder.director.Director;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    
        // Singleton db = Singleton.getInstance();

        // System.out.println(db);

        // PagamentoFactory pagar1 = new PagamentoBoleto();
        // Pagar p1 = pagar1.CriarPagamento();
        // p1.pagar();
        
        // PagamentoFactory pagar2 = new PagamentoCartao();
        // pagar2.CriarPagamento();

        Director director = new Director();

        CarBuilder builder = new CarBuilder();
        director.constructSportCar(builder);

        Car car = builder.getResult();
        System.out.println("Car built:\n" + car.getCarType());

        CarManualBuilder manualBuilder = new CarManualBuilder();

        director.constructSportCar(manualBuilder);
        Manual carManual = manualBuilder.getResult();
        System.out.println("\nCar manual built:\n" + carManual.print());

        Car rondaCIVCar = new Car(CarType.CITY_CAR, 02, new Engine(3.9, 666),Transmission.MANUAL,new TripComputer(),new GPSNavigator());

        System.out.println("\nOlha o ronda manual:\n" + rondaCIVCar.getResult());

    }
}
