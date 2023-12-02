package Work2;

public class ModelPriceOutOfBoundException extends RuntimeException{
    public ModelPriceOutOfBoundException(){
        super("Некорректное число");
    }
}
