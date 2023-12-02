package Work3.Number;

import java.util.ArrayList;

import Work3.DuplicateModelNameException;
import Work3.NoSuchModelNameException;
import Work3.Car.Car;
import Work3.Motoricle.Motoricle;
import Work3.VehicleUtils.VehicleUtils;
import Work3.Vehicle.Vehicle;

public class Number {
    public static void main(String[] args) throws DuplicateModelNameException, NoSuchModelNameException{
        
        Vehicle c = new Car("Pezho", 5);

        System.out.println("\nMarka: "+c.getMake());

        c.setModelName(2, "Fiesta");
        c.setModelPrice("Fiesta",1000);
        c.setModelName(1, "Solyaris");
        c.setModelPrice("Solyaris",1000);
        c.setModelName(3, "Supra");
        c.setModelPrice("Supra",500);
        c.setModelName(0, "Skuline");
        c.setModelPrice("Skuline",4000);
        c.setModelName(4, "Astra");
        c.setModelPrice("Astra",100);

        System.out.println("\nЦена Skuline : "+c.getModelPrice("Skuline")+"\n");

        VehicleUtils.printAllModelPrices(c);

        c.addModel("m5",700);

        c.removeModel("aris");

        c.ModifName("Furia", "Astra");

        VehicleUtils.printAllModelPrices(c);

        Motoricle m = new Motoricle("BMW", 6);

        System.out.println("Marka: "+m.getMake());

        System.out.println(m.getMod());

        m.setModelName(2, "Granta");
        m.setModelPrice("Granta",1000);
        m.setModelName(1, "Kalina");
        m.setModelPrice("Kalina",3000);
        m.setModelName(3, "Vesta");
        m.setModelPrice("Vesta",500);
        System.out.println(m.getMod());
        m.setModelName(0, "Honda");
        m.setModelPrice("Honda",4000);
        m.setModelName(4, "Dio");
        m.setModelPrice("Dio",100);
        m.setModelName(5, "Dior");
        m.setModelPrice("Dior",100);

        System.out.println("\nЦена Dio : "+m.getModelPrice("Dio"));

        String[] temp = m.getModelNames();

        System.out.println("\nSpisok modeley: ");
        for(int i = 0; i< temp.length;i++){
            System.out.println(temp[i]);
        }

        double[] sekondtemp = m.getModelPrices();
        
        System.out.println("\nSpisok cen: ");
        for(int i = 0; i< sekondtemp.length;i++){
            System.out.println(sekondtemp[i]);
        }

        m.ModifName("Furia", "Dior");
        
        m.addModel("x5",700);

        m.removeModel("Vesta");

        temp = m.getModelNames();

        System.out.println(m.getMod());

        System.out.println("\nSpisok modeley: ");
        for(int i = 0; i< temp.length;i++){
            System.out.println(temp[i]);
        }

        sekondtemp = m.getModelPrices();

        System.out.println("\nSpisok cen: ");
        for(int i = 0; i< sekondtemp.length;i++){
            System.out.println(sekondtemp[i]);
        }
        
        System.out.println("Сред стоимость машин моделей: " + VehicleUtils.getAverageModelPrice(c));
        System.out.println("Сред стоимость мотоциклов моделей: " + VehicleUtils.getAverageModelPrice(m));

        System.out.println(m.getMod());
    }
}