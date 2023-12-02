package Work2;

public class DuplicateModelNameException extends Exception{
    public DuplicateModelNameException(String models){
        super("Модель "+models+" уже есть.");
    }
}
