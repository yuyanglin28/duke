public class FindCommand extends Command {

    String key;

    public FindCommand (String key){
        this.key = key;
    }
    public void execute(TaskList tasks, Ui ui, Storage storage){
        ui.showFind(tasks, key);
    }
}

