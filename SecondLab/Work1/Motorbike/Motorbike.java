package Work1.Motorbike;

import java.util.Arrays;

public class Motorbike {
    private int size = 0;
    private Model head;
    private long lastModif;
    private String make;

    public Motorbike(String make, int numModels) {
        this.make = make;

        head = new Model();
        head.next=head;
        head.prev=head;

        Model k;
        for (int i = 0; i < numModels; i++) {
            k = new Model("Model" + (i + 1), 0);
            k.next=head;
            k.prev=head.prev;
            head.prev.next=k;
            head.prev=k;
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

    public void setModelName(int index, String name) {
        if(head!=null){
            Model tmp = head.next;
            int i =0;
            while((tmp!=head)&&(i!=index)){
                tmp=tmp.next;
                i++;
            }
            if(tmp!=head){
                tmp.name=name;
            }
        }
    }

    public String[] getModelNames() {
        Model tmp = head.next;
        String[] names = new String[getModelCount()];
        for (int i = 0; i < getModelCount(); i++) {
            names[i] = tmp.name;
            tmp=tmp.next;
        }
        return names;
    }

    public double getModelPrice(String name) {
        if(head!=null){
            Model tmp = head.next;
            while(tmp!=head){
                if (tmp.name.equals(name)) {
                    return tmp.price;
                }
                tmp=tmp.next;
            }
        }
        return -1;
    }

    public void setModelPrice(String name, double price) {
        if(head!=null){
            Model tmp = head.next;
            while(tmp!=head){
                if (tmp.name.equals(name)) {
                    tmp.setPrice(price);
                    break;
                }
                tmp = tmp.next;
            }
        }
    }

    public double[] getModelPrices() {
        double[] prices = new double[getModelCount()];
        Model k = head.next;
        for (int i = 0; i < getModelCount(); i++) {
            prices[i] = k.getPrice();
            k=k.next;
        }
        return prices;
    }

    public void addModel(String name, double price) {
        if(head!=null){
            Model k;
            k = new Model(name, price);
            k.next=head;
            k.prev=head.prev;
            head.prev.next=k;
            head.prev=k;
        }
    }

    public void removeModel(String name) {
        if(head!=null){
            Model tmp = head.next;
            while((tmp!=head)&&(!(tmp.name.equals(name)))){
                tmp=tmp.next;
            }
            if(tmp!=head){
                tmp.prev.next=tmp.next;
                tmp.next.prev=tmp.prev;
            }
        }
    }
 
    public int getModelCount() {
        int k = 0;
        if(head!=null){
            Model tmp = head.next;
            while(tmp!=head){
                k++;
                tmp=tmp.next;
            }
        }
        return k;
    }
    private class Model {

        //полe название модели
        private String name;

        //поле цены
        private double price;

        Model prev = null; 
        Model next = null;

        public Model(){

        }
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
