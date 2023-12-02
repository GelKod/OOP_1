package Work1.Number;

import Work1.Car.car;
import Work1.Motorbike.Motorbike;

public class Number1 {
    public static void main(String[] args){
        car c = new car("Pezho", 5);
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
        System.out.println("\nЦена Skuline : "+c.getModelPrice("Skuline"));
        String[] aboba = c.getModelNames();
        System.out.println("\nSpisok modeley: ");
        for(int i = 0; i< aboba.length;i++){
            System.out.println(aboba[i]);
        }
        double[] aboba2 = c.getModelPrices();
        System.out.println("\nSpisok cen: ");
        for(int i = 0; i< aboba2.length;i++){
            System.out.println(aboba2[i]);
        }
        c.addModel("m5",700);
        c.removeModel("Solyaris");
        aboba = c.getModelNames();
        System.out.println("\nSpisok modeley: ");
        for(int i = 0; i< aboba.length;i++){
            System.out.println(aboba[i]);
        }
        aboba2 = c.getModelPrices();
        System.out.println("\nSpisok cen: ");
        for(int i = 0; i< aboba2.length;i++){
            System.out.println(aboba2[i]);
        }

        Motorbike m = new Motorbike("BMW", 6);
        System.out.println("\nMarka: "+m.getMake());
        m.setModelName(2, "Granta");
        m.setModelPrice("Granta",1000);
        m.setModelName(1, "Kalina");
        m.setModelPrice("Kalina",3000);
        m.setModelName(3, "Vesta");
        m.setModelPrice("Vesta",500);
        m.setModelName(0, "Honda");
        m.setModelPrice("Honda",4000);
        m.setModelName(4, "Dio");
        m.setModelPrice("Dio",100);
        m.setModelName(5, "Dior");
        m.setModelPrice("Dior",100);
        System.out.println("\nЦена Dio : "+m.getModelPrice("Dio"));
        aboba = m.getModelNames();
        System.out.println("\nSpisok modeley: ");
        for(int i = 0; i< aboba.length;i++){
            System.out.println(aboba[i]);
        }
        aboba2 = m.getModelPrices();
        System.out.println("\nSpisok cen: ");
        for(int i = 0; i< aboba2.length;i++){
            System.out.println(aboba2[i]);
        }
        m.addModel("x5",700);
        m.removeModel("Vesta");
        aboba = m.getModelNames();
        System.out.println("\nSpisok modeley: ");
        for(int i = 0; i< aboba.length;i++){
            System.out.println(aboba[i]);
        }
        aboba2 = m.getModelPrices();
        System.out.println("\nSpisok cen: ");
        for(int i = 0; i< aboba2.length;i++){
            System.out.println(aboba2[i]);
        }
    }
}