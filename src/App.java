import factoryMethod.Produtos.Pagar;
import factoryMethod.Produtos.Boleto;
import factoryMethod.Produtos.Pix;
import factoryMethod.Produtos.CartaoDeCredito;

import factoryMethod.Criadores.PagamentoFactory;
import factoryMethod.Criadores.PagamentoBoleto;
import factoryMethod.Criadores.PagamentoCartao;
import factoryMethod.Criadores.PagamentoPix;


import java.util.Scanner;

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

@SuppressWarnings("unused")
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        boolean chave = true;


        do {
           System.out.println("Escolha o metodo de pagamento ou digite 0 para sair");
           System.out.println("1-Boleto");
           System.out.println("2-Cartão");
           System.out.println("3-Pix");
           System.out.println("0-Sair");

            Scanner sc = new Scanner(System.in);
            int arg = sc.nextInt();
           switch (arg) {
            case 1:
                PagamentoFactory pagar1 = new PagamentoBoleto();
                Pagar p1 = pagar1.CriarPagamento();
                p1.pagar();
                break;
           case 2:
                PagamentoFactory paga2 = new PagamentoCartao();
                Pagar p2 = paga2.CriarPagamento();
                p2.pagar();
                break;
            case 3:
                PagamentoFactory paga3 = new PagamentoPix();
                Pagar p3 = paga3.CriarPagamento();
                p3.pagar();
                break;
            case 0:
                chave = false;
                sc.close();
                break;
           } 
           
        } while (chave);

        // Singleton db = Singleton.getInstance();

        // System.out.println(db);

        // PagamentoFactory pagar1 = new PagamentoBoleto();
        // Pagar p1 = pagar1.CriarPagamento();
        // p1.pagar();
        
        // PagamentoFactory pagar2 = new PagamentoCartao();
        // pagar2.CriarPagamento();

        // Director director = new Director();

        // CarBuilder builder = new CarBuilder();
        // director.constructSportCar(builder);

        // Car car = builder.getResult();
        // System.out.println("Car built:\n" + car.getCarType());

        // CarManualBuilder manualBuilder = new CarManualBuilder();

        // director.constructSportCar(manualBuilder);
        // Manual carManual = manualBuilder.getResult();
        // System.out.println("\nCar manual built:\n" + carManual.print());

        // Car rondaCIVCar = new Car(CarType.CITY_CAR, 02, new Engine(3.9, 666),Transmission.MANUAL,new TripComputer(),new GPSNavigator());

        // System.out.println("\nOlha o ronda manual:\n" + rondaCIVCar.getResult());

    }
}
