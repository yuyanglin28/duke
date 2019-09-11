import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskList {

    private ArrayList<Task> taskList;

    public TaskList(){
        taskList = new ArrayList<Task>();
    }

    public TaskList(Scanner inFile) throws DukeException{

        taskList = new ArrayList<Task>();
        while(inFile.hasNext()){
            String type = inFile.next();
            String useless = inFile.next();
            String status = inFile.next();
            useless = inFile.next();
            String content = inFile.nextLine();

            if (type.equals("T") ){
                taskList.add(new Todo(content));
                if (status.equals("1"))
                    taskList.get(taskList.size()-1).changeStatusIcon();
            }else if (type.equals("D")){
                String d, t;
                for (int k = 0; k < content.length(); k++) {
                    if (content.charAt(k) == '|') {
                        d = content.substring(0, k - 1);
                        t = content.substring(k + 2);
                        taskList.add(new Deadline(d, t));
                        if (status.equals("1"))
                            taskList.get(taskList.size()-1).changeStatusIcon();
                        break;
                    }
                }

            }else if (type.equals("E")){
                String d, t;
                for (int k = 0; k < content.length(); k++) {
                    if (content.charAt(k) == '|') {
                        d = content.substring(0, k - 1);
                        t = content.substring(k + 2);
                        taskList.add(new Event(d, t));
                        if (status.equals("1"))
                            taskList.get(taskList.size()-1).changeStatusIcon();
                        break;
                    }
                }
            }else{
                throw new DukeException("Fail to read the content of the file.");
            }
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
