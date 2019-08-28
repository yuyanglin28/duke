import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {

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
            System.out.print(line);

            if (command.equals("list") ){
                System.out.println("Here are the tasks in your list:");
                for ( int j = 0; j<i; j++){
                    System.out.println(j+1+"."+taskList[j]);
                }
            }else if (command.equals("bye")){
                System.out.println("Bye. Hope to see you again soon!");
                System.exit(0);
            }
            else if (command.equals("done")){
                int index = input.nextInt();
                System.out.println("Nice! I've marked this task as done:");
                taskList[index-1].changeStatusIcon();
                System.out.println("  "+taskList[index-1]);
            }

            else if (command.equals("todo")){
                String content = input.nextLine();
                taskList[i] = new Todo(content);
                System.out.println("Got it. I've added this task:");
                System.out.println("  "+taskList[i].toString());
                i++;
                System.out.println("Now you have "+i+" tasks in the list.");
            }else if (command.equals("deadline")){
                String content = input.nextLine();
                String d, t;
                for (int k=0; k<content.length(); k++){
                    if (content.charAt(k)=='/'){
                        d = content.substring(0, k-1);
                        t = content.substring(k+4);
                        taskList[i] = new Deadline(d, t);
                        break;
                    }
                }
                System.out.println("Got it. I've added this task:");
                System.out.println("  "+taskList[i]);
                i++;
                System.out.println("Now you have "+i+" tasks in the list.");
            }else if (command.equals("event")){
                String content = input.nextLine();
                String d, t;
                for (int k=0; k<content.length(); k++){
                    if (content.charAt(k)=='/'){
                        d = content.substring(0, k-1);
                        t = content.substring(k+4);
                        taskList[i] = new Event(d, t);
                        break;
                    }
                }
                System.out.println("Got it. I've added this task:");
                System.out.println("  "+taskList[i]);
                i++;
                System.out.println("Now you have "+i+" tasks in the list.");
            }else{
                System.out.println("blah");
            }

            System.out.print(line);
        }
    }



}


