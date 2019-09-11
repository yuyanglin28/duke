import java.io.*;
import java.util.Scanner;

/**
 * Storage: deals with loading tasks from the file and saving tasks in the file
 */
public class Storage {
    private String filePath;
    public Storage(String filePath){
        this.filePath = filePath;
    }

    public Scanner load() throws DukeException{
        try {
            Scanner inFile = new Scanner(new FileReader(filePath));
            return inFile;
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
            throw new DukeException("Fail to load the file.");
           //
        }
    }

    public void write(TaskList tasks) throws DukeException {
       try {
           PrintWriter outFile = new PrintWriter(filePath);

           for (int j = 0; j < tasks.getSize(); j++) {
               Task task = tasks.get(j);
               if (task instanceof Todo) {
                   outFile.println("T | " + task.getStatus() + " | " + task.getDescription());
               } else if (task instanceof Deadline) {
                   outFile.println("D | " + task.getStatus() + " | " + task.getDescription() + " | " + ((Deadline) task).getBy());
               } else if (task instanceof Event) {
                   outFile.println("E | " + task.getStatus() + " | " + task.getDescription() + " | " + ((Event) task).getAt());
               }

           }
           outFile.close();
       }catch (FileNotFoundException e){
               throw new DukeException("Fail to write the file");
           }


    }

}
