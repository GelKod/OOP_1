package Work3.VehicleUtils;

import Work3.Vehicle.Vehicle;

public class VehicleUtils {
    public static double getAverageModelPrice(Vehicle vehicle) {
        double[] prices = vehicle.getModelPrices();
        double sum = 0;
        for (double price : prices) {
            sum += price;
        }
        return sum / prices.length;
    }

    public static void printAllModelNames(Vehicle vehicle) {
        String[] names = vehicle.getModelNames();
        for (String name : names) {
            System.out.println(name);
        }
    }

    public static void printAllModelPrices(Vehicle vehicle) {
        String[] names = vehicle.getModelNames();
        double[] prices = vehicle.getModelPrices();
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i] + ": " + prices[i]);
        }
        System.out.println();
    }
}