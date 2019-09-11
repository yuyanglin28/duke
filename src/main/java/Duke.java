/**
 * this is a Duke class
 * @author Lin Yuyang
 * @version 2019.09.09
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Duke {


    //Storage: deals with loading tasks from the file and saving tasks in the file
    //Parser: deals with making sense of the user command
    //TaskList: contains the task list e.g., it has operations to add/delete tasks in the list

    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    public Duke(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.load());
        } catch (DukeException e) {
            ui.showLoadingError();
            tasks = new TaskList();
        }
    }

    public void run() {
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                ui.showLine();
                Command c = Parser.parse(fullCommand);
                c.execute(tasks, ui, storage);
                isExit = c.isExit();
            } catch (DukeException e) {
                ui.showError(e.getMessage());
            } finally {
                ui.showLine();
            }
        }
    }

    public static void main(String[] args) {
        new Duke("/Users/linyy/Desktop/duke/src/main/java/data/duke.txt").run();
    }
}
