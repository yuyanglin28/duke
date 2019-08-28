import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {

        String[] inputList = new String[100];
        Task[] taskList = new Task[100];
        int i = 0;


        String line = "_______________________________________\n";
        System.out.print(line);
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
        System.out.print(line);

        Scanner input = new Scanner(System.in);
        while(true){
            String command = input.next();
            if (command.equals("list") ){
                System.out.print(line);
                System.out.println("Here are the tasks in your list:");
                for ( int j = 0; j<i; j++){
                    System.out.println(j+1+".["+taskList[j].getStatusIcon()+"]"+inputList[j]);
                }
                System.out.print(line);
            }else if (command.equals("blah")){
                System.out.print(line+"blah\n"+line);
            }else if (command.equals("bye")){
                System.out.print(line+"Bye. Hope to see you again soon!\n"+line);
                System.exit(0);
            } else if (command.equals("done")){
                int index = input.nextInt();
                System.out.println(line+"Nice! I've marked this task as done:");
                taskList[index-1].changeStatusIcon();
                System.out.println("  ["+taskList[index-1].getStatusIcon()+"]  "+inputList[index-1]);
                System.out.print(line);
            }
            else{
                inputList[i] = command;
                taskList[i] = new Task(command);
                System.out.print(line+"added:"+command+"\n"+line);
                i++;
            }
        }
    }



}


