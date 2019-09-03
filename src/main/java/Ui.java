import java.util.Scanner;

/**
 * Ui: deals with interactions with the user
 */
public class Ui {
    private String line = "_______________________________________\n";
    private Scanner input = new Scanner(System.in);

    public void showWelcome(){

        System.out.print(line);
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
        System.out.print(line);
    }

    public void showLoadingError(){
        System.out.println("Fail to load the file.");
    }

    public String readCommand(){
        String command = input.nextLine();
        return command;

    }

    public void showLine(){
        System.out.print(line);
    }

    public void showError(String s){
        System.out.println(s);

    }
    public void showList(){
        System.out.println("Here are the tasks in your list:");
    }
    public void showDone(int index, TaskList tasks){
        System.out.println("Nice! I've marked this task as done:");
        System.out.println("  " + tasks.get(index));
    }
    public  void showAdd(TaskList tasks) {
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + tasks.get(tasks.getSize()-1));
        System.out.println("Now you have " + tasks.getSize() + " tasks in the list.");
    }
    public void showDelete(int index, TaskList tasks){
        System.out.println("Noted. I've removed this task:");
        System.out.println("  " + tasks.get(index));
        tasks.remove(index);
        System.out.println("Now you have " + tasks.getSize() + " tasks in the list.");
    }
    public void showFind(TaskList tasks, String key){
        System.out.println("Here are the matching tasks in your list:");
        int k = 1;
        for (int j = 0; j<tasks.getSize(); j++){
            if (tasks.get(j).getDescription().contains(key)){
                System.out.println(k+"."+tasks.get(j));
                k++;
            }
        }
    }
}
