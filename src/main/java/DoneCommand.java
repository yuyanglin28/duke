public class DoneCommand extends Command {
    int index;
    public DoneCommand(int index){
        this.index = index-1;
    }
    public void execute(TaskList tasks, Ui ui, Storage storage){
        tasks.markAsDone(index);
        ui.showDone(index, tasks);
    }
}
