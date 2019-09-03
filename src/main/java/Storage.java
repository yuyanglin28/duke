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
            throw new DukeException("Fail to load the file.");
        }
    }
}
