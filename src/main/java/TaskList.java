import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskList {

    private ArrayList<Task> taskList;

    public TaskList(){
        taskList = new ArrayList<Task>();
    }

    public TaskList(Scanner inFile) throws DukeException{

        System.out.println("lala");

        taskList = new ArrayList<Task>();
        while(inFile.hasNext()){
            String message = inFile.nextLine();
            System.out.println(message);
            String[] ss = message.split("\\s");
            String type = ss[0];
            String status = ss[2];

            if (type.equals("T") ){
                String content = "";
                for (int i = 4; i<ss.length - 1; i++){
                    content = content + ss[i] + " ";
                }
                content = content + ss[ss.length - 1];
                taskList.add(new Todo(content));

            }else if (type.equals("D") || type.equals("E")){
                String d = "";
                String t = "";
                int i = 4;
                while (! ss[i+1].equals("|")){
                    d = d + ss[i] + " ";
                    i += 1;
                }
                d = d + ss[i];
                for (int j = i+2; j<ss.length-1; j++){
                        t = t + ss[j] + " ";
                }
                t = t + ss[ss.length - 1];

                if (type.equals("D"))
                    taskList.add(new Deadline(d, t));
                else
                    taskList.add(new Event(d, t));

            }else{
                System.out.println("hhhhhhhhh");
                throw new DukeException("Fail to read the content of the file.");
            }
            if (status.equals("1"))
                taskList.get(taskList.size()-1).changeStatusIcon();


        }

        inFile.close();


    }

    public void markAsDone(int index){
        taskList.get(index).changeStatusIcon();
    }

    public int getSize(){
        return taskList.size();
    }

    public Task get(int index){
        return taskList.get(index);
    }

    public void add(Task task){
        taskList.add(task);
    }

    public void remove(int index){
        taskList.remove(index);
    }


}
