public class DeleteCommand extends Command {
    int index;
    public DeleteCommand(int index){
        this.index = index-1;
    }
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {

        if (index < 0 || index > tasks.getSize()-1){
            throw new DukeException("Invalid index");
        }else {
            ui.showDelete(index, tasks);
        }
    }
}
