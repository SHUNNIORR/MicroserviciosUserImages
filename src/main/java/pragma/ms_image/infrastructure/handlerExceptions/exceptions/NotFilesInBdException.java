package pragma.ms_image.infrastructure.handlerExceptions.exceptions;

public class NotFilesInBdException extends RuntimeException{
    public NotFilesInBdException(){
        super("No existen registros de usuarios.");
    }
}
