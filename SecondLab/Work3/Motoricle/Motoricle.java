package Work3.Motoricle;

import java.util.Arrays;

import Work3.DuplicateModelNameException;
import Work3.ModelPriceOutOfBoundException;
import Work3.NoSuchModelNameException;
import Work3.Vehicle.Vehicle;

public class Motoricle implements Vehicle {
    private int size = 0;
    private Model head;
    private long lastModif;
    private String make;

    public Motoricle(String make, int numModels) {
        this.make = make;

        this.size=numModels;

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

    {
        lastModif=System.currentTimeMillis();
    }

    public Long getMod(){
        return lastModif;
    }

    //метод для получения марки автомобиля,
    public String getMake() {
        return this.make;
    }

    //метод для модификации марки автомобиля,
    public void setMake(String make) {
        this.make = make;
        lastModif = System.currentTimeMillis();
    }

    public void setModelName(int index, String name) throws DuplicateModelNameException, NoSuchModelNameException{
        if(head!=null){
            Model tmp = head.next;
            while(tmp!=head){
                if(tmp.name.equals(name)){
                    throw new DuplicateModelNameException(name);
                }
                tmp=tmp.next;
            }
            tmp=head.next;
            int i =0;
            while((tmp!=head)&&(i!=index)){
                tmp=tmp.next;
                i++;
            }
            if(tmp!=head){
                tmp.name=name;
            }
            lastModif = System.currentTimeMillis();
        }
    }

    public void ModifName(String name, String oldName) throws NoSuchModelNameException, DuplicateModelNameException{
        if(head!=null){
            Model tmp = head.next;
            Model tmp1 = null;
            while(tmp!=head){
                if(tmp.name.equals(name)){
                    throw new DuplicateModelNameException(name);
                }
                else if(tmp.name.equals(oldName)){
                    tmp1=tmp;
                }
                tmp=tmp.next;
            }
            if(tmp1==null){
                throw new NoSuchModelNameException(oldName);
            }
            else{
                tmp1.name=name;
            }
            lastModif = System.currentTimeMillis();
        }//!!! логические проверки сократить (vrode sdelal)
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

    public double getModelPrice(String name) throws NoSuchModelNameException {
        if(head!=null){
            Model tmp = head.next;
            while(tmp!=head && !(tmp.name.equals(name))){
                tmp=tmp.next;
            }
            if(tmp==head){
                throw new NoSuchModelNameException(name);
            }
            lastModif = System.currentTimeMillis();
            return tmp.price;
        }
        return 0;
    }

    public void setModelPrice(String name, double price) throws NoSuchModelNameException {
        if(price<0){
            throw new ModelPriceOutOfBoundException();
        }
        if(head!=null){
            Model tmp = head.next;
            while(tmp!=head){
                if (tmp.name.equals(name)) {
                    tmp.setPrice(price);
                    break;
                }
                tmp = tmp.next;
            }
            if(tmp==head){
                throw new NoSuchModelNameException(name);
            }
            else{
                tmp.name=name;
            }
            lastModif = System.currentTimeMillis();
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

    public void addModel(String name, double price) throws DuplicateModelNameException{
        if(price<0){
            throw new ModelPriceOutOfBoundException();
        }
        if(head!=null){
            Model tmp = head.next;
            while(tmp!=head){
                if(tmp.name.equals(name)){
                    throw new DuplicateModelNameException(name);
                }
                tmp=tmp.next;
            }
            Model k;
            k = new Model(name, price);
            k.next=head;
            k.prev=head.prev;
            head.prev.next=k;
            head.prev=k;
            lastModif = System.currentTimeMillis();
            size++;
        }// price size
    }

    public void removeModel(String name) throws NoSuchModelNameException{
        if(head!=null){
            Model tmp = head.next;
            while((tmp!=head)&&(!(tmp.name.equals(name)))){
                tmp=tmp.next;
            }
            if(tmp!=head){
                tmp.prev.next=tmp.next;
                tmp.next.prev=tmp.prev;
            }
            else{
                throw new NoSuchModelNameException(name);
            }
            lastModif = System.currentTimeMillis();
            size--;
        }
    }
 
    public int getModelCount() {//size
        return size;
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
