public class TimeInUseException extends Exception{

    public TimeInUseException(){
        super("Please select a time slot not in use");
    }

}
