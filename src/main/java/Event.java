public class Event extends Task {
    public Event(String description){
        super(description);
    }

    @Override
    public String getType() {
        return "E";
    }
}
