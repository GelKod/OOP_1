package Work2;

public class NoSuchModelNameException extends Exception{
    public NoSuchModelNameException(String n){
        super("Модель "+n+" не найдена.");
    }
}