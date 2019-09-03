public class DeleteCommand extends Command {
    int index;
    public DeleteCommand(int index){
        this.index = index-1;
    }
    public void execute(TaskList tasks, Ui ui, Storage storage){
        ui.showDelete(index, tasks);
    }
}
