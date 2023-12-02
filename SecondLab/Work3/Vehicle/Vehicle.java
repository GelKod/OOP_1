package Work3.Vehicle;

import Work3.DuplicateModelNameException;
import Work3.ModelPriceOutOfBoundException;
import Work3.NoSuchModelNameException;

public interface Vehicle {
    String getMake();
    void setMake(String make);
    void ModifName(String name, String Oldname ) throws NoSuchModelNameException, DuplicateModelNameException;
    void setModelName(int index, String name) throws DuplicateModelNameException, NoSuchModelNameException;
    String[] getModelNames();
    double getModelPrice(String name) throws NoSuchModelNameException;
    void setModelPrice(String name, double price) throws NoSuchModelNameException;
    double[] getModelPrices();
    void addModel(String name, double price) throws DuplicateModelNameException;
    void removeModel(String name) throws NoSuchModelNameException;
    int getModelCount();
}