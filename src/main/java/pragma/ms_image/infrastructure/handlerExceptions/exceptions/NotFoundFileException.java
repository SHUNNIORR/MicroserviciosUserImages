package pragma.ms_image.infrastructure.handlerExceptions.exceptions;

public class NotFoundFileException extends RuntimeException{
    public NotFoundFileException(){
        super("No se encontró usuario.");
    }
}
