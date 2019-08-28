import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {


        String line = "_______________________________________\n";
        System.out.print(line);
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?\n");
        System.out.print(line);

        Scanner input = new Scanner(System.in);
        while(true){
            String command = input.nextLine();
            if (command.equals("list") ){
                System.out.print(line+"list\n"+line);
            }else if (command.equals("blah")){
                System.out.print(line+"blah\n"+line);
            }else if (command.equals("bye")){
                System.out.print(line+"Bye. Hope to see you again soon!\n"+line);
                System.exit(0);
            }else{
                System.out.println("error");
            }
        }



    }
}
