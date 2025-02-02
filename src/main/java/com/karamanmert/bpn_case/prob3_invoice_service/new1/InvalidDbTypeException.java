package prob3_invoice_service.new1;

public class InvalidDbTypeException extends RuntimeException {

    public InvalidDbTypeException(String message) {
        super(message);
    }
}