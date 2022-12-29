package SpringR.RestIpi.rest.configuration.ExeptionHanding;

public class NoSuchEmloyeeExeption extends RuntimeException{
    public NoSuchEmloyeeExeption(String message) {
        super(message);
    }
}
