package in.bassure.training.batch7.java;

public class WaterBottleConsumeException extends IllegalArgumentException{

    public WaterBottleConsumeException() {
        super();
    }

    public WaterBottleConsumeException(String s) {
        super(s);
    }

    public WaterBottleConsumeException(String message, Throwable cause) {
        super(message, cause);
    }

    public WaterBottleConsumeException(Throwable cause) {
        super(cause);
    }
    
}
