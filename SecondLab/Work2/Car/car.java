package Work2.Car;

import java.util.Arrays;

import Work2.DuplicateModelNameException;
import Work2.ModelPriceOutOfBoundException;
import Work2.NoSuchModelNameException;

public class car {

    //поле типа String, хранящее марку автомобиля,
    private String make;

    //класс Автомобиль хранит массив Моделей
    private Model[] models;

    

    public car(String make, int numModels) {
        this.make = make;
        this.models = new Model[numModels];
        for (int i = 0; i < numModels; i++) {
            this.models[i] = new Model("Model" + (i + 1), 0);
        }
    }

    //метод для получения марки автомобиля,
    public String getMake() {
        return this.make;
    }
    
    //метод для модификации марки автомобиля,
    public void setMake(String make) {
        this.make = make;
    }

    public void setModelName(int index, String name) throws DuplicateModelNameException {
        for(int i = 0; i<getModelCount();i++ ){
            if(models[i].name==name){
                throw new DuplicateModelNameException(name);
            }
        }
        this.models[index].setName(name);
    }

    public String[] getModelNames() {
        String[] names = new String[this.models.length];
        for (int i = 0; i < this.models.length; i++) {
            names[i] = this.models[i].getName();
        }
        return names;
    }

    public double getModelPrice(String name) throws NoSuchModelNameException{
        double chek=-1;
        for (Model model : this.models) {
            if (model.getName().equals(name)) {
                chek = model.getPrice();
            }
        }
        if(chek==-1){
            throw new NoSuchModelNameException(name);
        }
        return chek;
    }

    public void setModelPrice(String name, double price) throws NoSuchModelNameException, ModelPriceOutOfBoundException {
        double chek=-1;
        if(price>0){
            for (Model model : this.models) {
                if (model.getName().equals(name)) {
                    model.setPrice(price);
                    chek=2;
                }
            }
        }
        else{
            throw new ModelPriceOutOfBoundException();
        }
        if(chek==-1){
            throw new NoSuchModelNameException(name);
        }
    }

    public double[] getModelPrices() {
        double[] prices = new double[this.models.length];
        for (int i = 0; i < this.models.length; i++) {
            prices[i] = this.models[i].getPrice();
        }
        return prices;
    }

    public void addModel(String name, double price) throws DuplicateModelNameException, ModelPriceOutOfBoundException{
        if(price<0){
            throw new ModelPriceOutOfBoundException();
        }
        for(int i = 0; i<getModelCount();i++ ){
            if(models[i].name==name){
                throw new DuplicateModelNameException(name);
            }
        }
        this.models = Arrays.copyOf(this.models, this.models.length + 1);
        this.models[this.models.length - 1] = new Model(name, price);
    }

    public void removeModel(String name) throws NoSuchModelNameException {
        int index = -1;
        for (int i = 0; i < this.models.length; i++) {
            if (this.models[i].getName().equals(name)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            throw new NoSuchModelNameException(name);
        }
        else{
            Model[] newModels = new Model[this.models.length - 1];
            System.arraycopy(this.models, 0, newModels, 0, index);
            System.arraycopy(this.models, index + 1, newModels, index, this.models.length - index - 1);
            this.models = newModels;
        }
    }

    public int getModelCount() {
        return this.models.length;
    }

    private class Model {

        //полe название модели
        private String name;

        //поле цены
        private double price;

        //конструктор
        public Model(String name, double price) {
            this.name = name;
            this.price = price;
        }

        //получение названия
        public String getName() {
            return this.name;
        }

        //изменение названия
        public void setName(String name) {
            this.name = name;
        }

        //получение цены
        public double getPrice() {
            return this.price;
        }

        //изменение цены
        public void setPrice(double price) {
            this.price = price;
        }
    }
}