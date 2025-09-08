public class Deadline extends Task{

    public Deadline(String description) {
        super(description);
    }

    @Override
    public String getType() {
        return "D";
    }

    public String getDeadline() {
        String[] parts = this.description.split("/by", 2);
        return parts[1];
    }

    public String getDeadlineDescription() {
        String[] parts = this.description.split("/", 2);
        return parts[0];
    }

    @Override
    public void printAddedTask() {
        Siao.printDividerLine();
        System.out.printf("Nicely done! I've added this task:\n[%s][%s] %s(by:%s)\n",
                getType(), getStatusIcon(), this.description, getDeadline());

    }

}
