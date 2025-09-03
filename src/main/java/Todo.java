public class Todo extends Task{

    public Siao.Label taskType = Siao.Label.TODO;

    public Todo(String Description) {
        super(Description);
        isDone = false;
    }

    public static String toDoLabel(){
        return "T";
    }

    public static void printAction(String action){
        Siao.printDividerLine();
        System.out.printf("Got it! Added this task in!\n [%s][ ] %s\n",toDoLabel(),action);
        Siao.printDividerLine();
    }

    public void printMarkDone() {
        System.out.println("Good job on completing the task!");
        System.out.printf("[%s][%s] %s\n",toDoLabel(), getStatusIcon(), description);
        Siao.printDividerLine();
    }

}
