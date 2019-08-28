import java.io.*;
import java.util.Scanner;

public class Duke {
    static Task[] taskList = new Task[100];
    static int i = 0;

    public static void main(String[] args) throws FileNotFoundException {

        String line = "_______________________________________\n";

        System.out.print(line);
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
        System.out.print(line);


        Scanner inFile = new Scanner(new FileReader("/Users/linyy/Desktop/duke/src/main/java/data/duke.txt"));
        while(inFile.hasNext()){
            String type = inFile.next();
            String useless = inFile.next();
            String status = inFile.next();
            useless = inFile.next();
            String content = inFile.nextLine();

            if (type.equals("T") ){
                taskList[i] = new Todo(content);
                if (status.equals("1"))
                    taskList[i].changeStatusIcon();
                i++;
            }else if (type.equals("D")){
                String d, t;
                for (int k = 0; k < content.length(); k++) {
                    if (content.charAt(k) == '|') {
                        d = content.substring(0, k - 1);
                        t = content.substring(k + 2);
                        taskList[i] = new Deadline(d, t);
                        if (status.equals("1"))
                            taskList[i].changeStatusIcon();
                        i++;
                        break;
                    }
                }

            }else if (type.equals("E")){
                String d, t;
                for (int k = 0; k < content.length(); k++) {
                    if (content.charAt(k) == '|') {
                        d = content.substring(0, k - 1);
                        t = content.substring(k + 2);
                        taskList[i] = new Event(d, t);
                        if (status.equals("1"))
                            taskList[i].changeStatusIcon();
                        i++;
                        break;
                    }
                }
            }
        }



        Scanner input = new Scanner(System.in);
        boolean valid;

        while (true) {
            String command = input.next();
            System.out.print(line);
            valid = true;

            try {
                if (command.equals("list")) {
                    System.out.println("Here are the tasks in your list:");
                    for (int j = 0; j < i; j++) {
                        System.out.println(j + 1 + "." + taskList[j]);
                    }
                } else if (command.equals("bye")) {
                    System.out.println("Bye. Hope to see you again soon!");
                    System.exit(0);
                } else if (command.equals("done")) {
                    int index = input.nextInt();
                    System.out.println("Nice! I've marked this task as done:");
                    taskList[index - 1].changeStatusIcon();
                    System.out.println("  " + taskList[index - 1]);
                } else if (command.equals("todo")) {
                    try {
                        String content = input.nextLine();
                        validateInput(content);
                        taskList[i] = new Todo(content);
                        outputTask(i);

                    } catch (DukeException e) {
                        System.out.println("OOPS!!! The description of a todo cannot be empty.");
                    }

                } else if (command.equals("deadline")) {
                    String content = input.nextLine();
                    String d, t;
                    for (int k = 0; k < content.length(); k++) {
                        if (content.charAt(k) == '/') {
                            d = content.substring(0, k - 1);
                            t = content.substring(k + 4);
                            taskList[i] = new Deadline(d, t);
                            break;
                        }
                    }
                    outputTask(i);
                } else if (command.equals("event")) {
                    String content = input.nextLine();
                    String d, t;
                    for (int k = 0; k < content.length(); k++) {
                        if (content.charAt(k) == '/') {
                            d = content.substring(0, k - 1);
                            t = content.substring(k + 4);
                            taskList[i] = new Event(d, t);
                            break;
                        }
                    }
                    outputTask(i);

                } else {
                    valid = false;
                }

                validateCommand(valid);
            } catch (DukeException e) {
                System.out.println("OOPS!!! I'm sorry, but I don't know what that means :-(");
            }

            System.out.print(line);
        }
    }

    public static void outputTask(int i) {
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + taskList[i]);
        i++;
        System.out.println("Now you have " + i + " tasks in the list.");
    }

    public static void validateInput(String s) throws DukeException {
        if (s.equals(""))
            throw new DukeException("The description of this command cannot be empty.");
    }

    public static void validateCommand(boolean valid) throws DukeException {
        if (valid == false)
            throw new DukeException("The command is not valid");
    }


}


