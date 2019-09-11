public class ExitCommand extends Command {

    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        storage.write(tasks);
    }

    public boolean isExit(){
        return true;
    }
}
